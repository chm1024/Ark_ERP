package com.micolor.module.userinterface.F005.service;

import com.micolor.entity.userinterface.VPoInvoiceHeader;

import java.util.List;

/**
 * Created by liuhx on 24/11/26
 * F005  采购发票SERVICE
 */
public interface VPoInvoiceHeaderService {

    List<VPoInvoiceHeader> getList();

    void sendVPoInvoiceHeader();

}
