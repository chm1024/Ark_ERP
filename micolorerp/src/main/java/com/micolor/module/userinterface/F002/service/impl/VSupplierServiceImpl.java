package com.micolor.module.userinterface.F002.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.util.SendJson;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.ResolveReturnXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.*;
import com.micolor.module.userinterface.F002.service.VSupplierSerivce;
import com.micolor.module.userinterface.interfaceconfig.service.InterfaceConfigService;
import com.micolor.module.userinterface.logs.service.DailyLogService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsErrService;
import com.micolor.module.userinterface.logs.service.InterfaceLogsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by liuhx on 12/11/16.
 * F002 供应商主数据SERVICE
 */
@Service("vSupplierService")
public class VSupplierServiceImpl implements VSupplierSerivce {

    @Resource
    DaoService daoService;

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

    public List getList() {
        String Hql = "from VSupplier";
        return daoService.find(Hql);
    }

    public void sendVSupplier() {
        VSupplierId vSupplierId = null;  // 源数据视图对象
        VSupplierDto vSupplierDto = null;  // 供应商主数据 数据传输对象
        VSupplierItemsDto vSupplierItemsDto = null; // 供应商联系信息 数据传输对象
        List<VSupplierItemsDto> vSupplierItemsDtos = null;   // 供应商联系信息列表  数据传输对象
        String sendStatusXml = null;  // 发送XML，返回数据对象
        DailyLog dailyLog = new DailyLog(); // 操作日志表记录
        DailyLogId dailyLogId = new DailyLogId();
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
        XMLLayout layout=new XMLLayout("Supplier","SupplierHeader","SupplierItem",new String[]{"supplierCode","nameCn","taxRegistNo","syncFlag"},new String[]{"fax","contactNo","contactName","mobile","locationCode","address","countryName","provinceName","cityName","countyName"});

        //记录日志主表信息
        interfaceLogs = new InterfaceLogs();
        interfaceLogs.setId(uuid);
        interfaceLogs.setInterfaceId(Long.valueOf(2));
        //创建时间
        Date dt=new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            interfaceLogs.setEtlDate(time.parse(time.format(dt)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        interfaceLogs.setInterfaceName("供应商主数据");
        interfaceLogs.setStatus("0");

        MsgBean msgBean = interfaceLogsService.add(interfaceLogs);


        // 获取供应商主数据列表
        List<VSupplier> vSuppliers = this.getList();
        for(VSupplier vSupplier:vSuppliers){
            // 遍历主数据列表，并将数值赋给数据传输对象
            vSupplierId = vSupplier.getvSupplierId();
            vSupplierDto = new VSupplierDto();
            vSupplierDto.setSupplierCode(vSupplierId.getSupplierCode());
            vSupplierDto.setNameCn(vSupplier.getNameCn());
            vSupplierDto.setTaxRegistNo(vSupplier.getTaxRegistNo());
            vSupplierDto.setSyncFlag(vSupplier.getSyncFlag());
            // 实际供应商联系人信息是一对一的关系，配合报文结构生成list
            vSupplierItemsDtos = new ArrayList<VSupplierItemsDto>();
            vSupplierItemsDto = new VSupplierItemsDto(vSupplier.getFax(),vSupplier.getContactNo(),vSupplier.getContactName(),vSupplier.getMobile(),vSupplier.getLocationCode(),vSupplier.getAddress(),vSupplier.getCountryName(),vSupplier.getProvinceName(),vSupplier.getCityName(),vSupplier.getCountyName());
            vSupplierItemsDtos.add(vSupplierItemsDto);
            vSupplierDto.setVSupplierItemsDtos(vSupplierItemsDtos);

            // 发送XML
            returnXML=resolve.objectToXmlInclude(vSupplierDto,layout,true);

            // 记录日志至日志文件
            Log log = LogFactory.getLog(this.getClass());
            StringBuffer logBuffer = new StringBuffer();
            logBuffer.append(time.format(dt)).append(" 供应商主数据:").append(returnXML).append(";");
            log.info(logBuffer.toString());

            // 获取返回状态
            List<InterfaceConfig> interfaceConfigs = interfaceConfigService.findByActionName("ActionVSupplier");
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
                        dailyLogId.settName("SUPPLIER");
                        dailyLogId.setKeyvalue(vSupplier.getSupNo().toString());
                        dailyLog.setStatus(1);
                        dailyLog.setDailyLogId(dailyLogId);
                        dailyLogService.update(dailyLog);
                    }else{
                        interfaceLogsErr = new InterfaceLogsErr();
                        interfaceLogsErr.setLogId(uuid);
                        interfaceLogsErr.setInterfaceName(interfaceConfig.getInterfaceName());
                        interfaceLogsErr.setInterfaceCode(interfaceConfig.getInterfaceCode());
                        interfaceLogsErr.setPrimaryKey(vSupplier.getvSupplierId().getSupplierCode().toString());
                        interfaceLogsErr.setPrimaryColumn("SUPPLIERCODE");
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
                    interfaceLogsErr.setPrimaryKey(vSupplier.getvSupplierId().getSupplierCode().toString());
                    interfaceLogsErr.setPrimaryColumn("SUPPLIERCODE");
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
    }


}
