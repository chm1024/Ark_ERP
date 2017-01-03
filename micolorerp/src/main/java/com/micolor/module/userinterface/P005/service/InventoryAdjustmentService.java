package com.micolor.module.userinterface.P005.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.InventoryAdjustment;
import com.micolor.entity.userinterface.WHLogisticsFeedback;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface InventoryAdjustmentService {
    public InterfaceMsg saveObject(InventoryAdjustment inventoryAdjustment) ;
    public InterfaceMsg saveObjectList(List<InventoryAdjustment> inventoryAdjustmentList) ;
    Long isExists(InventoryAdjustment inventoryAdjustment, InterfaceMsg msgBean);
}
