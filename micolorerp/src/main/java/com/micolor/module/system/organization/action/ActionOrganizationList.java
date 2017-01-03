package com.micolor.module.system.organization.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.module.system.organization.service.OrganizationService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

/**
 * Created by GEYUPENG on 2016/4/19.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/system/organization")
public class ActionOrganizationList extends BaseActionSupport{
    private OrganizationService organizationService;
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    DataTables dataTables;
    @Action(
            value = "organizationlistpage",
            results = {
                    @Result(name = "success",location = "organizationlist.jsp")
            }
    )
    public String dictclasslistpage()throws Exception {
        return SUCCESS;
    }

    @Action(
            value = "organizationlist",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    public String execute() throws Exception {
        dataTables = super.getDataTables();
        int recordsTotal = Integer.parseInt(organizationService.getOrganizationCount(dataTables).toString());
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
        getDataTables().setData(organizationService.getOrganizationList(dataTables));
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
