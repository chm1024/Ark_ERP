package com.micolor.module.userinterface.manualmode.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.module.userinterface.manualmode.service.ManualModeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

/**
 * Created by GeYupeng on 2016-11-02.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/manualmode")
public class ActionManualInterfaceList extends BaseActionSupport{
    private ManualModeService manualModeService;

    public void setManualModeService(ManualModeService manualModeService) {
        this.manualModeService = manualModeService;
    }

    DataTables dataTables;
    @Action(
            value = "interfacelistpage",
            results = {
                    @Result(name = "success",location = "interfacelist.jsp")
            }
    )
    public String transvaluelisinterfacelisttpage()throws Exception {
        return SUCCESS;
    }

    @Action(
            value = "interfacelist",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    @Override
    public String execute() throws Exception {
        dataTables = super.getDataTables();
        int recordsTotal = Integer.parseInt(manualModeService.getInterfaceCount(dataTables).toString());
        //设置返回数据.
        getDataTables().setData(manualModeService.getInterfaceList(dataTables));
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
