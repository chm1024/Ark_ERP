package com.micolor.module.userinterface.P007.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.EXWHFeedback;
import com.micolor.entity.userinterface.Inventory;
import com.micolor.module.userinterface.P007.service.EXWHFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("EXWHFeedbackService")
public class EXWHFeedbackServiceImpl implements EXWHFeedbackService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(EXWHFeedback EXWHFeedback) {
        InterfaceMsg msgBean = new InterfaceMsg();
        EXWHFeedback.setStatus(0L);
        EXWHFeedback.setCreateDate(new Date());
        try {
            if (EXWHFeedback.getId() == null || EXWHFeedback.getId().equals("")) {
                daoService.save(EXWHFeedback);
            } else {
                daoService.update(EXWHFeedback);
            }
        } catch (Exception e) {
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<EXWHFeedback> EXWHFeedbackList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (EXWHFeedback sale : EXWHFeedbackList) {
            msgBean = this.saveObject(sale);
        }
        return msgBean;
    }

    public Long isExists(EXWHFeedback eXWHFeedback, InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from EXWHFeedback where whCode=? and shipType=? and logisticNo=? and shipNo=?",
                    new Object[]{eXWHFeedback.getWhCode(),eXWHFeedback.getShipType(),eXWHFeedback.getLogisticNo(),eXWHFeedback.getShipNo()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
