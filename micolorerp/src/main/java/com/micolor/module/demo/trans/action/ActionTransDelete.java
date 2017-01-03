package com.micolor.module.demo.trans.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.method.json.JsonDateValueProcessor;
import com.micolor.entity.demo.TransValue;
import com.micolor.module.demo.trans.service.TransValueSerivce;
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
 * Created by Evangoe on 25/06/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/transvalue")
public class ActionTransDelete extends BaseActionSupport {
    private TransValueSerivce transValueService;

    public void setTransValueService(TransValueSerivce transValueService) {
        this.transValueService = transValueService;
    }
    private String rowDatas;
    private boolean success;
    private MsgBean msgBean;

    public boolean isSuccess() {
        return success;
    }

    public void setRowDatas(String rowDatas) {
        this.rowDatas = rowDatas;
    }

    public MsgBean getMsgBean() {
        return msgBean;
    }

    @Action(
            value = "transvaluedelete",
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
            TransValue[] transValues = new TransValue[jsonArrayCount];
            for (int index = 0; index < jsonArrayCount; index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                TransValue transValue = (TransValue) JSONObject.toBean(jsonObject, TransValue.class);
                transValues[index] = transValue;
            }
            msgBean = transValueService.deleteObject(transValues);
        }
        return super.execute();
    }
}
