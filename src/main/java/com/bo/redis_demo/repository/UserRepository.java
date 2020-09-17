package com.bo.redis_demo.repository;

import com.bo.redis_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author bo
 * @DATE 2020/9/16
 **/


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

}
