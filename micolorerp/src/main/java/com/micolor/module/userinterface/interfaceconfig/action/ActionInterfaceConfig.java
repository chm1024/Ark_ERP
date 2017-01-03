package com.micolor.module.userinterface.interfaceconfig.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.Orders;
import com.micolor.entity.userinterface.VPoInvoiceHeader;
import com.micolor.module.userinterface.F005.service.VPoInvoiceHeaderService;
import com.micolor.module.userinterface.procurementfinance.service.OrdersSerivce;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuhx on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/interfaceconfig")
public class ActionInterfaceConfig extends BaseActionSupport {

    @Resource
    private VPoInvoiceHeaderService vPoInvoiceHeaderService;

    @Resource
    private OrdersSerivce ordersSerivce;

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


        String returnXML="";
        XMLLayout layout=new XMLLayout("POInvoice","POInvoiceHeader","POInvoiceItem",new String[]{""},new String[]{"poNo","skuCode","qty","totalAmount"});

        // 获取采购收货主数据
        List<VPoInvoiceHeader> vPoInvoiceHeaders = vPoInvoiceHeaderService.getList();
        for(VPoInvoiceHeader vPoInvoiceHeader:vPoInvoiceHeaders){

            // 发送XML
            returnXML=resolve.objectToXml(vPoInvoiceHeader,layout,true);

            // 获取返回状态
            sendStatusXml = SendXML.postXML(returnXML);

            // 根据返回状态，更新数据
            Orders orders = new Orders();
            orders.setPoNo(vPoInvoiceHeader.getOrderNo());
            orders = ordersSerivce.getOrders(orders);
            orders.setPrint(6);
            ordersSerivce.update(orders);
        }
        return returnXML;
    }
}
