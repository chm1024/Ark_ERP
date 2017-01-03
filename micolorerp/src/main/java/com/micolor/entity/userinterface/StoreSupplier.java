
package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.Date;

/**
 * store_supplier(XX表)
 */
@Entity
@Table(name="store_supplier")
public class StoreSupplier{
    @javax.persistence.Id
    @Column(name = "STORE_NO")
    private Long storeNo;

/**
* 未知
*/
@Column(name="SUP_NO",nullable=false, length=7)
private Long supNo;

/**
* 未知
*/
@Column(name="STATUS",nullable=false, length=1)
private Long status;

/**
* 未知
*/
@Column(name="UNIFORM_NO",length=20)
private String uniformNo;

/**
* 未知
*/
@Column(name="GUI_ADDRESS",length=50)
private String guiAddress;

/**
* 未知
*/
@Column(name="RETURN_ALLOW",length=1)
private Long returnAllow;

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
@Column(name="CHANGED_DATE",length=7)
    @Temporal(TemporalType.DATE)
private Date changedDate;

/**
* 未知
*/
@Column(name="OPL_SCHEDULE",length=7)
private String oplSchedule;

    public Long getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }

    /**
* @param supNo the supNo to set
*/
public void setSupNo(Long supNo){
this.supNo = supNo;
}

/**
* @return the supNo
*/
public Long getSupNo(){
return this.supNo;
}

/**
* @param status the status to set
*/
public void setStatus(Long status){
this.status = status;
}

/**
* @return the status
*/
public Long getStatus(){
return this.status;
}

/**
* @param uniformNo the uniformNo to set
*/
public void setUniformNo(String uniformNo){
this.uniformNo = uniformNo;
}

/**
* @return the uniformNo
*/
public String getUniformNo(){
return this.uniformNo;
}

/**
* @param guiAddress the guiAddress to set
*/
public void setGuiAddress(String guiAddress){
this.guiAddress = guiAddress;
}

/**
* @return the guiAddress
*/
public String getGuiAddress(){
return this.guiAddress;
}

/**
* @param returnAllow the returnAllow to set
*/
public void setReturnAllow(Long returnAllow){
this.returnAllow = returnAllow;
}

/**
* @return the returnAllow
*/
public Long getReturnAllow(){
return this.returnAllow;
}

/**
* @param minOplCd the minOplCd to set
*/
public void setMinOplCd(Long minOplCd){
this.minOplCd = minOplCd;
}

/**
* @return the minOplCd
*/
public Long getMinOplCd(){
return this.minOplCd;
}

/**
* @param minOpl the minOpl to set
*/
public void setMinOpl(Long minOpl){
this.minOpl = minOpl;
}

/**
* @return the minOpl
*/
public Long getMinOpl(){
return this.minOpl;
}

/**
* @param leadTime the leadTime to set
*/
public void setLeadTime(Long leadTime){
this.leadTime = leadTime;
}

/**
* @return the leadTime
*/
public Long getLeadTime(){
return this.leadTime;
}

/**
* @param delivSchedule the delivSchedule to set
*/
public void setDelivSchedule(String delivSchedule){
this.delivSchedule = delivSchedule;
}

/**
* @return the delivSchedule
*/
public String getDelivSchedule(){
return this.delivSchedule;
}

/**
* @param changedDate the changedDate to set
*/
public void setChangedDate(Date changedDate){
this.changedDate = changedDate;
}

/**
* @return the changedDate
*/
public Date getChangedDate(){
return this.changedDate;
}

/**
* @param oplSchedule the oplSchedule to set
*/
public void setOplSchedule(String oplSchedule){
this.oplSchedule = oplSchedule;
}

/**
* @return the oplSchedule
*/
public String getOplSchedule(){
return this.oplSchedule;
}
}
