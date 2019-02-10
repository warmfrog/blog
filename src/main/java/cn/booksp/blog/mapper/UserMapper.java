package cn.booksp.blog.mapper;

import cn.booksp.blog.common.pojo.Role;
import cn.booksp.blog.common.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByUsername(String username);

    List<Role> getRoles(Integer userId);

    void setRoleAdmin(int id);

    void setRoleUser(int id);
}