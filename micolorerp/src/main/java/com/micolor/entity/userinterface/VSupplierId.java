package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by liusi on 2016/11/26.
 * 接口F002实体 供应商主数据视图ID联合主键类
 *
 */
@Embeddable
public class VSupplierId implements java.io.Serializable{

    public VSupplierId() {
    }

    public VSupplierId(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @Column(name = "supplierCode")
    private String supplierCode;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

}
