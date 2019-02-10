package cn.booksp.blog.mapper;

import cn.booksp.blog.common.pojo.Software;

public interface SoftwareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Software record);

    int insertSelective(Software record);

    Software selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Software record);

    int updateByPrimaryKey(Software record);
}