package com.yx1030.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
* @Description:登录控制层
* @Author: Liu.Sx
* @Create: 2019/6/9
**/
@RestController
public class LoginController {
    @RequestMapping("login")
public ModelAndView login(String username, String password, ModelAndView mav){
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username, password);
    try {
        subject.login(token);
        Session session = subject.getSession();
        session.setAttribute("subject",subject);
        mav.setViewName("index");
        return mav;
    } catch (AuthenticationException e) {
        e.printStackTrace();
        mav.setViewName("login");
        return mav;
    }
}
}
