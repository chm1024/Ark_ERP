package com.micolor.module.userinterface.P004.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.WHFeedback;
import com.micolor.entity.userinterface.WHLogisticsFeedback;
import com.micolor.module.userinterface.P004.service.WHLogisticsFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("wHLogisticsFeedbackService")
public class WHLogisticsFeedbackServiceImpl implements WHLogisticsFeedbackService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(WHLogisticsFeedback wHLogisticsFeedback) {
        InterfaceMsg msgBean = new InterfaceMsg();
        wHLogisticsFeedback.setStatus(0L);
        wHLogisticsFeedback.setCreateDate(new Date());
        try {
            if (wHLogisticsFeedback.getId() == null || wHLogisticsFeedback.getId().equals("")) {
                daoService.save(wHLogisticsFeedback);
            } else {
                daoService.update(wHLogisticsFeedback);
            }
        } catch (Exception e) {
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<WHLogisticsFeedback> wHLogisticsFeedbackList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (WHLogisticsFeedback sale : wHLogisticsFeedbackList) {
            msgBean = this.saveObject(sale);
        }
        return msgBean;
    }

    public Long isExists(WHLogisticsFeedback wHLogisticsFeedback, InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from WHLogisticsFeedback where whCode=? and poNo=? and asnNo=?",
                    new Object[]{wHLogisticsFeedback.getWhCode(),wHLogisticsFeedback.getPoNo(),wHLogisticsFeedback.getAsnNo()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
