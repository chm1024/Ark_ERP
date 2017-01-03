package com.micolor.module.system.user.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.method.json.JsonDateValueProcessor;
import com.micolor.entity.system.UserEntity;
import com.micolor.module.system.user.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by Evangoe on 29/10/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/system/user")
public class ActionUserDelete extends BaseActionSupport{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private boolean success;
    private MsgBean msgBean;
    private String rowDatas;

    @Action(
            value = "userdelete",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    @Override
    public String execute() throws Exception {
        success = true;
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

        if (rowDatas != null) {
            JSONArray jsonArray = JSONArray.fromObject(rowDatas);
            int jsonArrayCount = jsonArray.size();
            UserEntity[] userEntities = new UserEntity[jsonArrayCount];
            for (int index = 0; index < jsonArrayCount; index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                UserEntity userEntity = (UserEntity) JSONObject.toBean(jsonObject, UserEntity.class);
                userEntities[index] = userEntity;
            }
            msgBean = userService.deleteUser(userEntities);
        }
        return SUCCESS;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setRowDatas(String rowDatas) {
        this.rowDatas = rowDatas;
    }

    public MsgBean getMsgBean() {
        return msgBean;
    }
}
