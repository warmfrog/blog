package cn.booksp.blog.mapper;

import cn.booksp.blog.common.pojo.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<Type> findAll(String scope);

    int selectIdByType(String type, String scope);
}