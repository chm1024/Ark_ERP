package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
@Entity
@Table(name = "v_poinvoiceheader")
public class VPoInvoiceHeader {

    @javax.persistence.Id
    @Column(name = "INVOICECODE")
    private Long invoiceCode;

    @Column(name = "orderNo")
    private Long orderNo;

    @Column(name = "DUEDATE")
    private String date;

    @Column(name = "SUPPLIERCODE")
    private String supplierCode;

    @Column(name = "ORGID")
    private String orgId;

    @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="INVOICECODE",referencedColumnName = "INVOICECODE")
    private List<VPoInvoiceItem> vPoInvoiceItems;

    public Long getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(Long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<VPoInvoiceItem> getVPoInvoiceItems() {
        return vPoInvoiceItems;
    }

    public void setVPoInvoiceItems(List<VPoInvoiceItem> vPoInvoiceItems) {
        this.vPoInvoiceItems = vPoInvoiceItems;
    }
}
