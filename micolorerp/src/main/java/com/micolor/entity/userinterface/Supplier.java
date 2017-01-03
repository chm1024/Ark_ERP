
package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.Date;

/**
 * supplier(XX表)
 */
@Entity
@Table(name="supplier")
public class Supplier{
    /**
     * 供应商编码
     */
    @javax.persistence.Id
    @Column(name = "SUP_NO")
    private Long supplierCode;

    /**
    * 公司中文名
    */
    @Column(name="COMPANY_NAME",nullable=false, length=35)
    private String nameCn;

/**
* 联系人名称
*/
@Column(name="NAME",nullable=false, length=16)
private String contactName;

/**
* 未知
*/
@Column(name="POST_NO",nullable=false, length=6)
private Long postNo;

/**
* 未知
*/
@Column(name="ADDRESS1",nullable=false, length=30)
private String address1;

/**
* 未知
*/
@Column(name="ADDRESS2",length=20)
private String address2;

/**
* 联系人手机
*/
@Column(name="PHONE_NO",nullable=false, length=20)
private String mobile;

/**
* 未知
*/
@Column(name="FAX_NO",length=20)
private String fax;

/**
* 未知
*/
@Column(name="STATUS",nullable=false, length=1)
private Long status;

/**
* 未知
*/
@Column(name="TYPE",nullable=false, length=2)
private Long type;

/**
* 未知
*/
@Column(name="DIVISION_NO",nullable=false, length=1)
private Long divisionNo;

/**
* 未知
*/
@Column(name="GRP_NO",length=3)
private Long grpNo;

/**
* 未知
*/
@Column(name="BANK_ACCOUNT_NAME",length=50)
private String bankAccountName;

/**
* 未知
*/
@Column(name="BANK_ACCOUNT",length=35)
private String bankAccount;

/**
* 未知
*/
@Column(name="BANK_NAME",length=60)
private String bankName;

/**
* 未知
*/
@Column(name="UNIFORM_NO",nullable=false, length=20)
private String taxRegistNo;

/**
* 未知
*/
@Column(name="GUI_ADDRESS",length=50)
private String guiAddress;

/**
* 未知
*/
@Column(name="RETURN_ALLOW",nullable=false, length=1)
private Long returnAllow;

/**
* 未知
*/
@Column(name="PAYMENT_METHOD",nullable=false, length=1)
private Long paymentMethod;

/**
* 未知
*/
@Column(name="PAYMENT_PERIOD",length=3)
private Long paymentPeriod;

/**
* 未知
*/
@Column(name="ORD_METHOD",nullable=false, length=1)
private Long ordMethod;

/**
* 未知
*/
@Column(name="OPL_SCHEDULE",length=7)
private String oplSchedule;

/**
* 未知
*/
@Column(name="MIN_OPL_CD",length=1)
private Long minOplCd;

/**
* 未知
*/
@Column(name="MIN_OPL",length=8)
private Long minOpl;

/**
* 未知
*/
@Column(name="LEAD_TIME",length=3)
private Long leadTime;

/**
* 未知
*/
@Column(name="DELIV_SCHEDULE",length=7)
private String delivSchedule;

/**
* 未知
*/
@Column(name="CREATE_DATE",length=7)
    @Temporal(TemporalType.DATE)
private Date createDate;

/**
* 未知
*/
@Column(name="CHANGED_DATE",length=7)
    @Temporal(TemporalType.DATE)
private Date changedDate;

/**
* 未知
*/
@Column(name="MEMO",length=20)
private String memo;

/**
* 未知
*/
@Column(name="PROVINCE",length=10)
private String province;

/**
* 未知
*/
@Column(name="COUNTY",length=10)
private String county;

/**
* 未知
*/
@Column(name="BANK_CONFIRM",length=1)
private Long bankConfirm;

/**
* 未知
*/
@Column(name="FAX_NO_EXT",length=4)
private Long faxNoExt;

/**
* 未知
*/
@Column(name="SETTLE_TYPE",length=2)
private String settleType;

/**
* 未知
*/
@Column(name="BANK_DAY",length=3)
private Long bankDay;

/**
* 未知
*/
@Column(name="FN_USR",length=8)
private String fnUsr;

/**
* 未知
*/
@Column(name="BUY_VAT",length=1)
private Long buyVat;

/**
* 未知
*/
@Column(name="WEB_STATUS",length=1)
private Long webStatus;

/**
* 未知
*/
@Column(name="EMAIL_ADDR",length=50)
private String emailAddr;

/**
* 未知
*/
@Column(name="SMS_NO",length=11)
private String smsNo;

/**
* 未知
*/
@Column(name="USR",length=8)
private String usr;

/**
* 未知
*/
@Column(name="BANK_NO",length=12)
private String bankNo;

/**
* 未知
*/
@Column(name="WEB_SHOW_BP",length=1)
private Long webShowBp;

