package com.micolor.module.userinterface.P003.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesReturn;
import com.micolor.entity.userinterface.WHFeedback;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface WHFeedbackService {
    public InterfaceMsg saveObject(WHFeedback WHFeedback) ;
    public InterfaceMsg saveObjectList(List<WHFeedback> WHFeedbackList) ;
    Long isExists(WHFeedback wHFeedback, InterfaceMsg msgBean);
}
