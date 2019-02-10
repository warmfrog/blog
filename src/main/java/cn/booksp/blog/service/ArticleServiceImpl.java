package cn.booksp.blog.service;

import cn.booksp.blog.common.pojo.Article;
import cn.booksp.blog.common.pojo.Type;
import cn.booksp.blog.mapper.ArticleMapper;
import cn.booksp.blog.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleMapper.findAll();
        return articles;
    }

    @Override
    public List<Article> findAll(int pageSize, int pageIndex) {
        Map<String,Object> data = new HashMap<>();
        data.put("currentIndex", (pageIndex-1) * pageSize) ;
        data.put("pageSize", pageSize);
        return articleMapper.findAllSplit(data);
    }

    @Override
    public List<Article> findAll(String type, int pageSize, int pageIndex) {
        int typeId = typeMapper.selectIdByType(type, "article");
        Map<String,Object> data = new HashMap<>();
        data.put("currentIndex", (pageIndex-1) * pageSize) ;
        data.put("pageSize", pageSize);
        data.put("typeId", typeId);
        return articleMapper.findAllByType(data);
    }

    @Override
    public List<Type> getAllType(String scope) {
        return typeMapper.findAll(scope);
    }

    @Override
    public void insert(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public Article get(Integer id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return article;
    }

    @Override
    public void delete(Integer id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getPageCount() {
        int count = articleMapper.count();
        int pageCount = count/10;
        int remainder = count%10;
        return remainder > 0 ? pageCount + 1 : pageCount;
    }
}
