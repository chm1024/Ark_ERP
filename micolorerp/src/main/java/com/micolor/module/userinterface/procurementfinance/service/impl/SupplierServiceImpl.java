package com.micolor.module.userinterface.procurementfinance.service.impl;

import com.micolor.common.dao.service.DaoService;
import com.micolor.entity.userinterface.Supplier;
import com.micolor.entity.userinterface.SupplierOds;
import com.micolor.module.userinterface.procurementfinance.service.SupplierSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fangjw on 12/11/16.
 */
@Service("supplierSerivce")
public class SupplierServiceImpl implements SupplierSerivce{
    @Resource
    DaoService daoService;

    @Override
    public List<Supplier> getList() {
        String Hql = "from Supplier";
        return daoService.find(Hql);
    }

    /*@Override
    public SupplierOds getSupplierByKey(String supplierCode) {
        String Hql = "from Supplier where supplierCode = ? ";
        SupplierOds supplier = (SupplierOds) daoService.get(Hql, new Object[]{supplierCode.trim()});
        return supplier;
    }*/

}
