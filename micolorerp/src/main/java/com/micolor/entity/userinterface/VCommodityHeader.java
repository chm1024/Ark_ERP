package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liusi on 2016/11/24.
 * 接口F001实体 商品主数据
 *
 */
@Entity
@Table(name = "v_commodityheader")
public class VCommodityHeader implements java.io.Serializable{

    public VCommodityHeader() {
    }

    public VCommodityHeader(VCommodityHeaderId vCommodityHeaderId, String ownerCode, String skuName, String foreignName, String packCode, String typeCode, Long grossWeight, Long netWeight, Double cubic, String tempLevel, Long shelfLife, String whCode, Integer syncFlag, String spec) {
        this.vCommodityHeaderId = vCommodityHeaderId;
        this.ownerCode = ownerCode;
        this.skuName = skuName;
        this.foreignName = foreignName;
        this.packCode = packCode;
        this.typeCode = typeCode;
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
        this.cubic = cubic;
        this.tempLevel = tempLevel;
        this.shelfLife = shelfLife;
        this.whCode = whCode;
        this.syncFlag = syncFlag;
        this.spec = spec;
    }

    @Id
    private VCommodityHeaderId vCommodityHeaderId;

    @Column(name = "ownerCode")
    private String ownerCode;

    @Column(name = "skuName")
    private String skuName;

    @Column(name = "foreignName")
    private String foreignName;

    @Column(name = "packCode")
    private String packCode;

    @Column(name = "typeCode")
    private String typeCode;

    @Column(name = "grossWeight")
    private Long grossWeight;

    @Column(name = "netWeight")
    private Long netWeight;

    @Column(name = "cubic")
    private Double cubic;

    @Column(name = "tempLevel")
    private String tempLevel;

    @Column(name = "shelfLife")
    private Long shelfLife;

    @Column(name = "whCode")
    private String whCode;

    @Column(name = "syncFlag")
    private Integer syncFlag;

    @Column(name = "spec")
    private String spec;

    /*@OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="item_no",referencedColumnName = "SKUCODE")
    private List<Barcode> barcodes;*/

    public VCommodityHeaderId getvCommodityHeaderId() {
        return vCommodityHeaderId;
    }

    public void setvCommodityHeaderId(VCommodityHeaderId vCommodityHeaderId) {
        this.vCommodityHeaderId = vCommodityHeaderId;
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

    /*public List<Barcode> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<Barcode> barcodes) {
        this.barcodes = barcodes;
    }*/

}
