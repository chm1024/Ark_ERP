package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by liusi on 2016/11/26.
 * 接口F003实体 采购订单数据子项数据
 *
 */
@Entity
@Table(name = "v_poitem")
public class VPoItem implements java.io.Serializable{

    public VPoItem() {
    }

    public VPoItem(Long poLineNo, Long skuCode, String skuName, Double quantity, String barCode, String price, String amount, String temperatureLevelCode, String isInvoice, Long poNo) {
        this.poLineNo = poLineNo;
        this.skuCode = skuCode;
        this.skuName = skuName;
        this.quantity = quantity;
        this.barCode = barCode;
        this.price = price;
        this.amount = amount;
        this.temperatureLevelCode = temperatureLevelCode;
        this.isInvoice = isInvoice;
        this.poNo = poNo;
    }

    @javax.persistence.Id
    @Column(name = "POLINENO")
    private Long poLineNo;

    @Column(name = "SKUCODE")
    private Long skuCode;

    @Column(name = "SKUNAME")
    private String skuName;

    @Column(name = "QUANTITY")
    private Double quantity;

    @Column(name = "BARCODE")
    private String barCode;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "AMOUNT")
    private String amount;

    @Column(name = "TEMPERATURELEVELCODE")
    private String temperatureLevelCode;

    @Column(name = "ISINVOICE")
    private String isInvoice;

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

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTemperatureLevelCode() {
        return temperatureLevelCode;
    }

    public void setTemperatureLevelCode(String temperatureLevelCode) {
        this.temperatureLevelCode = temperatureLevelCode;
    }

    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }

    public Long getPoNo() {
        return poNo;
    }

    public void setPoNo(Long poNo) {
        this.poNo = poNo;
    }
}
