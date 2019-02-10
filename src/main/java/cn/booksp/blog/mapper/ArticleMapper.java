package cn.booksp.blog.mapper;

import cn.booksp.blog.common.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> findAll();

    List<Article>findAllSplit(Map<String,Object> data);

    List<Article>findAllByType(Map<String,Object> data);

    int count();
}