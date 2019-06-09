package com.yx1030.springbootshiro.service;

import com.yx1030.springbootshiro.pojo.User;
import com.yx1030.springbootshiro.utils.PageResult;

public interface UserService {
    /**
     * @Description:
     * @Param: [user]
     * @Return java.util.List<com.yx1030.springbootshiro.pojo.User>
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    PageResult selectUserList(User user, Integer page, Integer rows);

    /**
     * @Description: 通过用户名查修一条user数据 进行密码验证
     * @Param: [username]
     * @Return com.yx1030.springbootshiro.pojo.User
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    User selectByUserName(String username);
}
