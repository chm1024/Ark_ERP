package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/11/13.
 */
@Entity
@Table(name = "SUPPLIERITEMS")
public class SupplierItems {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String Id;
    @Column(name = "SUPPLIERCODE")
    private String supplierCode;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "CONTACTNO")
    private String contactNo;
    @Column(name = "CONTACTNAME")
    private String contactName;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "LOCATIONCODE")
    private String locationCode;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COUNTRYNAME")
    private String countryName;
    @Column(name = "PROVINCENAME")
    private String provinceName;
    @Column(name = "CITYNAME")
    private String cityName;
    @Column(name = "COUNTYNAME")
    private String countyName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
}
