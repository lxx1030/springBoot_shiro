package com.yx1030.springbootshiro.controller;

import com.yx1030.springbootshiro.pojo.User;
import com.yx1030.springbootshiro.service.UserService;
import com.yx1030.springbootshiro.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "list")
    public PageResult userList(User user,Integer page,Integer rows){
        return userService.selectUserList(user, page, rows);
    }


}
