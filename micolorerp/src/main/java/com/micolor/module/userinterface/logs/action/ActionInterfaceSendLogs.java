package com.micolor.module.userinterface.logs.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.userinterface.InterfaceLogsErr;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import com.micolor.module.userinterface.manualmode.service.ManualModeService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liusi on 2016-12-03.
 *
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/interfacelogs")
public class ActionInterfaceSendLogs extends BaseActionSupport{

    @Resource
    private InterfaceLogsService interfaceLogsService;

    @Resource
    private InterfaceLogsErrService interfaceLogsErrService;

    DataTables dataTables;
    @Action(
            value = "index",
            results = {
                    @Result(name = "success",location = "sendlogs.jsp")
            }
    )
    public String sendlogslistpage()throws Exception {
        return SUCCESS;
    }

    @Action(
            value = "sendlogslist",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    @Override
    public String execute() throws Exception {
        dataTables = super.getDataTables();
        int recordsTotal = Integer.parseInt(interfaceLogsService.getSendLogsCount(dataTables).toString());
        //设置返回数据.
        getDataTables().setData(interfaceLogsService.getSendLogsList(dataTables));
        getDataTables().setRecordsFiltered(recordsTotal);
        getDataTables().setRecordsTotal(recordsTotal);
        return SUCCESS;
    }

    @Action(
            value = "senderrlogs",
            results = {
                    @Result(name = "success",location = "senderrlogs.jsp",params = {"logid","${logid}"})
            }
    )
    public String senderrlogs()throws Exception {
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        String logid = request.getParameter("logid");
        return SUCCESS;
    }

    @Action(
            value = "senderrlogslist",
            results = {
                    @Result(name = "success", type = "json")
            }
    )
    public String senderrlogslist()throws Exception {
//        ActionContext context = ActionContext.getContext();
//        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
//        String logid = request.getParameter("logid");

        dataTables = super.getDataTables();
        int recordsTotal = Integer.parseInt(interfaceLogsErrService.getSendLogsErrCount(dataTables).toString());
        //设置返回数据.
        getDataTables().setData(interfaceLogsErrService.getSendLogsErrList(dataTables));
        getDataTables().setRecordsFiltered(recordsTotal);
        getDataTables().setRecordsTotal(recordsTotal);
        return SUCCESS;
    }

    @Action(
            value = "senderrlogsdetail",
            results = {
                    @Result(name = "success", location = "senderrlogsdetail.jsp")
            }
    )
    public String senderrlogsdetail()throws Exception {
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
        String id = request.getParameter("id");
        InterfaceLogsErr interfaceLogsErr = interfaceLogsErrService.findById(id);
        request.setAttribute("interfaceLogsErr",interfaceLogsErr);
        return SUCCESS;
    }

    @Override
    @JSON(name = "repdata")
    public DataTables getDataTables() {
        return dataTables;
    }
}
