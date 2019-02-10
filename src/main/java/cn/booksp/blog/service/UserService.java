package cn.booksp.blog.service;

import cn.booksp.blog.common.pojo.User;

public interface UserService {
    void addUser(User user);
    void addAdmin(User user);
}
