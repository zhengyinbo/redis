package com.bo.redis_demo.controller;

import com.bo.redis_demo.service.UserService;
import com.bo.redis_demo.utils.Result;
import com.bo.redis_demo.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author bo
 * @DATE 2020/9/16
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result findByUserId(@PathVariable Long id){
        return ReturnResult.success(userService.findByUserId(id));
    }

    @GetMapping("/all")
    public Result getUsers(){
        return ReturnResult.success(userService.getUsers());
    }

    @PostMapping("/update")
    public Result updateUser(Long userId, String phone, String email){
        userService.updateUser(userId, phone, email);
        return ReturnResult.success();
    }
}
