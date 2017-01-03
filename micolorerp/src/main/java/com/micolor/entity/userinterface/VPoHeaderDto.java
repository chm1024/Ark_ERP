package com.micolor.entity.userinterface;

import java.util.List;

/**
 * Created by liusi on 2016/11/26.
 * F003 采购订单数据传输对象
 */
public class VPoHeaderDto {

    public VPoHeaderDto() {
    }

    public VPoHeaderDto(String poNo, String orderTime, String customerCode, String settlementCode, String orderTypeCode, String orderTypeName, Integer pickupTypeCode, String requireShipperTimeFm, String requireShipperTimeTo, Integer distributionTypeCode, String requireConsigneeTimeFm, String requireConsigneeTimeTo, String stationName, String stationCode, String remark, String shipperCode, String shipperContactCode, String shipperContactChone, String shipperLocationCode, String consigneeCode, String consigneeContactCode, String consigneeContactChone, String consigneeLocationCode, String orgId, String cacelFlag, Double itemDiscount, Double itemAmount) {
        this.poNo = poNo;
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
        this.consigneeLocationCode = consigneeLocationCode;
        this.orgId = orgId;
        this.cacelFlag = cacelFlag;
        this.itemDiscount = itemDiscount;
        this.itemAmount = itemAmount;
    }

    private String poNo;

    private String orderTime;

    private String customerCode;

    private String settlementCode;

    private String orderTypeCode;

    private String orderTypeName;

    private Integer pickupTypeCode;

    private String requireShipperTimeFm;

    private String requireShipperTimeTo;

    private Integer distributionTypeCode;

    private String requireConsigneeTimeFm;

    private String requireConsigneeTimeTo;

    private String stationName;

    private String stationCode;

    private String remark;

    private String shipperCode;

    private String shipperContactCode;

    private String shipperContactChone;

    private String shipperLocationCode;

    private String consigneeCode;

    private String consigneeContactCode;

    private String consigneeContactChone;

    private String consigneeLocationCode;

    private String orgId;

    private String cacelFlag;

    private Double itemDiscount;

    private Double itemAmount;

    private List<VPoItem> vPoItems;

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
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

    public List<VPoItem> getVPoItems() {
        return vPoItems;
    }

    public void setVPoItems(List<VPoItem> vPoItems) {
        this.vPoItems = vPoItems;
    }
}
