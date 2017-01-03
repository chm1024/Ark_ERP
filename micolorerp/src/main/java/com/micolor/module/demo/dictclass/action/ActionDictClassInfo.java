package com.micolor.module.demo.dictclass.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.entity.demo.DictClassEntity;
import com.micolor.module.demo.dictclass.service.DictClassService;
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
@Namespace("/jsp/demo/dictclass")
public class ActionDictClassInfo extends BaseActionSupport{
    private DictClassService dictClassService;
    public void setDictClassService(DictClassService dictClassService) {
        this.dictClassService = dictClassService;
    }
    private DictClassEntity dictClassEntity;

    @Action(
            value = "dictclassinfo",
            results = {
                    @Result(name = "success",location = "dictclassinfo.jsp")
            }
    )
    public String execute() throws Exception {
        if(dictClassEntity!=null&&!dictClassEntity.getDicode().equals("")){
            dictClassEntity = dictClassService.getDictClass(dictClassEntity);
        }
        return super.execute();
    }

    public void setDictClassEntity(DictClassEntity dictClassEntity) {
        this.dictClassEntity = dictClassEntity;
    }

    public DictClassEntity getDictClassEntity() {
        return dictClassEntity;
    }
}
