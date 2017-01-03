package com.micolor.module.userinterface.procurementfinance.service;

import com.micolor.entity.userinterface.Supplier;
import com.micolor.entity.userinterface.SupplierOds;

import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
public interface SupplierSerivce {
//    SupplierOds getSupplierByKey(String supplierCode);
        List<Supplier> getList();
}

