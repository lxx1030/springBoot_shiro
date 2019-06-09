package com.yx1030.springbootshiro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx1030.springbootshiro.mapper.UserMapper;
import com.yx1030.springbootshiro.pojo.User;
import com.yx1030.springbootshiro.service.UserService;
import com.yx1030.springbootshiro.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
    @Override
    public PageResult selectUserList(User user,Integer page,Integer rows) {
        PageHelper.startPage(page, rows);
        List<User> userList = userMapper.selectUserList(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        PageResult result = new PageResult();
        result.setTotal((int) pageInfo.getTotal());
        result.setRows(pageInfo.getList());
        return result;
    }
}
