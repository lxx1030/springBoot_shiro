package com.yx1030.springbootshiro.realm;

import com.yx1030.springbootshiro.pojo.User;
import com.yx1030.springbootshiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @Description: shiro身份认证
     * @Param: [authenticationToken]
     * @Return org.apache.shiro.authc.AuthenticationInfo
     * @Author: Liu.Sx
     * @Create: 2019/6/9
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("====================身份校验开始====================");
        //获取用户名
        String userName = authenticationToken.getPrincipal().toString();
        System.out.println("正在验证的用户是:" + userName);
        //根据用户名查询一条user信息
        User user = userService.selectByUserName(userName);
        if (user == null) {
            //没有找到账号
            throw new UnknownAccountException();
        }
        //获取用户密码
        String password = user.getPassword();
        //获取用户的加密盐值
        String salt = user.getSalt();
        //
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                //用户名
                userName,
                //密码
                password,
                //盐
                ByteSource.Util.bytes(salt),
                //当前realm的名字
                getName());
        return info;
    }
}
