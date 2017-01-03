package com.micolor.module.userinterface.P002.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesDelivery;
import com.micolor.entity.userinterface.SalesReturn;
import com.micolor.module.userinterface.P002.service.SalesReturnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("SalesReturnService")
public class SalesReturnServiceImpl implements SalesReturnService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(SalesReturn salesReturn) {
        InterfaceMsg msgBean = new InterfaceMsg();
        salesReturn.setStatus(0L);
        salesReturn.setCreateDate(new Date());
        try {
            if (salesReturn.getId() == null || salesReturn.getId().equals("")) {
                daoService.save(salesReturn);
            } else {
                daoService.update(salesReturn);
            }
        } catch (Exception e) {
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<SalesReturn> SalesReturnList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (SalesReturn sale : SalesReturnList) {
            msgBean = this.saveObject(sale);
        }
        return msgBean;
    }

    public Long isExists(SalesReturn salesReturn, InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from SalesReturn where whCode=? and soNo=? and asnNo=?",
                    new Object[]{salesReturn.getWhCode(),salesReturn.getSoNo(),salesReturn.getAsnNo()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
