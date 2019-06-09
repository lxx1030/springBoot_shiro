package com.yx1030.springbootshiro.mapper;

import com.yx1030.springbootshiro.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * @Description: 查询User列表
     * @Param: [user]
     * @Return java.util.List<com.yx1030.springbootshiro.pojo.User>
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    List<User> selectUserList(@Param("user") User user);

}