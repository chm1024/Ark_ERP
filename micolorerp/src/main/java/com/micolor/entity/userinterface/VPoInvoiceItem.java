package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
@Entity
@Table(name = "V_POINVOICEITEM")
public class VPoInvoiceItem {

    @Id
    @Column(name = "poLineNo")
    private Long poLineNo;

    @Column(name = "poNo")
    private Long poNo;

    @Column(name = "skuCode")
    private Long skuCode;

    @Column(name = "qty")
    private Long qty;

    @Column(name = "totalAmount")
    private Long totalAmount;

    @Column(name = "INVOICECODE")
    private Long invoiceCode;

    public Long getPoLineNo() {
        return poLineNo;
    }

    public void setPoLineNo(Long poLineNo) {
        this.poLineNo = poLineNo;
    }

    public Long getPoNo() {
        return poNo;
    }

    public void setPoNo(Long poNo) {
        this.poNo = poNo;
    }

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(Long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }
}
