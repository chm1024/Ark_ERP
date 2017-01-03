package com.micolor.module.userinterface.F001.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.util.SendJson;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.ResolveReturnXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.*;
import com.micolor.module.userinterface.F001.service.VCommodityHeaderSerivce;
import com.micolor.module.userinterface.interfaceconfig.service.InterfaceConfigService;
import com.micolor.module.userinterface.logs.service.DailyLogService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.ExcessiveAttemptsException;
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
@Namespace("/jsp/userinterface/vcommodityheader")
public class ActionVCommodityHeader extends BaseActionSupport {

    @Resource
    private VCommodityHeaderSerivce vCommodityHeaderSerivce;

    @Resource
    private DailyLogService dailyLogService;

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
        String sendStatusXml = null;  // 发送XML，返回数据对象
        DailyLog dailyLog = new DailyLog(); // 操作日志表记录
        DailyLogId dailyLogId = new DailyLogId();
        VCommodityHeaderDto vCommodityHeaderDto = null;
        List<BarcodeId> barcodeIds = null;
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
        XMLLayout layout=new XMLLayout("Commodity","CommodityHeader","CommodityItem",new String[]{"storeItemNo"},new String[]{"barCode"});

        //记录日志主表信息
        interfaceLogs = new InterfaceLogs();
        interfaceLogs.setId(uuid);
        interfaceLogs.setInterfaceId(Long.valueOf(1));
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            interfaceLogs.setEtlDate(time.parse(time.format(dt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interfaceLogs.setInterfaceName("商品主数据");
        interfaceLogs.setStatus("0");

        MsgBean msgBean = interfaceLogsService.add(interfaceLogs);

        // 获取商品主数据列表
        List<VCommodityHeader> vCommodityHeaders = vCommodityHeaderSerivce.getList();
        for(VCommodityHeader vCommodityHeader:vCommodityHeaders){
            vCommodityHeaderDto = new VCommodityHeaderDto();
            vCommodityHeaderDto.setSkuCode(vCommodityHeader.getvCommodityHeaderId().getSkuCode());
            vCommodityHeaderDto.setOwnerCode(vCommodityHeader.getOwnerCode());
            vCommodityHeaderDto.setSkuName(vCommodityHeader.getSkuName());
            vCommodityHeaderDto.setForeignName(vCommodityHeader.getForeignName());
            vCommodityHeaderDto.setPackCode(vCommodityHeader.getPackCode());
            vCommodityHeaderDto.setTypeCode(vCommodityHeader.getTypeCode());
            vCommodityHeaderDto.setGrossWeight(vCommodityHeader.getGrossWeight());
            vCommodityHeaderDto.setNetWeight(vCommodityHeader.getNetWeight());
            vCommodityHeaderDto.setCubic(vCommodityHeader.getCubic());
            vCommodityHeaderDto.setTempLevel(vCommodityHeader.getTempLevel());
            vCommodityHeaderDto.setShelfLife(vCommodityHeader.getShelfLife());
            vCommodityHeaderDto.setWhCode(vCommodityHeader.getWhCode());
            vCommodityHeaderDto.setSyncFlag(vCommodityHeader.getSyncFlag());
            vCommodityHeaderDto.setSpec(vCommodityHeader.getSpec());
            List<Barcode> barcodes = vCommodityHeaderSerivce.getBarcodeByItemNo(vCommodityHeader.getvCommodityHeaderId().getSkuCode());
            BarcodeId barcodeId = null;
            barcodeIds = new ArrayList<BarcodeId>();
            for(Barcode barcode:barcodes){
                barcodeId = barcode.getBarcodeId();
                barcodeIds.add(barcodeId);
            }
            vCommodityHeaderDto.setBarcodeIds(barcodeIds);

            // 发送XML

            returnXML=resolve.objectToXml(vCommodityHeaderDto,layout,true);
            // 记录日志至日志文件
            StringBuffer logBuffer = new StringBuffer();
            Log log = LogFactory.getLog(this.getClass());
            logBuffer.append(time.format(dt)).append(" 商品主数据:").append(returnXML).append(";");
            log.info(logBuffer.toString());

            // 获取返回状态
            List<InterfaceConfig> interfaceConfigs = interfaceConfigService.findByActionName("ActionVCommodityHeader");
            for(InterfaceConfig interfaceConfig:interfaceConfigs){
                interfaceMsg = new InterfaceMsg();
                String url = interfaceConfig.getInterfaceUrl();
                try{
                    /*String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<EXWHFeedback>\n" +
                            "\t<EXWHFeedbackHeader>\n" +
                            "\t\t<whCode>脉动柠檬味 600ml/瓶</whCode>\n" +
                            "\t\t<shipType>KHZTCK</shipType>\n" +
                            "\t\t<logisticNo>A8873</logisticNo>\n" +
                            "\t\t<shipNo>K3778</shipNo>\n" +
                            "\t</EXWHFeedbackHeader>\n" +
                            "\t<WHFeedbackitems>\n" +
                            "\t\t<WHFeedbackitem>\n" +
                            "\t\t\t<logisticLineNo>0001</logisticLineNo>\n" +
                            "\t\t\t<skuCode></skuCode>\n" +
                            "\t\t\t<shipTime>2016-10-20 15:00:00</shipTime>\n" +
                            "\t\t\t<qtyRcvEa>200</qtyRcvEa>\n" +
                            "\t\t\t<shipAvailableQuantity>100</shipAvailableQuantity>\n" +
                            "\t\t\t<isInvoice>Y</isInvoice>\n" +
                            "\t\t</WHFeedbackitem>\n" +
                            "\t\t<WHFeedbackitem>\n" +
                            "\t\t\t<logisticLineNo>0002</logisticLineNo>\n" +
                            "\t\t\t<skuCode>53899</skuCode>\n" +
                            "\t\t\t<shipTime>2016-10-20 15:00:00</shipTime>\n" +
                            "\t\t\t<qtyRcvEa>200</qtyRcvEa>\n" +
                            "\t\t\t<shipAvailableQuantity>100</shipAvailableQuantity>\n" +
                            "\t\t\t<isInvoice>Y</isInvoice>\n" +
                            "\t\t</WHFeedbackitem>\n" +
                            "\t</WHFeedbackitems>\n" +
                            "</EXWHFeedback>\n";*/
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
                        dailyLogId.settName("STORE_ITEMS");
                        String keyvalue = vCommodityHeader.getvCommodityHeaderId().getStoreNo().toString()+","+vCommodityHeader.getvCommodityHeaderId().getSkuCode().toString();
                        dailyLogId.setKeyvalue(keyvalue);
                        dailyLog.setStatus(1);
                        dailyLog.setDailyLogId(dailyLogId);
                        dailyLogService.update(dailyLog);
                    }else{
                        interfaceLogsErr = new InterfaceLogsErr();
                        interfaceLogsErr.setLogId(uuid);
                        interfaceLogsErr.setInterfaceName(interfaceConfig.getInterfaceName());
                        interfaceLogsErr.setInterfaceCode(interfaceConfig.getInterfaceCode());
                        interfaceLogsErr.setPrimaryKey(vCommodityHeader.getvCommodityHeaderId().getSkuCode().toString());
                        interfaceLogsErr.setPrimaryColumn("STOREITEMNO");
                        interfaceLogsErr.setErrCode(interfaceMsg.getErrorCode());
                        interfaceLogsErr.setErrMsg(interfaceMsg.getErrorMsg());
                        interfaceLogsErrService.add(interfaceLogsErr);
                        isSendSuccess = false;
                    }
                }catch (Exception e){
                    /*interfaceMsg.setStatus("fail");
                    interfaceMsg.setErrorCode("000");
                    interfaceMsg.setErrorMsg(e.getMessage());*/
                    interfaceLogsErr = new InterfaceLogsErr();
                    interfaceLogsErr.setLogId(uuid);
                    interfaceLogsErr.setInterfaceName(interfaceConfig.getInterfaceName());
                    interfaceLogsErr.setInterfaceCode(interfaceConfig.getInterfaceCode());
                    interfaceLogsErr.setPrimaryKey(vCommodityHeader.getvCommodityHeaderId().getSkuCode().toString());
                    interfaceLogsErr.setPrimaryColumn("STOREITEMNO");
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
            interfaceMsg1.setStatus("fail");
        }
        SendJson.printReturnJson(interfaceMsg1);
        return null;
    }
}
