package com.micolor.module.userinterface.F003.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.util.SendJson;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.ResolveReturnXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.*;
import com.micolor.module.userinterface.F002.service.VSupplierSerivce;
import com.micolor.module.userinterface.F003.service.VPoHeaderService;
import com.micolor.module.userinterface.interfaceconfig.service.InterfaceConfigService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import com.micolor.module.userinterface.procurementfinance.service.OrdersSerivce;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by liuhx on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/vpoheader")
public class ActionVPoHeader extends BaseActionSupport {

    @Resource
    private VPoHeaderService vPoHeaderService;

    @Resource
    private OrdersSerivce ordersSerivce;

    @Resource
    private InterfaceLogsService interfaceLogsService;

    @Resource
    private InterfaceLogsErrService interfaceLogsErrService;

    @Resource
    private InterfaceConfigService interfaceConfigService;

    @Resource
    private ResolveObjectToXML resolve;

    @Action(
            value = "index",
            results = {
                    @Result(name = "success",location = "json")
            }
    )
    public String execute() {
        VPoHeaderId vPoHeaderId = null; // 源数据主键类视图对象
        VPoHeaderDto vPoHeaderDto = null;  // 采购订单 数据传输对象
        VPoItem vPoItem = null; // 采购订单 数据传输对象
        List<VPoItem> vPoItems = null;   // 供应商联系信息列表  数据传输对象
        String sendStatusXml = null;  // 发送XML，返回数据对象
        InterfaceMsg interfaceMsg = null;
        String status = null;
        boolean isSendSuccess = true;
        InterfaceMsg interfaceMsg1 = new InterfaceMsg();

        InterfaceLogs interfaceLogs = null;
        InterfaceLogsErr interfaceLogsErr = null;

        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        uuid = uuid.replaceAll("-", "");


        String returnXML="";
        XMLLayout layout=new XMLLayout("PO","POHeader","POitem",new String[]{""},new String[]{"skuCode","skuName","quantity","barCode","price","amount","temperatureLevelCode","isInvoice","poNo"});

        //记录日志主表信息
        interfaceLogs = new InterfaceLogs();
        interfaceLogs.setId(uuid);
        interfaceLogs.setInterfaceId(Long.valueOf(3));
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            interfaceLogs.setEtlDate(time.parse(time.format(dt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interfaceLogs.setInterfaceName("采购订单");
        interfaceLogs.setStatus("0");

        MsgBean msgBean = interfaceLogsService.add(interfaceLogs);

        // 获取采购订单主数据
        List<VPoHeader> vPoHeaders = vPoHeaderService.getList();
        for(VPoHeader vPoHeader:vPoHeaders){
            // 遍历主数据列表，并将数值赋给数据传输对象
            vPoHeaderId = vPoHeader.getvPoHeaderId();
            vPoHeaderDto = new VPoHeaderDto(vPoHeader.getvPoHeaderId().getPoNo(),vPoHeader.getOrderTime(),vPoHeader.getCustomerCode(),vPoHeader.getSettlementCode(),vPoHeader.getOrderTypeCode(),vPoHeader.getOrderTypeName(),vPoHeader.getPickupTypeCode(),vPoHeader.getRequireShipperTimeFm(),vPoHeader.getRequireShipperTimeTo(),vPoHeader.getDistributionTypeCode(),vPoHeader.getRequireConsigneeTimeFm(),vPoHeader.getRequireConsigneeTimeTo(),vPoHeader.getStationName(),vPoHeader.getStationCode(),vPoHeader.getRemark(),vPoHeader.getShipperCode(),vPoHeader.getShipperContactCode(),vPoHeader.getShipperContactChone(),vPoHeader.getShipperLocationCode(),vPoHeader.getConsigneeCode(),vPoHeader.getConsigneeContactCode(),vPoHeader.getConsigneeContactChone(),vPoHeader.getConsigneeLocation(),vPoHeader.getOrgId(),vPoHeader.getCacelFlag(),vPoHeader.getItemDiscount(),vPoHeader.getItemAmount());
            // 获取详细采购订单信息
            vPoItems = vPoHeader.getVPoItems();
            vPoHeaderDto.setVPoItems(vPoItems);

            // 发送XML
            returnXML=resolve.objectToXml(vPoHeaderDto,layout,true);

            // 记录日志至日志文件
            Log log = LogFactory.getLog(this.getClass());
            StringBuffer logBuffer = new StringBuffer();
            logBuffer.append(time.format(dt)).append(" 采购订单:").append(returnXML).append(";");
            log.info(logBuffer.toString());

            // 获取返回状态
            List<InterfaceConfig> interfaceConfigs = interfaceConfigService.findByActionName("ActionVPoHeader");
            for(InterfaceConfig interfaceConfig:interfaceConfigs){
                interfaceMsg = new InterfaceMsg();
                String url = interfaceConfig.getInterfaceUrl();

                try{
                    sendStatusXml = SendXML.doHttpPost(returnXML,url);
                    if(sendStatusXml == null || sendStatusXml.length() == 0){
                        // 默认不返回XML串,就默认为数据发送成功。
                        interfaceMsg.setStatus("success");
                    }else{
                        interfaceMsg = ResolveReturnXML.getReturnXml(sendStatusXml);
                    }
                    // 如果接收成功
                    status = interfaceMsg.getStatus();
                    if(status.equals("success")){
                        // 根据返回状态，更新数据
                        Orders orders = new Orders();
                        orders.setPoNo(Long.parseLong(vPoHeaderId.getPoNo()));
                        orders = ordersSerivce.getOrders(orders);
                        orders.setPrint(2);
                        ordersSerivce.update(orders);
                    }else{
                        interfaceLogsErr = new InterfaceLogsErr();
                        interfaceLogsErr.setLogId(uuid);
                        interfaceLogsErr.setInterfaceName(interfaceConfig.getInterfaceName());
                        interfaceLogsErr.setInterfaceCode(interfaceConfig.getInterfaceCode());
                        interfaceLogsErr.setPrimaryKey(vPoHeader.getvPoHeaderId().getPoNo().toString());
                        interfaceLogsErr.setPrimaryColumn("PONO");
                        interfaceLogsErr.setErrCode(interfaceMsg.getErrorCode());
                        interfaceLogsErr.setErrMsg(interfaceMsg.getErrorMsg());
                        interfaceLogsErrService.add(interfaceLogsErr);
                        isSendSuccess = false;
                    }
                }catch (Exception e){
                    interfaceLogsErr = new InterfaceLogsErr();
                    interfaceLogsErr.setLogId(uuid);
                    interfaceLogsErr.setInterfaceName(interfaceConfig.getInterfaceName());
                    interfaceLogsErr.setInterfaceCode(interfaceConfig.getInterfaceCode());
                    interfaceLogsErr.setPrimaryKey(vPoHeader.getvPoHeaderId().getPoNo().toString());
                    interfaceLogsErr.setPrimaryColumn("PONO");
                    interfaceLogsErr.setErrCode("0000");
                    interfaceLogsErr.setErrMsg(e.getMessage());
                    interfaceLogsErrService.add(interfaceLogsErr);
                    isSendSuccess = false;
                    break;
                }


            }

        }


        if(isSendSuccess){
            interfaceLogs.setStatus("1");
            interfaceLogsService.update(interfaceLogs);
            interfaceMsg1.setStatus("success");
        }else{
            interfaceLogs.setStatus("2");
            interfaceLogsService.update(interfaceLogs);
            interfaceMsg1.setStatus("failure");
        }
        SendJson.printReturnJson(interfaceMsg1);
        return null;
    }
}
