package com.micolor.module.system.login.action;

import com.micolor.common.action.BaseActionSupport;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 27/04/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/")
public class ActionLoginOut extends BaseActionSupport {
    @Action(
            value = "loginout",
            results = {
                    @Result(name = "success", location = "./")
            }
    )
    @Override
    public String execute() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return SUCCESS;
    }
}
