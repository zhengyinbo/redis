package com.bo.redis_demo.service;

import com.bo.redis_demo.entity.User;

import java.util.List;

/**
 * @Author bo
 * @DATE 2020/9/16
 **/


public interface UserService {

    User findByUserId(Long userId);

    List<User> getUsers();

    User updateUser(Long userId, String phone, String email);

    User saveUser(User user);

}
