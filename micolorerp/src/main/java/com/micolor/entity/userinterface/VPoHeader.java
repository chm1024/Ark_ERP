package com.micolor.entity.userinterface;

import javax.persistence.*;
import javax.persistence.metamodel.ListAttribute;
import java.util.List;

/**
 * Created by liusi on 2016/11/26.
 * 接口F003实体 采购订单主数据
 *
 */
@Entity
@Table(name = "v_poheader")
public class VPoHeader implements java.io.Serializable{

    public VPoHeader() {
    }

    public VPoHeader(VPoHeaderId vPoHeaderId, String orderTime, String customerCode, String settlementCode, String orderTypeCode, String orderTypeName, Integer pickupTypeCode, String requireShipperTimeFm, String requireShipperTimeTo, Integer distributionTypeCode, String requireConsigneeTimeFm, String requireConsigneeTimeTo, String stationName, String stationCode, String remark, String shipperCode, String shipperContactCode, String shipperContactChone, String shipperLocationCode, String consigneeCode, String consigneeContactCode, String consigneeContactChone, String consigneeLocation, String orgId, String cacelFlag, Double itemDiscount, Double itemAmount) {
        this.vPoHeaderId = vPoHeaderId;
        this.orderTime = orderTime;
        this.customerCode = customerCode;
        this.settlementCode = settlementCode;
        this.orderTypeCode = orderTypeCode;
        this.orderTypeName = orderTypeName;
        this.pickupTypeCode = pickupTypeCode;
        this.requireShipperTimeFm = requireShipperTimeFm;
        this.requireShipperTimeTo = requireShipperTimeTo;
        this.distributionTypeCode = distributionTypeCode;
        this.requireConsigneeTimeFm = requireConsigneeTimeFm;
        this.requireConsigneeTimeTo = requireConsigneeTimeTo;
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.remark = remark;
        this.shipperCode = shipperCode;
        this.shipperContactCode = shipperContactCode;
        this.shipperContactChone = shipperContactChone;
        this.shipperLocationCode = shipperLocationCode;
        this.consigneeCode = consigneeCode;
        this.consigneeContactCode = consigneeContactCode;
        this.consigneeContactChone = consigneeContactChone;
        this.consigneeLocation = consigneeLocation;
        this.orgId = orgId;
        this.cacelFlag = cacelFlag;
        this.itemDiscount = itemDiscount;
        this.itemAmount = itemAmount;
    }

    @EmbeddedId
    private VPoHeaderId vPoHeaderId;

    @Column(name = "orderTime")
    private String orderTime;

    @Column(name = "customerCode")
    private String customerCode;

    @Column(name = "settlementCode")
    private String settlementCode;

    @Column(name = "orderTypeCode")
    private String orderTypeCode;

    @Column(name = "orderTypeName")
    private String orderTypeName;

    @Column(name = "pickupTypeCode")
    private Integer pickupTypeCode;

    @Column(name = "requireShipperTimeFm")
    private String requireShipperTimeFm;

    @Column(name = "requireShipperTimeTo")
    private String requireShipperTimeTo;

    @Column(name = "distributionTypeCode")
    private Integer distributionTypeCode;

    @Column(name = "requireConsigneeTimeFm")
    private String requireConsigneeTimeFm;

    @Column(name = "requireConsigneeTimeTo")
    private String requireConsigneeTimeTo;

    @Column(name = "stationName")
    private String stationName;

    @Column(name = "stationCode")
    private String stationCode;

    @Column(name = "remark")
    private String remark;

    @Column(name = "shipperCode")
    private String shipperCode;

    @Column(name = "shipperContactCode")
    private String shipperContactCode;

    @Column(name = "shipperContactChone")
    private String shipperContactChone;

    @Column(name = "shipperLocationCode")
    private String shipperLocationCode;

    @Column(name = "consigneeCode")
    private String consigneeCode;

    @Column(name = "consigneeContactCode")
    private String consigneeContactCode;

    @Column(name = "consigneeContactChone")
    private String consigneeContactChone;

    @Column(name = "consigneeLocation")
    private String consigneeLocation;

    @Column(name = "orgId")
    private String orgId;

    @Column(name = "cacelFlag")
    private String cacelFlag;

    @Column(name = "itemDiscount")
    private Double itemDiscount;

    @Column(name = "itemAmount")
    private Double itemAmount;

    @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="PONO",referencedColumnName = "PONO")
    private List<VPoItem> vPoItems;


    public VPoHeaderId getvPoHeaderId() {
        return vPoHeaderId;
    }

    public void setvPoHeaderId(VPoHeaderId vPoHeaderId) {
        this.vPoHeaderId = vPoHeaderId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
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

    public Integer getPickupTypeCode() {
        return pickupTypeCode;
    }

    public void setPickupTypeCode(Integer pickupTypeCode) {
        this.pickupTypeCode = pickupTypeCode;
    }

    public String getRequireShipperTimeFm() {
        return requireShipperTimeFm;
    }

    public void setRequireShipperTimeFm(String requireShipperTimeFm) {
        this.requireShipperTimeFm = requireShipperTimeFm;
    }

    public String getRequireShipperTimeTo() {
        return requireShipperTimeTo;
    }

    public void setRequireShipperTimeTo(String requireShipperTimeTo) {
        this.requireShipperTimeTo = requireShipperTimeTo;
    }

    public Integer getDistributionTypeCode() {
        return distributionTypeCode;
    }

    public void setDistributionTypeCode(Integer distributionTypeCode) {
        this.distributionTypeCode = distributionTypeCode;
    }

    public String getRequireConsigneeTimeFm() {
        return requireConsigneeTimeFm;
    }

    public void setRequireConsigneeTimeFm(String requireConsigneeTimeFm) {
        this.requireConsigneeTimeFm = requireConsigneeTimeFm;
    }

    public String getRequireConsigneeTimeTo() {
        return requireConsigneeTimeTo;
    }

    public void setRequireConsigneeTimeTo(String requireConsigneeTimeTo) {
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

    public String getShipperLocationCode() {
        return shipperLocationCode;
    }

    public void setShipperLocationCode(String shipperLocationCode) {
        this.shipperLocationCode = shipperLocationCode;
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

    public String getConsigneeLocation() {
        return consigneeLocation;
    }

    public void setConsigneeLocation(String consigneeLocation) {
        this.consigneeLocation = consigneeLocation;
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

    public List<VPoItem> getVPoItems() {
        return vPoItems;
    }

    public void setVPoItems(List<VPoItem> vPoItems) {
        this.vPoItems = vPoItems;
    }
}
