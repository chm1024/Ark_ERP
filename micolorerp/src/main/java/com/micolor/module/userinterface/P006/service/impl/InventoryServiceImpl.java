package com.micolor.module.userinterface.P006.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.Inventory;
import com.micolor.entity.userinterface.InventoryAdjustment;
import com.micolor.module.userinterface.P006.service.InventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("InventoryService")
public class InventoryServiceImpl implements InventoryService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(Inventory Inventory) {
        InterfaceMsg msgBean = new InterfaceMsg();
        Inventory.setStatus(0L);
        Inventory.setCreateDate(new Date());
        try {
            if (Inventory.getId() == null || Inventory.getId().equals("")) {
                daoService.save(Inventory);
            } else {
                daoService.update(Inventory);
            }
        } catch (Exception e) {
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<Inventory> inventoryList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (Inventory sale : inventoryList) {
            msgBean = this.saveObject(sale);
        }
        return msgBean;
    }

    public Long isExists(Inventory inventory, InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from Inventory where whCode=? and skuCode=? and qty=? and qtyAvailable=?",
                    new Object[]{inventory.getWhCode(),inventory.getSkuCode(),inventory.getQty(),inventory.getQtyAvailable()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
