package com.micolor.module.userinterface.F004.service;

import com.micolor.entity.userinterface.VPoReceiptHeader;

import java.util.List;

/**
 * Created by liuhx on 24/11/26
 * F004  采购收货SERVICE
 */
public interface VPoReceiptHeaderService {

    List<VPoReceiptHeader> getList();

    void sendVPoReceiptHeader();

}
