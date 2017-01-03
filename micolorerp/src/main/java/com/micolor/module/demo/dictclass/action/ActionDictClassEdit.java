package com.micolor.module.demo.dictclass.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.demo.DictClassEntity;
import com.micolor.module.demo.dictclass.service.DictClassService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by Evangoe on 06/04/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/dictclass")
public class ActionDictClassEdit extends BaseActionSupport{
    private DictClassService dictClassService;

    public void setDictClassService(DictClassService dictClassService) {
        this.dictClassService = dictClassService;
    }

    private boolean success;
    private MsgBean msgBean;
    private DictClassEntity dictClassEntity;

    @Action(
            value = "dictclassedit",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    @Override
    public String execute() throws Exception {
        success = true;
        if(dictClassEntity!=null){
            if(dictClassEntity.getDicode()==null || dictClassEntity.getDicode().equals("")){
                DictClassEntity dictClassEntity = new DictClassEntity();
                dictClassEntity.setDiname(this.dictClassEntity.getDiname());
                dictClassEntity.setAdtimesp(new Date());
                msgBean = dictClassService.saveDictClass(dictClassEntity);
            }else{
                msgBean = dictClassService.saveDictClass(dictClassEntity);
            }

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

    public void setDictClassEntity(DictClassEntity dictClassEntity) {
        this.dictClassEntity = dictClassEntity;
    }
    @JSON(serialize=false)
    public DictClassEntity getDictClassEntity() {
        return dictClassEntity;
    }
}
