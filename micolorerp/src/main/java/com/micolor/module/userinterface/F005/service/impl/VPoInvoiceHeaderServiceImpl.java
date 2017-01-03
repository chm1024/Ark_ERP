package com.micolor.module.userinterface.F005.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.util.SendJson;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.ResolveReturnXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.*;
import com.micolor.module.userinterface.F004.service.VPoReceiptHeaderService;
import com.micolor.module.userinterface.F005.service.VPoInvoiceHeaderService;
import com.micolor.module.userinterface.interfaceconfig.service.InterfaceConfigService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import com.micolor.module.userinterface.procurementfinance.service.OrdersSerivce;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by liuhx on 12/11/16.
 * F005 采购发票SERVICE
 */
@Service("vPoInvoiceHeaderService")
public class VPoInvoiceHeaderServiceImpl implements VPoInvoiceHeaderService {

    @Resource
    DaoService daoService;

    @Resource
    private OrdersSerivce ordersSerivce;

    @Resource
    private InterfaceConfigService interfaceConfigService;

    @Resource
    private InterfaceLogsService interfaceLogsService;

    @Resource
    private InterfaceLogsErrService interfaceLogsErrService;

    @Resource
    private ResolveObjectToXML resolve;

    public List getList() {
        String Hql = "from VPoInvoiceHeader";
        return daoService.find(Hql);
    }

    public void sendVPoInvoiceHeader() {
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
        XMLLayout layout=new XMLLayout("POInvoice","POInvoiceHeader","POInvoiceItem",new String[]{""},new String[]{"poNo","skuCode","qty","totalAmount"});

        //记录日志主表信息
        interfaceLogs = new InterfaceLogs();
        interfaceLogs.setId(uuid);
        interfaceLogs.setInterfaceId(Long.valueOf(5));
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            interfaceLogs.setEtlDate(time.parse(time.format(dt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interfaceLogs.setInterfaceName("采购发票");
        interfaceLogs.setStatus("0");

        MsgBean msgBean = interfaceLogsService.add(interfaceLogs);

        // 获取采购收货主数据
        List<VPoInvoiceHeader> vPoInvoiceHeaders = this.getList();
        for(VPoInvoiceHeader vPoInvoiceHeader:vPoInvoiceHeaders){

            // 发送XML
            returnXML=resolve.objectToXml(vPoInvoiceHeader,layout,true);

            // 记录日志至日志文件
            Log log = LogFactory.getLog(this.getClass());
            StringBuffer logBuffer = new StringBuffer();
            logBuffer.append(time.format(dt)).append(" 采购发票:").append(returnXML).append(";");
            log.info(logBuffer.toString());

            // 获取返回状态
            sendStatusXml = SendXML.postXML(returnXML);
//            sendStatusXml = "<?xml version='1.0' encoding='UTF-8'?><response><status>success</status><error><errorMsg></errorMsg><errorCode></errorCode></error></response>";
            // 获取返回状态
            List<InterfaceConfig> interfaceConfigs = interfaceConfigService.findByActionName("ActionVCommodityHeader");
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
                        orders.setPoNo(vPoInvoiceHeader.getOrderNo());
                        orders = ordersSerivce.getOrders(orders);
                        orders.setPrint(6);
                        ordersSerivce.update(orders);
                    }else{
                        interfaceLogsErr = new InterfaceLogsErr();
                        interfaceLogsErr.setLogId(uuid);
                        interfaceLogsErr.setInterfaceName(interfaceConfig.getInterfaceName());
                        interfaceLogsErr.setInterfaceCode(interfaceConfig.getInterfaceCode());
                        interfaceLogsErr.setPrimaryKey(vPoInvoiceHeader.getInvoiceCode().toString());
                        interfaceLogsErr.setPrimaryColumn("INVOICECODE");
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
                    interfaceLogsErr.setPrimaryKey(vPoInvoiceHeader.getInvoiceCode().toString());
                    interfaceLogsErr.setPrimaryColumn("INVOICECODE");
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
    }


}
