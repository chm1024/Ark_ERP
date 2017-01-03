
package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.Date;

/**
 * store_items(XX表)
 */
@Entity
@Table(name="store_items")
@IdClass(value = StoreItemsId.class)
public class StoreItems{

    @Id
    @Column(name = "STORE_NO")
    private Long storeNO;

/**
* 未知
*/
@Id
@Column(name="ITEM_NO",nullable=false, length=6)
private Long itemNo;

/**
* 未知
*/
@Column(name="BUY_PRICE",length=10)
private Long buyPrice;

/**
* 未知
*/
@Column(name="SELL_PRICE",length=8)
private Long sellPrice;

/**
* 未知
*/
@Column(name="SUP_NO",length=7)
private Long supNo;

/**
* 未知
*/
@Column(name="OPL_METHOD",length=1)
private Long oplMethod;

/**
* 未知
*/
@Column(name="STATUS",nullable=false, length=1)
private Long status;

/**
* 未知
*/
@Column(name="UPD_SELL_PR",length=1)
private Long updSellPr;

/**
* 未知
*/
@Column(name="LOCAL_SELL_PR",length=1)
private Long localSellPr;

/**
* 未知
*/
@Column(name="PICK_UP",length=1)
private Long pickUp;

/**
* 未知
*/
@Column(name="MEMO",length=10)
private String memo;

/**
* 未知
*/
@Column(name="CHANGED_DATE",nullable=false, length=7)
    @Temporal(TemporalType.DATE)
private Date changedDate;

/**
* 未知
*/
@Column(name="DELETED_DATE",length=7)
    @Temporal(TemporalType.DATE)
private Date deletedDate;

/**
* 未知
*/
@Column(name="ORIGIN_CD",length=3)
private Long originCd;

/**
* 未知
*/
@Column(name="SUB_ORIGIN",length=10)
private String subOrigin;

/**
* 未知
*/
@Column(name="HANDLE",length=1)
private String handle;

/**
* 未知
*/
@Column(name="HANDLE_FROM",length=7)
    @Temporal(TemporalType.DATE)
private Date handleFrom;

/**
* 未知
*/
@Column(name="HANDLE_TO",length=7)
    @Temporal(TemporalType.DATE)
private Date handleTo;

/**
* 未知
*/
@Column(name="DC_FLAG",length=1)
private Long dcFlag;

    public Long getStoreNO() {
        return storeNO;
    }

    public void setStoreNO(Long storeNO) {
        this.storeNO = storeNO;
    }

    /**
* @param itemNo the itemNo to set
*/
public void setItemNo(Long itemNo){
this.itemNo = itemNo;
}

/**
* @return the itemNo
*/
public Long getItemNo(){
return this.itemNo;
}

/**
* @param buyPrice the buyPrice to set
*/
public void setBuyPrice(Long buyPrice){
this.buyPrice = buyPrice;
}

/**
* @return the buyPrice
*/
public Long getBuyPrice(){
return this.buyPrice;
}

/**
* @param sellPrice the sellPrice to set
*/
public void setSellPrice(Long sellPrice){
this.sellPrice = sellPrice;
}

/**
* @return the sellPrice
*/
public Long getSellPrice(){
return this.sellPrice;
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
* @param oplMethod the oplMethod to set
*/
public void setOplMethod(Long oplMethod){
this.oplMethod = oplMethod;
}

/**
* @return the oplMethod
*/
public Long getOplMethod(){
return this.oplMethod;
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
* @param updSellPr the updSellPr to set
*/
public void setUpdSellPr(Long updSellPr){
this.updSellPr = updSellPr;
}

/**
* @return the updSellPr
*/
public Long getUpdSellPr(){
return this.updSellPr;
}

/**
* @param localSellPr the localSellPr to set
*/
public void setLocalSellPr(Long localSellPr){
this.localSellPr = localSellPr;
}

/**
* @return the localSellPr
*/
public Long getLocalSellPr(){
return this.localSellPr;
}

/**
* @param pickUp the pickUp to set
*/
public void setPickUp(Long pickUp){
this.pickUp = pickUp;
}

/**
* @return the pickUp
*/
public Long getPickUp(){
return this.pickUp;
}

/**
* @param memo the memo to set
*/
public void setMemo(String memo){
this.memo = memo;
}

/**
* @return the memo
*/
public String getMemo(){
return this.memo;
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
* @param deletedDate the deletedDate to set
*/
public void setDeletedDate(Date deletedDate){
this.deletedDate = deletedDate;
}

/**
* @return the deletedDate
*/
public Date getDeletedDate(){
return this.deletedDate;
}

/**
* @param originCd the originCd to set
*/
public void setOriginCd(Long originCd){
this.originCd = originCd;
}

/**
* @return the originCd
*/
public Long getOriginCd(){
return this.originCd;
}

/**
* @param subOrigin the subOrigin to set
*/
public void setSubOrigin(String subOrigin){
this.subOrigin = subOrigin;
}

/**
* @return the subOrigin
*/
public String getSubOrigin(){
return this.subOrigin;
}

/**
* @param handle the handle to set
*/
public void setHandle(String handle){
this.handle = handle;
}

/**
* @return the handle
*/
public String getHandle(){
return this.handle;
}

/**
* @param handleFrom the handleFrom to set
*/
public void setHandleFrom(Date handleFrom){
this.handleFrom = handleFrom;
}

/**
* @return the handleFrom
*/
public Date getHandleFrom(){
return this.handleFrom;
}

/**
* @param handleTo the handleTo to set
*/
public void setHandleTo(Date handleTo){
this.handleTo = handleTo;
}

/**
* @return the handleTo
*/
public Date getHandleTo(){
return this.handleTo;
}

/**
* @param dcFlag the dcFlag to set
*/
public void setDcFlag(Long dcFlag){
this.dcFlag = dcFlag;
}

/**
* @return the dcFlag
*/
public Long getDcFlag(){
return this.dcFlag;
}
}
