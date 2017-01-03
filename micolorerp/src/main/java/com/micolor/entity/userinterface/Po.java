package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by liuhx on 2016/11/12.
 * 采购订单
 */
@Entity
@Table(name = "po")
public class Po {
    /*
     *采购单号
     */
    @javax.persistence.Id
    @Column(name = "PONO")
    private String poNo;

    /**
     *下单时间
     * */
    @Column(name = "ORDERTIME")
    private Date orderTime;

    /**
     * 委托客户
     * */
    @Column(name = "CUSTOMERCODE")
    private String customerCode;

    /**
     * 结算客户
     * */
    @Column(name = "SETTLEMENTCODE")
    private String settlementCode;

    /**
     * 订单类型代码
     * */
    @Column(name = "ORDERTYPECODE")
    private String orderTypeCode;

    /**
     * 订单类型
     * */
    @Column(name = "ORDERTYPENAME")
    private String orderTypeName;

    /**
     * 提货方式
     * */
    @Column(name = "PICKUPTYPECODE")
    private String pickupTypeCode;

    /**
     * 提货时间从
     * */
    @Column(name = "REQUIRESHIPPERTIMEFM")
    private Date requireShipperTimeFm;

    /**
     * 提货时间到
     * */
    @Column(name = "REQUIRESHIPPERTIMETO")
    private Date requireShipperTimeTo;

    /**
     * 配送方式
     * */
    @Column(name = "DISTRIBUTIONTYPECODE")
    private String distributionTypeCode;

    /**
     * 送达时间从
     * */
    @Column(name = "REQUIRECONSIGNEETIMEFM")
    private Date requireConsigneeTimeFm;

    /**
     * 送达时间到
     * */
    @Column(name = "REQUIRECONSIGNEETIMETO")
    private Date requireConsigneeTimeTo;

    /**
     * 基地
     * */
    @Column(name = "STATIONNAME")
    private String stationName;

    /**
     * 基地代码
     * */
    @Column(name = "STATIONCODE")
    private String stationCode;

    /**
     * 备注
     * */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 发货类别
     * */
    @Column(name = "SHIPPERCODE")
    private String shipperCode;

    /**
     * 发货客户
     * */
    @Column(name = "SHIPPERCONTACTCODE")
    private String shipperContactCode;

    /**
     * 发货联系方式
     * */
    @Column(name = "SHIPPERCONTACTCHONE")
    private String shipperContactChone;

    /**
     * 提货地点
     * */
    @Column(name = "SHIPPERLOCATIONCODE")
    private String shipperLocationCode;

    /**
     * 收件类别
     * */
    @Column(name = "CONSIGNEECODE")
    private String consigneeCode;

    /**
     * 收货客户
     * */
    @Column(name = "CONSIGNEECONTACTCODE")
    private String consigneeContactCode;

    /**
     * 收货联系方式
     * */
    @Column(name = "CONSIGNEECONTACTCHONE")
    private String consigneeContactChone;

    /**
     * 收货地址
     * */
    @Column(name = "CONSIGNEELOCATIONCODE")
    private String consigneeLocationCode;

    /**
     * 组织编码
     * */
    @Column(name = "ORGID")
    private String orgId;

    /**
     * 取消标记
     * */
    @Column(name = "CACELFLAG")
    private String cacelFlag;

    /**
     * 折扣金额
     * */
    @Column(name = "ITEMDISCOUNT")
    private Double itemDiscount;

    /**
     * 实付金额
     * */
    @Column(name = "ITEMAMOUNT")
    private Double itemAmount;

    /*
    *商品条码类
    */
    @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="PONO",referencedColumnName = "PONO")
    private List<PoItems> poItems;

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSettlementCode() {
        return settlementCode;
    }

    public void setSettlementCode(String settlementCode) {
        this.settlementCode = settlementCode;
    }

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getPickupTypeCode() {
        return pickupTypeCode;
    }

    public void setPickupTypeCode(String pickupTypeCode) {
        this.pickupTypeCode = pickupTypeCode;
    }

    public Date getRequireShipperTimeFm() {
        return requireShipperTimeFm;
    }

    public void setRequireShipperTimeFm(Date requireShipperTimeFm) {
        this.requireShipperTimeFm = requireShipperTimeFm;
    }

    public Date getRequireShipperTimeTo() {
        return requireShipperTimeTo;
    }

    public void setRequireShipperTimeTo(Date requireShipperTimeTo) {
        this.requireShipperTimeTo = requireShipperTimeTo;
    }

    public String getDistributionTypeCode() {
        return distributionTypeCode;
    }

    public void setDistributionTypeCode(String distributionTypeCode) {
        this.distributionTypeCode = distributionTypeCode;
    }

    public Date getRequireConsigneeTimeFm() {
        return requireConsigneeTimeFm;
    }

    public void setRequireConsigneeTimeFm(Date requireConsigneeTimeFm) {
        this.requireConsigneeTimeFm = requireConsigneeTimeFm;
    }

    public Date getRequireConsigneeTimeTo() {
        return requireConsigneeTimeTo;
    }

    public void setRequireConsigneeTimeTo(Date requireConsigneeTimeTo) {
        this.requireConsigneeTimeTo = requireConsigneeTimeTo;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getShipperContactCode() {
        return shipperContactCode;
    }

    public void setShipperContactCode(String shipperContactCode) {
        this.shipperContactCode = shipperContactCode;
    }

    public String getShipperContactChone() {
        return shipperContactChone;
    }

    public void setShipperContactChone(String shipperContactChone) {
        this.shipperContactChone = shipperContactChone;
    }

    public String getConsigneeCode() {
        return consigneeCode;
    }

    public void setConsigneeCode(String consigneeCode) {
        this.consigneeCode = consigneeCode;
    }

    public String getConsigneeContactCode() {
        return consigneeContactCode;
    }

    public void setConsigneeContactCode(String consigneeContactCode) {
        this.consigneeContactCode = consigneeContactCode;
    }

    public String getConsigneeContactChone() {
        return consigneeContactChone;
    }

    public void setConsigneeContactChone(String consigneeContactChone) {
        this.consigneeContactChone = consigneeContactChone;
    }

    public String getConsigneeLocationCode() {
        return consigneeLocationCode;
    }

    public void setConsigneeLocationCode(String consigneeLocationCode) {
        this.consigneeLocationCode = consigneeLocationCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCacelFlag() {
        return cacelFlag;
    }

    public void setCacelFlag(String cacelFlag) {
        this.cacelFlag = cacelFlag;
    }

    public Double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(Double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public Double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getShipperLocationCode() {
        return shipperLocationCode;
    }

    public void setShipperLocationCode(String shipperLocationCode) {
        this.shipperLocationCode = shipperLocationCode;
    }

    public List<PoItems> getPoItems() {
        return poItems;
    }

    public void setPoItems(List<PoItems> poItems) {
        this.poItems = poItems;
    }
}
