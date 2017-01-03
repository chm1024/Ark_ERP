package com.micolor.module.userinterface.P005.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.InventoryAdjustment;
import com.micolor.entity.userinterface.WHLogisticsFeedback;
import com.micolor.module.userinterface.P005.service.InventoryAdjustmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("InventoryAdjustmentService")
public class InventoryAdjustmentServiceImpl implements InventoryAdjustmentService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(InventoryAdjustment InventoryAdjustment) {
        InterfaceMsg msgBean = new InterfaceMsg();
        InventoryAdjustment.setStatus(0L);
        InventoryAdjustment.setCreateDate(new Date());
        try {
            if (InventoryAdjustment.getId() == null || InventoryAdjustment.getId().equals("")) {
                daoService.save(InventoryAdjustment);
            } else {
                daoService.update(InventoryAdjustment);
            }
        } catch (Exception e) {
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<InventoryAdjustment> inventoryAdjustmentList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (InventoryAdjustment sale : inventoryAdjustmentList) {
            msgBean = this.saveObject(sale);
        }
        return msgBean;
    }

    public Long isExists(InventoryAdjustment inventoryAdjustment, InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from InventoryAdjustment where whCode=? and orderNo=? and adjustmentTypeCode=? and skuCode=?",
                    new Object[]{inventoryAdjustment.getWhCode(),inventoryAdjustment.getOrderNo(),
                            inventoryAdjustment.getAdjustmentTypeCode(),inventoryAdjustment.getSkuCode()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
