package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String hello(HttpServletRequest request, @CookieValue(value = "accountId", required = false) String accountId) {
        if(accountId != null) {
            //通过accountId找到之前登陆的user
            User user = userMapper.findByAccountId(accountId);
            //如果找到了
            if (user != null) {
                //就将我们的用户信息放入到session中
                request.getSession().setAttribute("user", user);
            }
        }
        return "index";
    }

}
