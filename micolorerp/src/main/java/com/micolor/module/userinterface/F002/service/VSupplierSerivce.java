package com.micolor.module.userinterface.F002.service;

import com.micolor.entity.userinterface.VSupplier;
import java.util.List;

/**
 * Created by liuhx on 24/11/16.
 * F002 供应商主数据SERVICE
 */
public interface VSupplierSerivce {

    List<VSupplier> getList();

    void sendVSupplier();

//    List<Barcode> getBarcodeByItemNo(Long itemNo);
}
