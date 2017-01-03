package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuhx on 2016/11/22 0022.
 */
@Entity
@Table(name="order_items")
@IdClass(value = OrderItemsId.class)
public class OrderItems implements java.io.Serializable{

    @Id
    @Column(name = "ITEM_NO")
    private Long skuCode;

    @Id
    @Column(name = "ORD_NO")
    private Long ordNo;

    @Id
    @Column(name = "STORE_NO")
    private Integer storeNo;

    @Id
    @Column(name = "FREE")
    private Integer free;

    @Column(name = "ORD_QTY")
    private Double ordQty;

    @Column(name = "RECPT_QTY")
    private Double qtyRcvEa;

    @Column(name = "CORR_QTY")
    private Double corrQty;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "BUY_PRICE")
    private Double buyPrice;

    @Column(name = "BUY_VAT")
    private Integer buyVat;

    @Column(name = "DEPOSIT")
    private Double deposit;

    @Column(name = "DEPOSIT_VAT")
    private Integer depositVat;

    @Column(name = "SUP_PRICE")
    private Double supPrice;

    @Column(name = "SUP_PRICE_VAT")
    private Integer supPriceVat;

    @Column(name = "SUP_QTY")
    private Double supQty;

    @Column(name = "BUY_WHEN")
    private Integer buyWhen;

    @Transient
    private Double amount;

    @Transient
    private Date rcvTime;

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
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

    public Integer getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Integer storeNo) {
        this.storeNo = storeNo;
    }

    public Long getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(Long ordNo) {
        this.ordNo = ordNo;
    }

    public Double getOrdQty() {
        return ordQty;
    }

    public void setOrdQty(Double ordQty) {
        this.ordQty = ordQty;
    }

    public Double getCorrQty() {
        return corrQty;
    }

    public void setCorrQty(Double corrQty) {
        this.corrQty = corrQty;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyVat() {
        return buyVat;
    }

    public void setBuyVat(Integer buyVat) {
        this.buyVat = buyVat;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getDepositVat() {
        return depositVat;
    }

    public void setDepositVat(Integer depositVat) {
        this.depositVat = depositVat;
    }

    public Double getSupPrice() {
        return supPrice;
    }

    public void setSupPrice(Double supPrice) {
        this.supPrice = supPrice;
    }

    public Integer getSupPriceVat() {
        return supPriceVat;
    }

    public void setSupPriceVat(Integer supPriceVat) {
        this.supPriceVat = supPriceVat;
    }

    public Double getSupQty() {
        return supQty;
    }

    public void setSupQty(Double supQty) {
        this.supQty = supQty;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getBuyWhen() {
        return buyWhen;
    }

    public void setBuyWhen(Integer buyWhen) {
        this.buyWhen = buyWhen;
    }

    public Date getRcvTime() {
        return rcvTime;
    }

    public void setRcvTime(Date rcvTime) {
        this.rcvTime = rcvTime;
    }
}
