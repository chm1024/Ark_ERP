package com.micolor.module.system.login.action;

import com.micolor.common.action.BaseActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 06/04/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/")
public class ActionPrepareLogin extends BaseActionSupport{

    @Action(
            value="preparelogin",
            results = {
                    @Result(name = "success", type="dispatcher",location = "jsp/system/login/login.jsp")
            }
    )
    public String execute() throws Exception {
        return super.execute();
    }
}
