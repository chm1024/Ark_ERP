package com.micolor.module.userinterface.P004.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.util.InitLog;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.JaxbUtil;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.ResolveXMLToObject;
import com.micolor.entity.userinterface.InterfaceLogsErr;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.WHFeedback;
import com.micolor.entity.userinterface.WHLogisticsFeedback;
import com.micolor.module.userinterface.P004.service.WHLogisticsFeedbackService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Fangjw on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/P004")
public class ActionWHLogisticsFeedback extends BaseActionSupport {
    @Resource
    private WHLogisticsFeedbackService wHLogisticsFeedbackSerivce;
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
        //将xml解析成实体类
        List<WHLogisticsFeedback> wHLogisticsFeedbacks = ResolveXMLToObject.converyToJavaBean(reqData, WHLogisticsFeedback.class,"WHLogisticsFeedback");
        InterfaceMsg msgBean=new InterfaceMsg();
        //判断如果xml解析为空
        boolean validate=true;
        if(wHLogisticsFeedbacks.size()==0){
            validate=false;
            msgBean.setStatus("fail");
            msgBean.setErrorMsg("入库物流状态xml有误，解析失败");
            msgBean.setErrorCode("0002");
        }
        //已存在
        Long count=wHLogisticsFeedbackSerivce.isExists(wHLogisticsFeedbacks.get(0),msgBean);
        if("success".equals(msgBean.getStatus())) {
            if (count > 0) {
                validate = false;
                msgBean.setStatus("fail");
                msgBean.setErrorMsg("该入库物流状态已存在");
                msgBean.setErrorCode("0002");
            }
        }
        if(validate) {
            /*for (WHLogisticsFeedback sale : wHLogisticsFeedbacks) {
                msgBean = wHLogisticsFeedbackSerivce.saveObject(sale);
            }*/
            try{
                msgBean = wHLogisticsFeedbackSerivce.saveObjectList(wHLogisticsFeedbacks);
            }catch (Exception e){
                String uuid = UUID.randomUUID().toString();
                //去掉“-”符号
                uuid = uuid.replaceAll("-", "");
                interfaceLogsService.add(initLog.initInterfaceLogs(uuid,9L,"入库物流状态反馈P004","2"));
                InterfaceLogsErr interfaceLogsErr = new InterfaceLogsErr();
                interfaceLogsErr.setLogId(uuid);
                interfaceLogsErr.setInterfaceName("入库物流状态反馈");
                interfaceLogsErr.setInterfaceCode("P004");
                interfaceLogsErr.setPrimaryKey("");
                interfaceLogsErr.setPrimaryColumn("");
                interfaceLogsErr.setErrCode("0003");
                interfaceLogsErr.setErrMsg(e.getMessage());
                interfaceLogsErrService.add(interfaceLogsErr);
            }
        }
        String status="success".equals(msgBean.getStatus())?"1":"2";
        interfaceLogsService.add(initLog.initInterfaceLogs(9L,"入库物流状态反馈P004",status));
        SendXML.printReturnXml(msgBean);
        return null;
    }
}
