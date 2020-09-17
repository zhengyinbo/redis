package com.bo.redis_demo.service.impl;

import com.bo.redis_demo.entity.User;
import com.bo.redis_demo.repository.UserRepository;
import com.bo.redis_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author bo
 * @DATE 2020/9/16
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 为缓存指定不同的key
     * value 缓存的名称
     * key 缓存的key
     * condition 条件，condition="#userName.length()>2"
     * redis 会将方法的返回值缓存在名为value的Cache上
     * @return
     */
    @Override
    @Cacheable(value = "user", key = "#userId", condition = "#result != null")
    public User findByUserId(Long userId) {
        stringRedisTemplate.opsForValue().set("token", "123456");
        stringRedisTemplate.opsForValue().set("key-token","1111111");
        String value = stringRedisTemplate.opsForValue().get("token");
        System.out.println(value);
        return repository.findByUserId(userId);
    }

    /**
     * value 缓存的名称
     * key 缓存的key
     * condition 条件，condition="#userName.length()>2"
     * redis 会将方法的返回值缓存在名为value的Cache上
     * @return
     */
    @Override
    @Cacheable(value = "userList", key = "'user'")
    public List<User> getUsers() {
        System.out.println("Visited this method: /user/all");
        return repository.findAll();
    }

    /**
     * CacheEvict 更新用户信息之后，删除用户列表的缓存
     * CachePut 更新用户信息之后，更新用户信息的缓存，根据id
     * @param userId
     * @param phone
     * @param email
     */
    @Override
    @CacheEvict(value = "userList", key = "'user'")
    @CachePut(value = "user", key = "#userId")
    public User updateUser(Long userId, String phone, String email) {
        User user = findByUserId(userId);
        if (phone != null) {
            user.setPhone(phone);
        }
        if (email != null) {
            user.setEmail(email);
        }
        user.setUpdateTime(new Date());
        return saveUser(user);
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
}
