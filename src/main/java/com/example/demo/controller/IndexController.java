package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //找到存放在Cookie中的记录
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        //使当前Session失效
        session.invalidate();
        return "redirect:/";
    }

}
