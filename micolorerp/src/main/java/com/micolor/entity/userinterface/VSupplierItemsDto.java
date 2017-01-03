package com.micolor.entity.userinterface;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public class VSupplierItemsDto {

    private String fax;

    private String contactNo;

    private String contactName;

    private String mobile;

    private String locationCode;

    private String address;

    private String countryName;

    private String provinceName;

    private String cityName;

    private String countyName;

    public VSupplierItemsDto() {
    }

    public VSupplierItemsDto(String fax, String contactNo, String contactName, String mobile, String locationCode, String address, String countryName, String provinceName, String cityName, String countyName) {
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
}
