package com.micolor.module.system.login.service.impl;


import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.system.UserEntity;
import com.micolor.module.system.login.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by geyupeng on 16/1/2.
 */
@Service("loginService")
@Transactional
public class LoginImpl implements LoginService {
    @Resource
    DaoService daoService;

    public MsgBean getLogin(String account) {
        MsgBean msgBean = new MsgBean();
        Object[] objects = new Object[]{account};
        UserEntity userEntity;
        try {
            userEntity = (UserEntity) daoService.get(" from UserEntity where userName = ? ", objects);
            if (userEntity != null) {
                msgBean.setStatus(EnumUtil.MessageStatus.OK);
                msgBean.setContent(userEntity);
            } else {
                msgBean.setMsg("帐号密码错误或权限不足，请重试!");
                msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msgBean.setMsg(e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }
}
