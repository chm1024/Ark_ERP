package com.micolor.module.userinterface.P001.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.common.entities.MsgBean;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesDelivery;
import com.micolor.module.userinterface.P001.service.SalesDeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("salesDeliveryService")
public class SalesDeliveryServiceImpl implements SalesDeliveryService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(SalesDelivery salesDelivery) {
        InterfaceMsg msgBean = new InterfaceMsg();
        salesDelivery.setStatus(0L);
        salesDelivery.setCreateDate(new Date());
        try {
            if (salesDelivery.getId() == null || salesDelivery.getId().equals("")) {
                daoService.save(salesDelivery);
            } else {
                daoService.update(salesDelivery);
            }
        } catch (Exception e) {
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<SalesDelivery> salesDeliveryList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (SalesDelivery sale : salesDeliveryList) {
            try{
                msgBean = this.saveObject(sale);
            }catch (Exception e){
                msgBean.setStatus("fail");
                msgBean.setErrorMsg(e.getMessage());
                msgBean.setErrorCode("0002");
                e.printStackTrace();
                break;
            }
        }
        return msgBean;
    }

    public Long isExists(SalesDelivery salesDelivery,InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from SalesDelivery where whCode=? and soNo=? and shipNo=?",
                    new Object[]{salesDelivery.getWhCode(),salesDelivery.getSoNo(),salesDelivery.getShipNo()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
