package com.micolor.module.demo.trans.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.entity.demo.TransValue;
import com.micolor.module.demo.trans.method.FileWrite;
import com.micolor.module.demo.trans.service.TransValueSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by Evangoe on 26/06/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/transvalue")
public class ActionTransDownload extends BaseActionSupport{
    private TransValueSerivce transValueService;
    public void setTransValueService(TransValueSerivce transValueService) {
        this.transValueService = transValueService;
    }
    public String langflag;

    public String getLangflag() {
        return langflag;
    }




    public void setLangflag(String langflag) {
        this.langflag = langflag;
    }
    public String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    @Action(
            value = "transvaluedownload",
            results = {
                    @Result(name = "success",location = "transfiledownload.jsp")
            }
    )
    public String transvaluedownload()throws Exception {
        List<TransValue> list = transValueService.getList();
        FileWrite fileWrite = new FileWrite();
        filepath = fileWrite.writeFile(list,langflag,super.getRequest().getRealPath("/"));
        return SUCCESS;
    }
}
