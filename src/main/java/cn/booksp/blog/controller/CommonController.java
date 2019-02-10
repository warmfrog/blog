package cn.booksp.blog.controller;

import cn.booksp.blog.common.pojo.Article;
import cn.booksp.blog.common.pojo.Type;
import cn.booksp.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String list(){
     return "redirect:/index/1";
    }

    @GetMapping("/t/{type}/{pageIndex}")
    public String type(@PathVariable String type,@PathVariable Integer pageIndex, ModelMap modelMap){
        List<Article> articles = articleService.findAll(type,10,pageIndex);
        return bind(modelMap, articles);
    }

    @GetMapping("/index/{pageIndex}")
    public String index(@PathVariable Integer pageIndex, ModelMap modelMap){
        List<Article> articles = articleService.findAll(10,pageIndex);
        return bind(modelMap, articles);
    }

    private String bind(ModelMap modelMap, List<Article> articles) {
        List<Type> types = articleService.getAllType("article");
        int pageCount = articleService.getPageCount();
        modelMap.addAttribute("counts", pageCount);
        modelMap.addAttribute("path", "pages/articles");
        modelMap.addAttribute("content", "articles");
        modelMap.addAttribute("articles", articles);
        modelMap.addAttribute("types", types);
        return "index";
    }

    @GetMapping("/error")
    public String error(){
        return "admin/pages/error";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable Integer id, ModelMap modelMap){
        Article article = articleService.get(id);
        List<Type> types = articleService.getAllType("article");
        modelMap.addAttribute("path", "pages/article");
        modelMap.addAttribute("content", "article");
        modelMap.addAttribute("article", article);
        modelMap.addAttribute("types", types);
        return "index";
    }

    @GetMapping("/demo/{id}")
    public String demo(@PathVariable Integer id, ModelMap modelMap){
        Article article = articleService.get(id);
        modelMap.addAttribute("path", "pages/demo");
        modelMap.addAttribute("content", "article");
        modelMap.addAttribute("article", article);
        return "index";
    }
}
