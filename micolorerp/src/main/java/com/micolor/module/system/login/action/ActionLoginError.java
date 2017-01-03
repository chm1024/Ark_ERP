package com.micolor.module.system.login.action;

import com.micolor.common.action.BaseActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 28/04/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/")
public class ActionLoginError extends BaseActionSupport{
    private String errorMsg;
    @Action(
            value = "loginerror",
            results = {
                    @Result(name = "success", location = "jsp/system/login/loginerr.jsp")
            }
    )
    public String execute() throws Exception {
        return super.execute();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
