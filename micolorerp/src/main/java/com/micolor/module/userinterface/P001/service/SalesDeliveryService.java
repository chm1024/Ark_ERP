package com.micolor.module.userinterface.P001.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesDelivery;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface SalesDeliveryService {
    InterfaceMsg saveObject(SalesDelivery salesDelivery) ;
    InterfaceMsg saveObjectList(List<SalesDelivery> salesDeliveryList) ;
    Long isExists(SalesDelivery salesDelivery,InterfaceMsg msgBean);
}
