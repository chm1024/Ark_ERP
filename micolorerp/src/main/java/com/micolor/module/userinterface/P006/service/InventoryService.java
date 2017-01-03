package com.micolor.module.userinterface.P006.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.Inventory;
import com.micolor.entity.userinterface.InventoryAdjustment;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface InventoryService {
    public InterfaceMsg saveObject(Inventory inventory) ;
    public InterfaceMsg saveObjectList(List<Inventory> inventoryList) ;
    Long isExists(Inventory inventory, InterfaceMsg msgBean);
}
