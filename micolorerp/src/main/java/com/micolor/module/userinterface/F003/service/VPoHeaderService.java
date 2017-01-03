package com.micolor.module.userinterface.F003.service;

import com.micolor.entity.userinterface.VPoHeader;
import com.micolor.entity.userinterface.VSupplier;

import java.util.List;

/**
 * Created by liuhx on 24/11/16.
 * F002 供应商主数据SERVICE
 */
public interface VPoHeaderService {

    List<VPoHeader> getList();

    void sendVPoHeader();
//    List<Barcode> getBarcodeByItemNo(Long itemNo);
}
