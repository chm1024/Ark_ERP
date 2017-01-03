package com.micolor.module.userinterface.procurementfinance.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.statics.EnumUtil;
import com.micolor.entity.userinterface.Orders;
import com.micolor.module.userinterface.procurementfinance.service.OrdersSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuhx on 12/11/16.
 */
@Service("ordersSerivce")
public class OrdersServiceImpl implements OrdersSerivce {
    @Resource
    DaoService daoService;

    /*@Override
    public Commodity getCommodityByKey(String skuCode) {
        String Hql = "from Commodity where skuCode = ? ";
        Commodity commodity = (Commodity) daoService.get(Hql, new Object[]{skuCode.trim()});
        return commodity;
    }*/

    public List getList() {
        String Hql = "from Orders";
        return daoService.find(Hql);
    }

    public Orders getOrders(Orders orders) {
        Orders order = (Orders) daoService.get("from Orders where poNo = ? ",new Object[]{orders.getPoNo()});
        return order;
    }

    public MsgBean update(Orders orders) {
        MsgBean msgBean = new MsgBean();
        try{
            daoService.update(orders);
            msgBean.setContent(orders);
            msgBean.setMsg("订单状态更新成功!");
            msgBean.setStatus(EnumUtil.MessageStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            msgBean.setContent(orders);
            msgBean.setMsg("订单状态更新失败!原因:"+e.getMessage());
            msgBean.setStatus(EnumUtil.MessageStatus.ERROR);
        }
        return msgBean;
    }


}
