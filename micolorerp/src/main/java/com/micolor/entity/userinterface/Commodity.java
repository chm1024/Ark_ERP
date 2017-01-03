package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Commodity {
    /*
     *货主编码
     */
    private String ownerCode;
    /*
     *商品编码
     */
    private String skuCode;
    /*
     *商品名称
     */
    private String skuName;
    /*
     *商品英文名称
     */
    private String foreignName;
    /*
     *包装规格
     */
    private String packCode;
    /*
     *商品类型
     */
    private String typeCode;
    /*
     *毛重
     */
    private String grossWeight;
    /*
     *净重
     */
    private String netWeight;
    /*
     *体积
     */
    private String cubic;
    /*
     *温层
     */
    private String tempLevel;
    /*
     *保质期
     */
    private String shelfLife;
    /*
     *仓库编码
     */
    private String whCode;
    /*
     *同步标记
     */
    private String syncFlag;
    /*
     *产品规格
     */
    private String spec;

    public String getCubic() {
        return cubic;
    }

    public void setCubic(String cubic) {
        this.cubic = cubic;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getPackCode() {
        return packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getTempLevel() {
        return tempLevel;
    }

    public void setTempLevel(String tempLevel) {
        this.tempLevel = tempLevel;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }


}
