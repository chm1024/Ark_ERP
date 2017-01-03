package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**销售发货子表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "SALESDEVLIVEYITEMS")
public class Salesdevliveyitems {

    /**
     * 主键ID
     */
    @javax.persistence.Id
    @Column(name = "ID")
    private String id;

    @Column(name = "SALESID")
    private String salesId;

    /**
     * 商品编码
     */
    @Column(name = "SKUCODE")
    private String skuCode;
    /**
     * 发货日期
     */
    @Column(name = "SHIPTIME")
    private Date shipTime;
    /**
     * 发货数量
     */
    @Column(name = "QTYSHIPEA")
    private Double qtyShipEa;
    /**
     * 发货可用数量
     */
    @Column(name = "SHIPAVAILABLEQUANTITY")
    private Double shipAvailableQuantity;
    /**
     * 金额
     */
    @Column(name = "AMOUNT")
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getQtyShipEa() {
        return qtyShipEa;
    }

    public void setQtyShipEa(Double qtyShipEa) {
        this.qtyShipEa = qtyShipEa;
    }

    public Double getShipAvailableQuantity() {
        return shipAvailableQuantity;
    }

    public void setShipAvailableQuantity(Double shipAvailableQuantity) {
        this.shipAvailableQuantity = shipAvailableQuantity;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }
}
