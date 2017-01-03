package com.micolor.module.demo.trans.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.demo.TransValue;
import com.micolor.module.demo.trans.service.TransValueSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 25/06/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/transvalue")
public class ActionTransEdit extends BaseActionSupport {
    private TransValueSerivce transValueService;

    public void setTransValueService(TransValueSerivce transValueService) {
        this.transValueService = transValueService;
    }

    private boolean success;
    private MsgBean msgBean;
    private TransValue transValue;

    public boolean isSuccess() {
        return success;
    }

    public MsgBean getMsgBean() {
        return msgBean;
    }

    @JSON(serialize = false)
    public TransValue getTransValue() {
        return transValue;
    }

    public void setTransValue(TransValue transValue) {
        this.transValue = transValue;
    }

    @Action(
            value = "transvalueedit",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    @Override
    public String execute() throws Exception {
        success = true;
        if (transValue != null) {
            if (transValue.getId() == null || transValue.getId().equals("")) {

                TransValue checktransValue = transValueService.getObjectByKey(transValue);
                if (checktransValue == null) {
                    msgBean = transValueService.saveObject(transValue);
                } else {
                    msgBean = new MsgBean();
                    msgBean.setContent("");
                    msgBean.setMsg("KEY值已存在");
                    msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
                }
            } else {
                msgBean = transValueService.saveObject(transValue);
            }
        } else {
            msgBean = new MsgBean();
            msgBean.setContent("");
            msgBean.setMsg("保存或更新失败");
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return super.execute();
    }
}
