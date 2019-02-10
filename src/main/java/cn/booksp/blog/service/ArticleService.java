package cn.booksp.blog.service;

import cn.booksp.blog.common.pojo.Article;
import cn.booksp.blog.common.pojo.Type;

import java.util.List;

public interface ArticleService {

    /**
     * 获取所有文章
     * @return
     */
     List<Article> findAll();

    /**
     * 分页查询,从第一页开始查询
     * @param pageSize 每页面数量
     * @param pageIndex 页面索引
     * @return
     */
     List<Article> findAll(int pageSize, int pageIndex);

    /**
     * 根据类型分页查找
     * @param type
     * @param pageSize
     * @param pageIndex
     * @return
     */
    List<Article> findAll(String type, int pageSize, int pageIndex);

    /**
     * 根据作用域找到所有类型
     * @param scope
     * @return
     */
     List<Type> getAllType(String scope);

    void insert(Article article);

    Article get(Integer id);

    void delete(Integer id);

    int getPageCount();
}
