package com.micolor.module.demo.trans.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.entity.demo.TransValue;
import com.micolor.module.demo.trans.service.TransValueSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 25/06/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/transvalue")
public class ActionTransInfo  extends BaseActionSupport {
    private TransValueSerivce transValueService;

    public void setTransValueService(TransValueSerivce transValueService) {
        this.transValueService = transValueService;
    }

    private TransValue transValue;

    public TransValue getTransValue() {
        return transValue;
    }

    public void setTransValue(TransValue transValue) {
        this.transValue = transValue;
    }
    @Action(
            value = "transvalueinfo",
            results = {
                    @Result(name = "success",location = "transvalueinfo.jsp")
            }
    )
    @Override
    public String execute() throws Exception {
        if(transValue!=null && !transValue.getId().equals("")){
            transValue = transValueService.getObject(transValue);
        }
        return super.execute();
    }


}
