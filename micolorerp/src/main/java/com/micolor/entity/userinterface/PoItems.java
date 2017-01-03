package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by liuhx on 2016/11/12.
 * 采购订单 商品明细
 */
@Entity
@Table(name="POITEMS")
public class PoItems {
    /*
     *主键ID
     */
    @javax.persistence.Id
    @Column(name = "ID")
    private String id;

    /*
     *采购单号
     */
    @Column(name = "PONO")
    private String poNo;

    /**
     *商品代码
     * */
    @Column(name = "SKUCODE")
    private String skuCode;

    /**
     * 商品名称
     * */
    @Column(name = "SKUNAME")
    private String skuName;

    /**
     * 数量
     * */
    @Column(name = "QUANTITY")
    private Double quantity;

    /**
     * 商品条码
     * */
    @Column(name = "BARCODE")
    private String barCode;

    /**
     * 商品单价
     * */
    @Column(name = "PRICE")
    private Double price;

    /**
     * 商品总金额
     * */
    @Column(name = "AMOUNT")
    private Double amount;

    /**
     * 温层
     * */
    @Column(name = "TEMPERATURELEVELCODE")
    private String temperatureLevelCode;

    /**
     * 是否采购开票
     * */
    @Column(name = "ISINVOICE")
    private String isInvoice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
}
