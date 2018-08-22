package com.wxl.springbootredis.controller;

import com.wxl.springbootredis.entity.User;
import com.wxl.springbootredis.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/getUser")
    @Cacheable(value="user")
    @ResponseBody
    public User getUser(){
        User user=userRepository.findByUserName("注册2");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }


}
