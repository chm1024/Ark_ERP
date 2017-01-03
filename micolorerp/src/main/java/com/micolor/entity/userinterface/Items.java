
package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * items(XX表)
 */
@Entity
@Table(name="items")
public class Items implements Serializable{

    /*
     *商品编码
     */
    @javax.persistence.Id
    @Column(name = "ITEM_NO")
    private Long itemNO;

/**
* 未知
*/
@Column(name="SUP_NO",nullable=false, length=7)
private Long supNo;

/**
* 商品类型编码
*/
@Column(name="GRP_NO",nullable=false, length=3)
private Long grpNo;

/**
* 商品子类编码
*/
@Column(name="SUBGRP_NO",nullable=false, length=3)
private Long subgrpNo;

/**
* 商品子类编码(二)
*/
@Column(name="SUBGRP2_NO",nullable=false, length=3)
private Long subgrp2No;

/**
* 未知
*/
@Column(name="USR",nullable=false, length=8)
private String usr;

/**
* 商品名称
*/
@Column(name="NAME",nullable=false, length=33)
private String name;

/**
* 未知
*/
@Column(name="SPEC",length=30)
private String spec;

/**
* 未知
*/
@Column(name="GRADE_NO",nullable=false, length=1)
private Long gradeNo;

/**
* 未知
*/
@Column(name="ORIGIN_CD",nullable=false, length=3)
private Long originCd;

/**
* 未知
*/
@Column(name="SUB_ORIGIN",length=10)
private String subOrigin;

/**
* 未知
*/
@Column(name="TYPE",nullable=false, length=1)
private Long type;

/**
* 未知
*/
@Column(name="BUY_UNIT",nullable=false, length=4)
private Long buyUnit;

/**
* 未知
*/
@Column(name="ORDER_UNIT",nullable=false, length=4)
private Long orderUnit;

/**
* 未知
*/
@Column(name="SELL_UNIT",nullable=false, length=3)
private Long sellUnit;

/**
* 未知
*/
@Column(name="DEPOSIT",length=8)
private Long deposit;

/**
* 未知
*/
@Column(name="DEPOSIT_VAT",length=1)
private Long depositVat;

/**
* 未知
*/
@Column(name="PACK",nullable=false, length=2)
private String pack;

/**
* 未知
*/
@Column(name="TICKET",nullable=false, length=1)
private Long ticket;

/**
* 未知
*/
@Column(name="RAILCARD",nullable=false, length=1)
private Long railcard;

/**
* 未知
*/
@Column(name="BUY_WHEN",nullable=false, length=1)
private Long buyWhen;

/**
* 未知
*/
@Column(name="BUY_PRICE",nullable=false, length=10)
private Long buyPrice;

/**
* 未知
*/
@Column(name="BUY_VAT",nullable=false, length=1)
private Long buyVat;

/**
* 未知
*/
@Column(name="SELL_PRICE",nullable=false, length=8)
private Long sellPrice;

/**
* 未知
*/
@Column(name="SELL_VAT",nullable=false, length=1)
private Long sellVat;

/**
* 未知
*/
@Column(name="OPL_METHOD",nullable=false, length=1)
private Long oplMethod;

/**
* 未知
*/
@Column(name="STATUS",nullable=false, length=1)
private Long status;

/**
* 未知
*/
@Column(name="SCALE_NAME",length=24)
private String scaleName;

/**
* 未知
*/
@Column(name="EXPIRY_DAYS",length=4)
private Long expiryDays;

/**
* 未知
*/
@Column(name="UPD_SELL_PR",length=1)
private Long updSellPr;

/**
* 未知
*/
@Column(name="LOCAL_SELL_PR",nullable=false, length=1)
private Long localSellPr;

/**
* 未知
*/
@Column(name="UPD_SCALE_PR",length=1)
private Long updScalePr;

/**
* 未知
*/
@Column(name="MEMO",length=10)
private String memo;

/**
* 未知
*/
@Column(name="CREATED_DATE",nullable=false, length=7)
    @Temporal(TemporalType.DATE)
private Date createdDate;

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
@Column(name="FACE",length=5)
private Long face;

/**
* 未知
*/
@Column(name="HEIGHT",length=5)
private Long height;

/**
* 未知
*/
@Column(name="DEPTH",length=5)
private Long depth;

/**
* 未知
*/
@Column(name="PRINT_SEQ",length=3)
private Long printSeq;

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
@Column(name="STAPLE",length=30)
private String staple;

/**
* 未知
*/
@Column(name="SAVE_METHOD",length=20)
private String saveMethod;

/**
* 未知
*/
@Column(name="EAT_METHOD",length=20)
private String eatMethod;

/**
* 未知
*/
@Column(name="DC_FLAG",length=1)
private Long dcFlag;

/**
* 未知
*/
@Column(name="DC_ST_UNIT",nullable=false, length=7)
private Long dcStUnit;

/**
* 未知
*/
@Column(name="PB_FLAG",length=1)
private Long pbFlag;

/**
* 未知
*/
@Column(name="TC_FLAG",length=1)
private Long tcFlag;

/**
* 未知
*/
@Column(name="POS_FLAG",length=1)
private Long posFlag;

/**
* 未知
*/
@Column(name="BRAND",length=4)
private Long brand;

/**
* 未知
*/
@Column(name="NET_WEIGHT",length=6)
private Long netWeight;

/**
* 未知
*/
@Column(name="GROSS_WEIGHT",length=6)
private Long grossWeight;

