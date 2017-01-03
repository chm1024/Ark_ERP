package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
@Entity
@Table(name = "v_poreceiptitem")
public class VPoReceiptItem {

    @javax.persistence.Id
    @Column(name = "POLINENO")
    private Long poLineNo;

    @Column(name = "SKUCODE")
    private Long skuCode;

    @Column(name = "RCVTIME")
    private String rcvTime;

    @Column(name = "QTYRCVEA")
    private Double qtyRcvEa;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "PONO")
    private Long poNo;


    public Long getPoLineNo() {
        return poLineNo;
    }

    public void setPoLineNo(Long poLineNo) {
        this.poLineNo = poLineNo;
    }

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public String getRcvTime() {
        return rcvTime;
    }

    public void setRcvTime(String rcvTime) {
        this.rcvTime = rcvTime;
    }

    public Double getQtyRcvEa() {
        return qtyRcvEa;
    }

    public void setQtyRcvEa(Double qtyRcvEa) {
        this.qtyRcvEa = qtyRcvEa;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPoNo() {
        return poNo;
    }

    public void setPoNo(Long poNo) {
        this.poNo = poNo;
    }
}
