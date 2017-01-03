package com.micolor.module.system.user.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.entity.system.UserEntity;
import com.micolor.module.system.user.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 29/10/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/system/user")
public class ActionUserInfo extends BaseActionSupport{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserEntity userEntity;

    @Action(
            value = "userinfo",
            results = {
                    @Result(name = "SUCCESS",location = "userinfo.jsp")
            }
    )
    public String execute() throws Exception {

        if(userEntity!=null&&!userEntity.getId().equals("")){
            userEntity = userService.getUser(userEntity);
        }
        return super.execute();
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
