package com.micolor.entity.userinterface;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public class VSupplierDto {

    private String supplierCode;

    private String nameCn;

    private String taxRegistNo;

    private String syncFlag;

    private List<VSupplierItemsDto> vSupplierItemsDtos;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getTaxRegistNo() {
        return taxRegistNo;
    }

    public void setTaxRegistNo(String taxRegistNo) {
        this.taxRegistNo = taxRegistNo;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag;
    }

    public List<VSupplierItemsDto> getVSupplierItemsDtos() {
        return vSupplierItemsDtos;
    }

    public void setVSupplierItemsDtos(List<VSupplierItemsDto> vSupplierItemsDtos) {
        this.vSupplierItemsDtos = vSupplierItemsDtos;
    }
}
