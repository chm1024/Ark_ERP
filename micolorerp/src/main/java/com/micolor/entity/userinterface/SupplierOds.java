package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/11/13.
 */
@Entity
@Table(name = "SUPPLIER_ODS")
public class SupplierOds {
    @javax.persistence.Id
    @Column(name = "SUPPLIERCODE")
    private String supplierCode;
    @Column(name = "NAMECN")
    private String nameCn;
    @Column(name = "TAXREGISTNO")
    private String taxRegistNo;
    @Column(name = "SYNCFLAG")
    private String syncFlag;
    @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="SUPPLIERCODE",referencedColumnName = "SUPPLIERCODE")
    private List<SupplierItems> supplierItems;

    public List<SupplierItems> getSupplierItems() {
        return supplierItems;
    }

    public void setSupplierItems(List<SupplierItems> supplierItems) {
        this.supplierItems = supplierItems;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getTaxRegistNo() {
        return taxRegistNo;
    }

    public void setTaxRegistNo(String taxRegistNo) {
        this.taxRegistNo = taxRegistNo;
    }
}
