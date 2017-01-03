package com.micolor.module.userinterface.P007.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.EXWHFeedback;
import com.micolor.entity.userinterface.Inventory;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface EXWHFeedbackService {
    public InterfaceMsg saveObject(EXWHFeedback EXWHFeedback) ;
    public InterfaceMsg saveObjectList(List<EXWHFeedback> EXWHFeedbackList) ;
    Long isExists(EXWHFeedback eXWHFeedback, InterfaceMsg msgBean);
}
