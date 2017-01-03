package com.micolor.module.userinterface.P004.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.WHFeedback;
import com.micolor.entity.userinterface.WHLogisticsFeedback;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface WHLogisticsFeedbackService {
    public InterfaceMsg saveObject(WHLogisticsFeedback wHLogisticsFeedback) ;
    public InterfaceMsg saveObjectList(List<WHLogisticsFeedback> wHLogisticsFeedbackList) ;
    Long isExists(WHLogisticsFeedback wHLogisticsFeedback, InterfaceMsg msgBean);
}
