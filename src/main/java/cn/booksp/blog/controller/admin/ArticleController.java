package cn.booksp.blog.controller.admin;

import cn.booksp.blog.common.pojo.Article;
import cn.booksp.blog.common.pojo.Type;
import cn.booksp.blog.service.ArticleService;
import cn.booksp.blog.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    StoreService storeService;
    @Autowired
    ArticleService articleService;

    public final String uploadDir = "/upload/";

    @GetMapping("/list")
    public String list(ModelMap modelMap){
        List<Article> articles = articleService.findAll();
        List<Type> types = articleService.getAllType("article");
        modelMap.addAttribute("types", types);
        modelMap.addAttribute("articles", articles);
        modelMap.addAttribute("path", "admin/pages/article-list");
        modelMap.addAttribute("content", "article-list");
        return "admin/index";
    }

    @PostMapping("/add")
    public String add(Article article, MultipartFile markdown, List<MultipartFile> article_images){
        makeArticle(markdown, article);

        articleService.insert(article);
        storeService.storeMarkdown(markdown);
        storeService.storeIMG(article_images);
        return "redirect:/article/list";
    }

    @PostMapping("/multiple-add")
    public String multipleAdd(List<MultipartFile> markdowns, List<MultipartFile> images){

        for(MultipartFile markdown : markdowns){
            Article article = new Article();
            makeArticle(markdown, article);
            articleService.insert(article);
            storeService.storeMarkdown(markdown);
        }
        storeService.storeIMG(images);

        return "redirect:/article/list";
    }

    @PostMapping("/images-add")
    public String imagesAdd(List<MultipartFile> images){

        storeService.storeIMG(images);

        return "redirect:/article/list";
    }

    private void makeArticle(MultipartFile markdown, Article article) {
        String name = markdown.getOriginalFilename();
        String title = name.substring(0, name.length() - 3);
        article.setTitle(title);
        article.setAuthorId(1);
        article.setUrl("upload/md/" + name);
        article.setDate(new Date(System.currentTimeMillis()));
    }

    @ResponseBody
    @GetMapping(value = "/get/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(@PathVariable Integer id){
        Article article = articleService.get(id);
        String url =  article.getUrl();
        return storeService.loadMarkdown(url);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Article article = articleService.get(id);
        String url =article.getUrl();
        storeService.deleteMarkdown(url);
        articleService.delete(id);
        return "redirect:/article/list";
    }

    @ResponseBody
    @PostMapping("/modify/{id}")
    public Boolean modify(@PathVariable Integer id, String text, HttpServletRequest request){
        System.out.println(text);
        String upload = request.getServletContext().getRealPath("/");
        Article article = articleService.get(id);
        String url = upload + article.getUrl();
        storeService.storeModify(text,url);

        return Boolean.TRUE;
    }

}
