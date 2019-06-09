package com.yx1030.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
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
    /**
     * @Description: 用户登录方法
     * @Param: [username, password, remember, mav]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    @RequestMapping("login")
    public ModelAndView login(String username, String password, String remember, ModelAndView mav) {
        Subject subject = SecurityUtils.getSubject();
        //验证用户身份
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //判断是否选中了记住密码
        if (remember != null) {

            if (remember.equals("on")) {
                //说明选中了记住密码
                token.setRememberMe(true);
            }else {
                token.setRememberMe(false);
            }
        }
        try {
            //用验证同通过的token进行登录
            subject.login(token);
            //初始化session
            Session session = subject.getSession();
            //将登录成功的用户信息存入session
            session.setAttribute("subject", subject);
            //跳转到登录index页面
            mav.setViewName("index");
            return mav;
        } catch (UnknownAccountException e) {
            e.printStackTrace();

            return mav;

        }
    }
}