    /*
    *商品仓库
    */
   /* @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="ITEM_NO",referencedColumnName = "ITEM_NO")*/
   @Transient
    private List<StoreItems> storeItems;

    /*
    *商品仓库
    */
    /*@OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumns ({
            @JoinColumn(name="GRP_NO",referencedColumnName = "GRP_NO",insertable = false, updatable = false),
            @JoinColumn(name="SUBGRP_NO",referencedColumnName = "SUBGRP_NO",insertable = false, updatable = false)
    })*/
    @Transient
    private List<SubGroups> subGroups;

    /*
    *BARCODE
    */
    /*@OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="ITEM_NO",referencedColumnName = "ITEM_NO")*/
    @Transient
    private List<Barcode> barcodes;


    public Long getItemNO() {
        return itemNO;
    }

    public void setItemNO(Long itemNO) {
        this.itemNO = itemNO;
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
* @param grpNo the grpNo to set
*/
public void setGrpNo(Long grpNo){
this.grpNo = grpNo;
}

/**
* @return the grpNo
*/
public Long getGrpNo(){
return this.grpNo;
}

/**
* @param subgrpNo the subgrpNo to set
*/
public void setSubgrpNo(Long subgrpNo){
this.subgrpNo = subgrpNo;
}

/**
* @return the subgrpNo
*/
public Long getSubgrpNo(){
return this.subgrpNo;
}

/**
* @param subgrp2No the subgrp2No to set
*/
public void setSubgrp2No(Long subgrp2No){
this.subgrp2No = subgrp2No;
}

/**
* @return the subgrp2No
*/
public Long getSubgrp2No(){
return this.subgrp2No;
}

/**
* @param usr the usr to set
*/
public void setUsr(String usr){
this.usr = usr;
}

/**
* @return the usr
*/
public String getUsr(){
return this.usr;
}

/**
* @param name the name to set
*/
public void setName(String name){
this.name = name;
}

/**
* @return the name
*/
public String getName(){
return this.name;
}

/**
* @param spec the spec to set
*/
public void setSpec(String spec){
this.spec = spec;
}

/**
* @return the spec
*/
public String getSpec(){
return this.spec;
}

/**
* @param gradeNo the gradeNo to set
*/
public void setGradeNo(Long gradeNo){
this.gradeNo = gradeNo;
}

/**
* @return the gradeNo
*/
public Long getGradeNo(){
return this.gradeNo;
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
* @param type the type to set
*/
public void setType(Long type){
this.type = type;
}

/**
* @return the type
*/
public Long getType(){
return this.type;
}

/**
* @param buyUnit the buyUnit to set
*/
public void setBuyUnit(Long buyUnit){
this.buyUnit = buyUnit;
}

/**
* @return the buyUnit
*/
public Long getBuyUnit(){
return this.buyUnit;
}

/**
* @param orderUnit the orderUnit to set
*/
public void setOrderUnit(Long orderUnit){
this.orderUnit = orderUnit;
}

/**
* @return the orderUnit
*/
public Long getOrderUnit(){
return this.orderUnit;
}

/**
* @param sellUnit the sellUnit to set
*/
public void setSellUnit(Long sellUnit){
this.sellUnit = sellUnit;
}

/**
* @return the sellUnit
*/
public Long getSellUnit(){
return this.sellUnit;
}

/**
* @param deposit the deposit to set
*/
public void setDeposit(Long deposit){
this.deposit = deposit;
}

/**
* @return the deposit
*/
public Long getDeposit(){
return this.deposit;
}

/**
* @param depositVat the depositVat to set
*/
public void setDepositVat(Long depositVat){
this.depositVat = depositVat;
}

/**
* @return the depositVat
*/
public Long getDepositVat(){
return this.depositVat;
}

/**
* @param pack the pack to set
*/
public void setPack(String pack){
this.pack = pack;
}

/**
* @return the pack
*/
public String getPack(){
return this.pack;
}

/**
* @param ticket the ticket to set
*/
public void setTicket(Long ticket){
this.ticket = ticket;
}

/**
* @return the ticket
*/
public Long getTicket(){
return this.ticket;
}

/**
* @param railcard the railcard to set
*/
public void setRailcard(Long railcard){
this.railcard = railcard;
}

/**
* @return the railcard
*/
public Long getRailcard(){
return this.railcard;
}

/**
* @param buyWhen the buyWhen to set
*/
public void setBuyWhen(Long buyWhen){
this.buyWhen = buyWhen;
}

/**
* @return the buyWhen
*/
public Long getBuyWhen(){
return this.buyWhen;
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
* @param buyVat the buyVat to set
*/
public void setBuyVat(Long buyVat){
this.buyVat = buyVat;
}

/**
* @return the buyVat
*/
public Long getBuyVat(){
return this.buyVat;
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
* @param sellVat the sellVat to set
*/
public void setSellVat(Long sellVat){
this.sellVat = sellVat;
}

/**
* @return the sellVat
*/
public Long getSellVat(){
return this.sellVat;
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
* @param scaleName the scaleName to set
*/
public void setScaleName(String scaleName){
this.scaleName = scaleName;
}

/**
* @return the scaleName
*/
public String getScaleName(){
return this.scaleName;
}

/**
* @param expiryDays the expiryDays to set
*/
public void setExpiryDays(Long expiryDays){
this.expiryDays = expiryDays;
}

/**
* @return the expiryDays
*/
public Long getExpiryDays(){
return this.expiryDays;
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
* @param updScalePr the updScalePr to set
*/
public void setUpdScalePr(Long updScalePr){
this.updScalePr = updScalePr;
}

/**
* @return the updScalePr
*/
public Long getUpdScalePr(){
return this.updScalePr;
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
* @param createdDate the createdDate to set
*/
public void setCreatedDate(Date createdDate){
this.createdDate = createdDate;
}

/**
* @return the createdDate
*/
public Date getCreatedDate(){
return this.createdDate;
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
* @param face the face to set
*/
public void setFace(Long face){
this.face = face;
}

/**
* @return the face
*/
public Long getFace(){
return this.face;
}

/**
* @param height the height to set
*/
public void setHeight(Long height){
this.height = height;
}

/**
* @return the height
*/
public Long getHeight(){
return this.height;
}

/**
* @param depth the depth to set
*/
public void setDepth(Long depth){
this.depth = depth;
}

/**
* @return the depth
*/
public Long getDepth(){
return this.depth;
}

/**
* @param printSeq the printSeq to set
*/
public void setPrintSeq(Long printSeq){
this.printSeq = printSeq;
}

/**
* @return the printSeq
*/
public Long getPrintSeq(){
return this.printSeq;
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
* @param staple the staple to set
*/
public void setStaple(String staple){
this.staple = staple;
}

/**
* @return the staple
*/
public String getStaple(){
return this.staple;
}

/**
* @param saveMethod the saveMethod to set
*/
public void setSaveMethod(String saveMethod){
this.saveMethod = saveMethod;
}

/**
* @return the saveMethod
*/
public String getSaveMethod(){
return this.saveMethod;
}

/**
* @param eatMethod the eatMethod to set
*/
public void setEatMethod(String eatMethod){
this.eatMethod = eatMethod;
}

/**
* @return the eatMethod
*/
public String getEatMethod(){
return this.eatMethod;
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

/**
* @param dcStUnit the dcStUnit to set
*/
public void setDcStUnit(Long dcStUnit){
this.dcStUnit = dcStUnit;
}

/**
* @return the dcStUnit
*/
public Long getDcStUnit(){
return this.dcStUnit;
}

/**
* @param pbFlag the pbFlag to set
*/
public void setPbFlag(Long pbFlag){
this.pbFlag = pbFlag;
}

/**
* @return the pbFlag
*/
public Long getPbFlag(){
return this.pbFlag;
}

/**
* @param tcFlag the tcFlag to set
*/
public void setTcFlag(Long tcFlag){
this.tcFlag = tcFlag;
}

/**
* @return the tcFlag
*/
public Long getTcFlag(){
return this.tcFlag;
}

/**
* @param posFlag the posFlag to set
*/
public void setPosFlag(Long posFlag){
this.posFlag = posFlag;
}

/**
* @return the posFlag
*/
public Long getPosFlag(){
return this.posFlag;
}

/**
* @param brand the brand to set
*/
public void setBrand(Long brand){
this.brand = brand;
}

/**
* @return the brand
*/
public Long getBrand(){
return this.brand;
}

/**
* @param netWeight the netWeight to set
*/
public void setNetWeight(Long netWeight){
this.netWeight = netWeight;
}

/**
* @return the netWeight
*/
public Long getNetWeight(){
return this.netWeight;
}

/**
* @param grossWeight the grossWeight to set
*/
public void setGrossWeight(Long grossWeight){
this.grossWeight = grossWeight;
}

/**
* @return the grossWeight
*/
public Long getGrossWeight(){
return this.grossWeight;
}

    public List<StoreItems> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(List<StoreItems> storeItems) {
        this.storeItems = storeItems;
    }

    public List<SubGroups> getSubGroups() {
        return subGroups;
    }

    public void setSubGroups(List<SubGroups> subGroups) {
        this.subGroups = subGroups;
    }

    public List<Barcode> getBarcodes() {
        return barcodes;
    }

    public void setBarcodes(List<Barcode> barcodes) {
        this.barcodes = barcodes;
    }
}
