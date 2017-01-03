package com.micolor.module.demo.trans.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.module.demo.trans.service.TransValueSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evangoe on 24/06/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/transvalue")
public class ActionTransValueList extends BaseActionSupport {
    private TransValueSerivce transValueService;

    public void setTransValueService(TransValueSerivce transValueService) {
        this.transValueService = transValueService;
    }

    DataTables dataTables;



    @Action(
            value = "transvaluelistpage",
            results = {
                    @Result(name = "success",location = "transvaluelist.jsp")
            }
    )
    public String transvaluelistpage()throws Exception {
        return SUCCESS;
    }
    @Action(
            value = "transvaluelist",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    @Override
    public String execute() throws Exception {
        dataTables = super.getDataTables();

        int recordsTotal = Integer.parseInt(transValueService.getCount(dataTables).toString());
        /**
         * 对时间处理
         * 将时间戳YYYY-MM-DD HH:MM:SS显示类型装换为YYYY-MM-DD
         *
         * 若无需处理,可将list直接放入中,如getDataTables().setData(list);
         * */
//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//        List list = dictClassService.getDictClassList(dataTables);
//        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        /*** 对时间处理结束**/

        //设置返回数据.
        getDataTables().setData(transValueService.getList(dataTables));
        getDataTables().setRecordsFiltered(recordsTotal);
        getDataTables().setRecordsTotal(recordsTotal);
        return SUCCESS;
    }

    @Override
    @JSON(name = "repdata")
    public DataTables getDataTables() {
        return dataTables;
    }
}
