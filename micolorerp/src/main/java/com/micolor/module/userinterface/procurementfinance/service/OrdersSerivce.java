package com.micolor.module.userinterface.procurementfinance.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.Orders;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface OrdersSerivce {
//    Commodity getCommodityByKey(String skuCode);

    List<Orders> getList();

    Orders getOrders(Orders orders);

    MsgBean update(Orders orders);
}
