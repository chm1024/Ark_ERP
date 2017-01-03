package com.micolor.module.userinterface.P002.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.util.InitLog;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.JaxbUtil;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.entity.userinterface.*;
import com.micolor.module.userinterface.P002.service.SalesReturnService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

/**
 * Created by Fangjw on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/P002")
public class ActionSalesReturn extends BaseActionSupport {
    @Resource
    private SalesReturnService salesReturnSerivce;
    @Resource
    private ResolveObjectToXML resolve;
    private String reqData;

    @Resource
    private InitLog initLog;

    @Resource
    private InterfaceLogsService interfaceLogsService;

    @Resource
    private InterfaceLogsErrService interfaceLogsErrService;

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    @Action(
            value = "transferInfo"
    )

    public String execute() {
        reqData= SendXML.getInputStream(super.getRequest());
        //将xml解析成实体类
        List<SalesReturn> salesReturns = JaxbUtil.converyToJavaBean(reqData, SalesReturn.class,
        new String[]{"SalesReturn","SalesReturnHeader","SalesReturnItem"});
        InterfaceMsg msgBean=new InterfaceMsg();
        //判断如果xml解析为空
        boolean validate=true;
        if(salesReturns.size()==0){
            validate=false;
            msgBean.setStatus("fail");
            msgBean.setErrorMsg("销售退货xml有误，解析失败");
            msgBean.setErrorCode("0002");
        }
        //已存在
        Long count=salesReturnSerivce.isExists(salesReturns.get(0),msgBean);
        if("success".equals(msgBean.getStatus())) {
            if (count > 0) {
                validate = false;
                msgBean.setStatus("fail");
                msgBean.setErrorMsg("该退货订单已存在");
                msgBean.setErrorCode("0002");
            }
        }
        if(validate) {
            /*for (SalesReturn sale : salesReturns) {
                msgBean = salesReturnSerivce.saveObject(sale);
            }*/
            try{
                msgBean = salesReturnSerivce.saveObjectList(salesReturns);
            }catch(Exception e){
                String uuid = UUID.randomUUID().toString();
                //去掉“-”符号
                uuid = uuid.replaceAll("-", "");
                interfaceLogsService.add(initLog.initInterfaceLogs(uuid,7L,"销售退货P002","2"));
                InterfaceLogsErr interfaceLogsErr = new InterfaceLogsErr();
                interfaceLogsErr.setLogId(uuid);
                interfaceLogsErr.setInterfaceName("销售退货");
                interfaceLogsErr.setInterfaceCode("P002");
                interfaceLogsErr.setPrimaryKey("");
                interfaceLogsErr.setPrimaryColumn("");
                interfaceLogsErr.setErrCode("0003");
                interfaceLogsErr.setErrMsg(e.getMessage());
                interfaceLogsErrService.add(interfaceLogsErr);
            }
        }
        String status="success".equals(msgBean.getStatus())?"1":"2";
        interfaceLogsService.add(initLog.initInterfaceLogs(7L,"销售退货P002",status));
        SendXML.printReturnXml(msgBean);
        return null;
    }
}
