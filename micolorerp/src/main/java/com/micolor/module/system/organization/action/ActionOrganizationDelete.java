package com.micolor.module.system.organization.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.method.json.JsonDateValueProcessor;
import com.micolor.entity.system.TOrganizationEntity;
import com.micolor.module.system.organization.service.OrganizationService;
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
 * Created by GEYUPENG on 2016/4/19.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/system/organization")
public class ActionOrganizationDelete extends BaseActionSupport{
    private OrganizationService organizationService;

    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    private String rowDatas;
    private boolean success;
    private MsgBean msgBean;

    @Action(
            value = "organizationdelete",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    public String execute() throws Exception {
        success = true;
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

        if (rowDatas != null) {
            //[{"adtimesp":"2016-02-25","dicode":"101","diname":"物资类型"},{"adtimesp":"2016-02-25","dicode":"102","diname":"物资类型2"}]
            JSONArray jsonArray = JSONArray.fromObject(rowDatas);
            int jsonArrayCount = jsonArray.size();
            TOrganizationEntity[] tOrganizationEntities = new TOrganizationEntity[jsonArrayCount];
            for (int index = 0; index < jsonArrayCount; index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                TOrganizationEntity tOrganizationEntity = (TOrganizationEntity) JSONObject.toBean(jsonObject, TOrganizationEntity.class);
                tOrganizationEntities[index] = tOrganizationEntity;
            }
            msgBean = organizationService.deleteOrganization(tOrganizationEntities);
        }
        return SUCCESS;
    }


    public String getRowDatas() {
        return rowDatas;
    }

    public void setRowDatas(String rowDatas) {
        this.rowDatas = rowDatas;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MsgBean getMsgBean() {
        return msgBean;
    }

    public void setMsgBean(MsgBean msgBean) {
        this.msgBean = msgBean;
    }
}
