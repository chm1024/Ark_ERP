package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liusi on 2016/11/24.
 * 接口F001实体 商品主数据
 *
 */
public class VCommodityHeaderDto implements java.io.Serializable{

    private String storeItemNo;

    private Long skuCode;

    private String ownerCode;

    private String skuName;

    private String foreignName;

    private String packCode;

    private String typeCode;

    private Long grossWeight;

    private Long netWeight;

    private Double cubic;

    private String tempLevel;

    private Long shelfLife;

    private String whCode;

    private Integer syncFlag;

    private String spec;

    private List<BarcodeId> barcodeIds;

    public String getStoreItemNo() {
        return storeItemNo;
    }

    public void setStoreItemNo(String storeItemNo) {
        this.storeItemNo = storeItemNo;
    }

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getPackCode() {
        return packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Long getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Long grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Long getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Long netWeight) {
        this.netWeight = netWeight;
    }

    public Double getCubic() {
        return cubic;
    }

    public void setCubic(Double cubic) {
        this.cubic = cubic;
    }

    public String getTempLevel() {
        return tempLevel;
    }

    public void setTempLevel(String tempLevel) {
        this.tempLevel = tempLevel;
    }

    public Long getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Long shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<BarcodeId> getBarcodeIds() {
        return barcodeIds;
    }

    public void setBarcodeIds(List<BarcodeId> barcodeIds) {
        this.barcodeIds = barcodeIds;
    }
}
