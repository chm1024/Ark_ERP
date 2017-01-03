package com.micolor.module.userinterface.P003.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesReturn;
import com.micolor.entity.userinterface.WHFeedback;
import com.micolor.module.userinterface.P003.service.WHFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("WHFeedbackService")
public class WHFeedbackServiceImpl implements WHFeedbackService {
    @Resource
    DaoService daoService;

    public InterfaceMsg saveObject(WHFeedback WHFeedback) {
        InterfaceMsg msgBean = new InterfaceMsg();
        WHFeedback.setStatus(0L);
        WHFeedback.setCreateDate(new Date());
        try {
            if (WHFeedback.getId() == null || WHFeedback.getId().equals("")) {
                daoService.save(WHFeedback);
            } else {
                daoService.update(WHFeedback);
            }
        } catch (Exception e) {
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return msgBean;
    }

    public InterfaceMsg saveObjectList(List<WHFeedback> WHFeedbackList) {
        InterfaceMsg msgBean = new InterfaceMsg();
        for (WHFeedback sale : WHFeedbackList) {
            msgBean = this.saveObject(sale);
        }
        return msgBean;
    }

    public Long isExists(WHFeedback wHFeedback, InterfaceMsg msgBean) {
        Long count = 0L;
        try{
            count = daoService.count("select count(*) from WHFeedback where whCode=? and logisticNo=? and asnNo=?",
                    new Object[]{wHFeedback.getWhCode(),wHFeedback.getLogisticNo(),wHFeedback.getAsnNo()});
        }catch (Exception e){
            msgBean.setStatus("fail");
            msgBean.setErrorMsg(e.getMessage());
            msgBean.setErrorCode("0002");
            e.printStackTrace();
        }
        return count;
    }

}
