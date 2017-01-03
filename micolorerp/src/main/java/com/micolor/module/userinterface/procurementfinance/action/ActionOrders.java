package com.micolor.module.userinterface.procurementfinance.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.common.xmlresolve.XMLLayout;
import com.micolor.entity.userinterface.OrderItems;
import com.micolor.entity.userinterface.Orders;
import com.micolor.entity.userinterface.Supplier;
import com.micolor.module.userinterface.procurementfinance.service.OrdersSerivce;
import com.micolor.module.userinterface.procurementfinance.service.SupplierSerivce;
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
@Namespace("/jsp/userinterface/procurementfinance")
public class ActionOrders extends BaseActionSupport {

    @Resource
    private OrdersSerivce ordersSerivce;

    @Resource
    private ResolveObjectToXML resolve;

    @Action(
            value = "orders",
            results = {
                    @Result(name = "success",location = "json")
            }
    )
    public String execute() {
        String returnXML="";
        XMLLayout layout=new XMLLayout("POReceipt","POReceiptHeader","POReceiptItem",new String[]{"whCode","poNo","orgId"},new String[]{"supplierCode"});
        List<Orders> orderses = ordersSerivce.getList();
        List<OrderItems> orderItemses = null;
        OrderItems orderItems = null;
        for(Orders order:orderses){
            if(order.getWhCode() == "1"){
                order.setWhCode("LS");
                orderItemses = order.getOrderItemses();
                for(int i=0;i<orderItemses.size();i++){
                    orderItemses.get(i).setRcvTime(order.getRealRecptDate());
                    orderItemses.get(i).setAmount(orderItemses.get(i).getQtyRcvEa()*orderItemses.get(i).getBuyPrice());
                }
            }
            order.setOrderItemses(orderItemses);
            returnXML=resolve.objectToXmlInclude(order,layout,true);
        }
        return returnXML;
    }
}
