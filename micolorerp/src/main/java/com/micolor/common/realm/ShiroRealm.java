package com.micolor.common.realm;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.method.encryption.Encodes;
import com.micolor.entity.system.UserEntity;
import com.micolor.module.system.login.service.LoginService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * FileName:com.micolor.common.realm.ShiroRealm.
 * Discription: TODO 填写类描述
 * Author: geyupeng.
 * DateTime 16/2/28.
 */
public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Logger logger = Logger.getLogger(this.getName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("main:view");
        info.addStringPermission("main:edit");
        return info;
    }

    private static final int INTERATIONS = 1024;
    private static final String ALGORITHM = "SHA-1";

    /**
     * 给ShiroDbRealm提供编码信息，用于密码密码比对
     * 描述
     */
    public ShiroRealm() {
        super();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
        matcher.setHashIterations(INTERATIONS);
        setCredentialsMatcher(matcher);
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SimpleAuthenticationInfo saInfo;
        MsgBean msgBean = loginService.getLogin(token.getUsername());
        UserEntity userEntity = (UserEntity) msgBean.getContent();
        if (userEntity.getStatus().trim().equals("disabled")) {
            throw new DisabledAccountException();
        }

        if (userEntity != null) {
            byte[] salt = Encodes.decodeHex(userEntity.getSalt());
            saInfo = new SimpleAuthenticationInfo(userEntity.getUserName(), userEntity.getPassWord(),
                    ByteSource.Util.bytes(salt),getName());
        }else{
            throw new UnknownAccountException();
        }
        return saInfo;
    }
}
