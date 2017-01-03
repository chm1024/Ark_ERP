package com.micolor.module.demo.dictclass.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.method.json.JsonDateValueProcessor;
import com.micolor.entity.demo.DictClassEntity;
import com.micolor.module.demo.dictclass.service.DictClassService;
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
 * Created by Evangoe on 04/04/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/dictclass")
public class ActionDictClassDelete extends BaseActionSupport {

    private DictClassService dictClassService;

    public void setDictClassService(DictClassService dictClassService) {
        this.dictClassService = dictClassService;
    }

    private String rowDatas;
    private boolean success;
    private MsgBean msgBean;
    @Action(
            value = "dictclassdelete",
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
            //[{"adtimesp":"2016-02-25","dicode":"101","diname":"物资类型"},{"adtimesp":"2016-02-25","dicode":"102","diname":"物资类型2"}]
            JSONArray jsonArray = JSONArray.fromObject(rowDatas);
            int jsonArrayCount = jsonArray.size();
            DictClassEntity [] dictClassEntities = new DictClassEntity[jsonArrayCount];
            for (int index = 0; index < jsonArrayCount; index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                DictClassEntity dictClassEntity = (DictClassEntity) JSONObject.toBean(jsonObject, DictClassEntity.class);
                dictClassEntities[index] = dictClassEntity;
            }
            msgBean = dictClassService.deleteDictClass(dictClassEntities);
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