    public Long getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(Long supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Long getPostNo() {
        return postNo;
    }

    public void setPostNo(Long postNo) {
        this.postNo = postNo;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getDivisionNo() {
        return divisionNo;
    }

    public void setDivisionNo(Long divisionNo) {
        this.divisionNo = divisionNo;
    }

    public Long getGrpNo() {
        return grpNo;
    }

    public void setGrpNo(Long grpNo) {
        this.grpNo = grpNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTaxRegistNo() {
        return taxRegistNo;
    }

    public void setTaxRegistNo(String taxRegistNo) {
        this.taxRegistNo = taxRegistNo;
    }

    public String getGuiAddress() {
        return guiAddress;
    }

    public void setGuiAddress(String guiAddress) {
        this.guiAddress = guiAddress;
    }

    public Long getReturnAllow() {
        return returnAllow;
    }

    public void setReturnAllow(Long returnAllow) {
        this.returnAllow = returnAllow;
    }

    public Long getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Long paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(Long paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public Long getOrdMethod() {
        return ordMethod;
    }

    public void setOrdMethod(Long ordMethod) {
        this.ordMethod = ordMethod;
    }

    public String getOplSchedule() {
        return oplSchedule;
    }

    public void setOplSchedule(String oplSchedule) {
        this.oplSchedule = oplSchedule;
    }

    public Long getMinOplCd() {
        return minOplCd;
    }

    public void setMinOplCd(Long minOplCd) {
        this.minOplCd = minOplCd;
    }

    public Long getMinOpl() {
        return minOpl;
    }

    public void setMinOpl(Long minOpl) {
        this.minOpl = minOpl;
    }

    public Long getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Long leadTime) {
        this.leadTime = leadTime;
    }

    public String getDelivSchedule() {
        return delivSchedule;
    }

    public void setDelivSchedule(String delivSchedule) {
        this.delivSchedule = delivSchedule;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Long getBankConfirm() {
        return bankConfirm;
    }

    public void setBankConfirm(Long bankConfirm) {
        this.bankConfirm = bankConfirm;
    }

    public Long getFaxNoExt() {
        return faxNoExt;
    }

    public void setFaxNoExt(Long faxNoExt) {
        this.faxNoExt = faxNoExt;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public Long getBankDay() {
        return bankDay;
    }

    public void setBankDay(Long bankDay) {
        this.bankDay = bankDay;
    }

    public String getFnUsr() {
        return fnUsr;
    }

    public void setFnUsr(String fnUsr) {
        this.fnUsr = fnUsr;
    }

    public Long getBuyVat() {
        return buyVat;
    }

    public void setBuyVat(Long buyVat) {
        this.buyVat = buyVat;
    }

    public Long getWebStatus() {
        return webStatus;
    }

    public void setWebStatus(Long webStatus) {
        this.webStatus = webStatus;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getSmsNo() {
        return smsNo;
    }

    public void setSmsNo(String smsNo) {
        this.smsNo = smsNo;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public Long getWebShowBp() {
        return webShowBp;
    }

    public void setWebShowBp(Long webShowBp) {
        this.webShowBp = webShowBp;
    }

}
