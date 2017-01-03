package com.micolor.module.system.user.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.system.UserEntity;
import com.micolor.module.system.user.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by Evangoe on 29/10/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/system/user")
public class ActionUserEdit extends BaseActionSupport{
    private UserService userService;
    private UserEntity userEntity;
    private boolean success;
    private MsgBean msgBean;

    @Action(
            value = "useredit",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    public String execute() throws Exception {
        success = true;
        if(userEntity!=null){
            if(userEntity.getId()==null || userEntity.getId().equals("")){
                //userEntity = new UserEntity();
                userEntity.setCreateTime(new Date());
            }

            msgBean = userService.saveUser(userEntity);

        }else{
            msgBean = new MsgBean();
            msgBean.setContent("");
            msgBean.setMsg("保存或更新失败");
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return super.execute();
    }

    public boolean isSuccess() {
        return success;
    }

    public MsgBean getMsgBean() {
        return msgBean;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @JSON(serialize = false)
//    public TUserEntity gettUserEntity() {
//        return tUserEntity;
//    }
//
//    public void settUserEntity(TUserEntity tUserEntity) {
//        this.tUserEntity = tUserEntity;
//    }

    @JSON(serialize = false)
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
