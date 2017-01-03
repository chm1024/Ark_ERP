package com.micolor.module.userinterface.P001.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.util.InitLog;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.JaxbUtil;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.entity.userinterface.InterfaceLogs;
import com.micolor.entity.userinterface.InterfaceLogsErr;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesDelivery;
import com.micolor.module.userinterface.P001.service.SalesDeliveryService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Fangjw on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/P001")
public class ActionSalesDelivery extends BaseActionSupport {
    @Resource
    private SalesDeliveryService salesDeliverySerivce;
    @Resource
    private ResolveObjectToXML resolve;
    @Resource
    private InitLog initLog;
    @Resource
    private InterfaceLogsService interfaceLogsService;

    @Resource
    private InterfaceLogsErrService interfaceLogsErrService;

    private String reqData;

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

        /*记录日志 begin*/
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log log = LogFactory.getLog(this.getClass());
        StringBuffer logBuffer = new StringBuffer();
        logBuffer.append(time.format(dt)).append("销售发货P001:").append(reqData).append(";");
        log.info(logBuffer.toString());
        /*记录日志 end*/
        boolean validate=true;
        //将xml解析成实体类
        List<SalesDelivery> salesDeliverys = JaxbUtil.converyToJavaBean(reqData, SalesDelivery.class,
        new String[]{"SalesDevlivey","SalesDevliveyHeader","SalesDevliveyItem"});
        InterfaceMsg msgBean=new InterfaceMsg();
        //判断如果xml解析为空
        if(salesDeliverys.size()==0){
            validate=false;
            msgBean.setStatus("fail");
            msgBean.setErrorMsg("xml有误，解析失败");
            msgBean.setErrorCode("0002");
        }
        //已存在
        Long count=salesDeliverySerivce.isExists(salesDeliverys.get(0),msgBean);
        if("success".equals(msgBean.getStatus())) {
            if (count > 0) {
                validate = false;
                msgBean.setStatus("fail");
                msgBean.setErrorMsg("该订单已存在");
                msgBean.setErrorCode("0002");
            }
        }
        if(validate) {
            /*for (SalesDelivery sale : salesDeliverys) {
                msgBean = salesDeliverySerivce.saveObject(sale);
            }*/
            try{
                msgBean = salesDeliverySerivce.saveObjectList(salesDeliverys);
            }catch(Exception e){
                String uuid = UUID.randomUUID().toString();
                //去掉“-”符号
                uuid = uuid.replaceAll("-", "");
                interfaceLogsService.add(initLog.initInterfaceLogs(uuid,6L,"销售发货P001","2"));
                InterfaceLogsErr interfaceLogsErr = new InterfaceLogsErr();
                interfaceLogsErr.setLogId(uuid);
                interfaceLogsErr.setInterfaceName("销售发货");
                interfaceLogsErr.setInterfaceCode("P001");
                interfaceLogsErr.setPrimaryKey("");
                interfaceLogsErr.setPrimaryColumn("");
                interfaceLogsErr.setErrCode("0003");
                interfaceLogsErr.setErrMsg(e.getMessage());
                interfaceLogsErrService.add(interfaceLogsErr);
            }
        }
        String status="success".equals(msgBean.getStatus())?"1":"2";
        interfaceLogsService.add(initLog.initInterfaceLogs(6L,"销售发货P001",status));
        SendXML.printReturnXml(msgBean);
        return null;
    }
}
