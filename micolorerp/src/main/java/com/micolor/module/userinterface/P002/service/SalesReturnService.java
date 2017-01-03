package com.micolor.module.userinterface.P002.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.InterfaceMsg;
import com.micolor.entity.userinterface.SalesDelivery;
import com.micolor.entity.userinterface.SalesReturn;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface SalesReturnService {
    public InterfaceMsg saveObject(SalesReturn SalesReturn) ;
    public InterfaceMsg saveObjectList(List<SalesReturn> SalesReturnList) ;
    Long isExists(SalesReturn salesReturn, InterfaceMsg msgBean);
}
