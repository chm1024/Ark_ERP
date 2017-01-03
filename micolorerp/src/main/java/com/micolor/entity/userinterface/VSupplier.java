package com.micolor.entity.userinterface;

import javax.persistence.*;

/**
 * Created by liusi on 2016/11/26.
 * 接口F002实体 供应商主数据
 *
 */
@Entity
@Table(name = "v_supplier")
public class VSupplier implements java.io.Serializable{

    public VSupplier() {
    }

    public VSupplier(VSupplierId vSupplierId, Long supNo,String nameCn, String taxRegistNo, String syncFlag, String fax, String contactNo, String contactName, String mobile, String locationCode, String address, String countryName, String provinceName, String cityName, String countyName) {
        this.vSupplierId = vSupplierId;
        this.supNo = supNo;
        this.nameCn = nameCn;
        this.taxRegistNo = taxRegistNo;
        this.syncFlag = syncFlag;
        this.fax = fax;
        this.contactNo = contactNo;
        this.contactName = contactName;
        this.mobile = mobile;
        this.locationCode = locationCode;
        this.address = address;
        this.countryName = countryName;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.countyName = countyName;
    }

    @EmbeddedId
    private VSupplierId vSupplierId;

    @Column(name = "SUPNO")
    private Long supNo;

    @Column(name = "nameCn")
    private String nameCn;

    @Column(name = "taxRegistNo")
    private String taxRegistNo;

    @Column(name = "syncFlag")
    private String syncFlag;

    @Column(name = "fax")
    private String fax;

    @Column(name = "contactNo")
    private String contactNo;

    @Column(name = "contactName")
    private String contactName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "locationCode")
    private String locationCode;

    @Column(name = "address")
    private String address;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "provinceName")
    private String provinceName;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "countyName")
    private String countyName;


    public VSupplierId getVSupplierId() {
        return vSupplierId;
    }

    public void setVSupplierId(VSupplierId vSupplierId) {
        this.vSupplierId = vSupplierId;
    }

    public VSupplierId getvSupplierId() {
        return vSupplierId;
    }

    public void setvSupplierId(VSupplierId vSupplierId) {
        this.vSupplierId = vSupplierId;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getTaxRegistNo() {
        return taxRegistNo;
    }

    public void setTaxRegistNo(String taxRegistNo) {
        this.taxRegistNo = taxRegistNo;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Long getSupNo() {
        return supNo;
    }

    public void setSupNo(Long supNo) {
        this.supNo = supNo;
    }
}
