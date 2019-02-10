package cn.booksp.blog.mapper;

import cn.booksp.blog.common.pojo.AccessLog;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccessLog record);

    int insertSelective(AccessLog record);

    AccessLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccessLog record);

    int updateByPrimaryKey(AccessLog record);
}