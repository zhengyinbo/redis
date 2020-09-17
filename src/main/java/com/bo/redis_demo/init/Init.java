package com.bo.redis_demo.init;

import com.bo.redis_demo.entity.User;
import com.bo.redis_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author bo
 * @DATE 2020/9/16
 **/

@Component
@Slf4j
public class Init implements InitializingBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("项目初始化");
        if (userService.getUsers().size() == 0){
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setUserName("user" + String.valueOf(i+1));
                user.setPhone(String.valueOf(i+1));
                user.setEmail(String.valueOf(i+1));
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                userService.saveUser(user);
            }
        }
    }
}
