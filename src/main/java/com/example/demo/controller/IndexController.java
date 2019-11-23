package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        //获取 Cookie 集合
        Cookie[] cookies = request.getCookies();
        //判断是否Cookie是否为空
        if (cookies != null) {
            //循环的去找到用户需要登陆的token
            for (Cookie cookie : cookies) {
                //如果找到了一条记录的名称为token的
                if (cookie.getName().equals("token")) {
                    //就获取token的值
                    String token = cookie.getValue();
                    //通过token找到之前登陆的user
                    User user = userMapper.findByToken(token);
                    //如果找到了
                    if (user != null) {
                        //就将我们的用户信息放入到session中
                        request.getSession().setAttribute("user", user);
                    }
                    //找到了token值之后就结束循环
                    break;
                }
            }
        }
        return "index";
    }

}
