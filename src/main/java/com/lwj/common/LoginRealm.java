package com.lwj.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class LoginRealm extends AuthorizingRealm {

//    public String getName(){
//        return "userRealm";
//    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = (String) usernamePasswordToken.getPrincipal();
//        String password = new String((char[])usernamePasswordToken.getCredentials());
        String password = String.valueOf(usernamePasswordToken.getPassword());
        if(null == username){
            throw new UnknownAccountException("用户不存在");
        }
        if("else".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }
        if("test".equals(username) && "123456".equals(password)){
            String realmName = getName();

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,realmName);
            return info;
        }
//        Object pricipal = username;
//        Object credentials = "123456";
       // String realmName = this.getName();

        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password,realmName);
        return null;
    }
}
