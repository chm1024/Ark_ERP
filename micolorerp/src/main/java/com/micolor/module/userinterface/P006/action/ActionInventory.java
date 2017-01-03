package com.micolor.module.userinterface.P006.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.util.InitLog;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.JaxbUtil;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.ResolveXMLToObject;
import com.micolor.entity.userinterface.InterfaceLogsErr;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.Inventory;
import com.micolor.entity.userinterface.InventoryAdjustment;
import com.micolor.module.userinterface.P006.service.InventoryService;
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
@Namespace("/jsp/userinterface/P006")
public class ActionInventory extends BaseActionSupport {
    @Resource
    private InventoryService InventorySerivce;
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
        List<Inventory> Inventorys = ResolveXMLToObject.converyToJavaBean(reqData, Inventory.class,"Inventory");
        InterfaceMsg msgBean=new InterfaceMsg();
        //判断如果xml解析为空
        boolean validate=true;
        if(Inventorys.size()==0){
            validate=false;
            msgBean.setStatus("fail");
            msgBean.setErrorMsg("库存同步xml有误，解析失败");
            msgBean.setErrorCode("0002");
        }
        //已存在
        Long count=InventorySerivce.isExists(Inventorys.get(0),msgBean);
        if("success".equals(msgBean.getStatus())) {
            if (count > 0) {
                validate = false;
                msgBean.setStatus("fail");
                msgBean.setErrorMsg("该库存已存在");
                msgBean.setErrorCode("0002");
            }
        }
        if(validate) {
            /*for (Inventory sale : Inventorys) {
                msgBean = InventorySerivce.saveObject(sale);
            }*/
            try{
                msgBean = InventorySerivce.saveObjectList(Inventorys);
            }catch (Exception e){
                String uuid = UUID.randomUUID().toString();
                //去掉“-”符号
                uuid = uuid.replaceAll("-", "");
                interfaceLogsService.add(initLog.initInterfaceLogs(uuid,11L,"库存同步P006","2"));
                InterfaceLogsErr interfaceLogsErr = new InterfaceLogsErr();
                interfaceLogsErr.setLogId(uuid);
                interfaceLogsErr.setInterfaceName("库存同步");
                interfaceLogsErr.setInterfaceCode("P006");
                interfaceLogsErr.setPrimaryKey("");
                interfaceLogsErr.setPrimaryColumn("");
                interfaceLogsErr.setErrCode("0003");
                interfaceLogsErr.setErrMsg(e.getMessage());
                interfaceLogsErrService.add(interfaceLogsErr);
            }
        }
        String status="success".equals(msgBean.getStatus())?"1":"2";
        interfaceLogsService.add(initLog.initInterfaceLogs(11L,"库存同步P006",status));
        SendXML.printReturnXml(msgBean);
        return null;
    }
}
