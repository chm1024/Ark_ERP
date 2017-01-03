package com.micolor.module.userinterface.P003.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.util.InitLog;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.JaxbUtil;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.entity.userinterface.InterfaceLogsErr;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesReturn;
import com.micolor.entity.userinterface.WHFeedback;
import com.micolor.module.userinterface.P003.service.WHFeedbackService;
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
@Namespace("/jsp/userinterface/P003")
public class ActionWHFeedback extends BaseActionSupport {
    @Resource
    private WHFeedbackService wHFeedbackSerivce;
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
        List<WHFeedback> wHFeedbacks = JaxbUtil.converyToJavaBean(reqData, WHFeedback.class,
        new String[]{"WHFeedback","WHFeedbackHeader","WHFeedbackitem"});
        InterfaceMsg msgBean=new InterfaceMsg();
        //判断如果xml解析为空
        boolean validate=true;
        if(wHFeedbacks.size()==0){
            validate=false;
            msgBean.setStatus("fail");
            msgBean.setErrorMsg("入库反馈xml有误，解析失败");
            msgBean.setErrorCode("0002");
        }
        //已存在
        Long count=wHFeedbackSerivce.isExists(wHFeedbacks.get(0),msgBean);
        if("success".equals(msgBean.getStatus())) {
            if (count > 0) {
                validate = false;
                msgBean.setStatus("fail");
                msgBean.setErrorMsg("该入库订单已存在");
                msgBean.setErrorCode("0002");
            }
        }
        if(validate) {
            /*for (WHFeedback sale : wHFeedbacks) {
                msgBean = wHFeedbackSerivce.saveObject(sale);
            }*/
            try{
                msgBean = wHFeedbackSerivce.saveObjectList(wHFeedbacks);
            }catch (Exception e){
                String uuid = UUID.randomUUID().toString();
                //去掉“-”符号
                uuid = uuid.replaceAll("-", "");
                interfaceLogsService.add(initLog.initInterfaceLogs(uuid,8L,"入库反馈P003","2"));
                InterfaceLogsErr interfaceLogsErr = new InterfaceLogsErr();
                interfaceLogsErr.setLogId(uuid);
                interfaceLogsErr.setInterfaceName("入库反馈");
                interfaceLogsErr.setInterfaceCode("P003");
                interfaceLogsErr.setPrimaryKey("");
                interfaceLogsErr.setPrimaryColumn("");
                interfaceLogsErr.setErrCode("0003");
                interfaceLogsErr.setErrMsg(e.getMessage());
                interfaceLogsErrService.add(interfaceLogsErr);
            }
        }
        String status="success".equals(msgBean.getStatus())?"1":"2";
        interfaceLogsService.add(initLog.initInterfaceLogs(8L,"入库反馈P003",status));
        SendXML.printReturnXml(msgBean);
        return null;
    }
}
