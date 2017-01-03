package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by liuhx on 2016/11/22 0022.
 */
@Entity
@Table(name="orders")
@IdClass(value=OrdersId.class)
public class Orders implements Serializable{

    private static final long serialVersionUID = 1L;

    public Orders() {
    }

    @Id
    @Column(name="ORD_NO")
    private Long poNo;

    @Id
    @Column(name="STORE_NO")
    private Long storeNo;

    @Column(name="SUP_NO")
    private Long supNo;

    @Column(name="UNIFORM_NO")
    private String uniformNo;

    @Column(name="USR")
    private  String usr;

    @Column(name="STATUS")
    private Integer status;

    @Column(name="TYPE")
    private Integer type;

    @Column(name="ORD_DATE")
    @Temporal(TemporalType.DATE)
    private Date ordDate;

    @Column(name="PLAN_RECPT_DATE")
    @Temporal(TemporalType.DATE)
    private Date planRecptDate;

    @Column(name="REAL_RECPT_DATE")
    @Temporal(TemporalType.DATE)
    private Date realRecptDate;

    @Column(name="RECPT_NO")
    private Long recptNo;

    @Column(name="PRINT")
    private Integer print;

    @Column(name="PROMOTION_NO")
    private Integer promotionNo;

    @Column(name="REF_NO")
    private Long refNO;

    @Column(name="NET_AMNT")
    private Double netAmnt;

    @Column(name="DEPOSIT_AMNT")
    private Double depositAmnt;

    @Column(name="TOTAL_AMNT")
    private Double totalAmnt;

    @Column(name="TOTAL_QTY")
    private Double totalQty;

    @Column(name="PAYMENT_PERIOD")
    private Integer paymentPeriod;

    @Column(name="MEMO1")
    private String memo1;

    @Column(name="MEMO2")
    private String memo2;

    @Column(name="SETTLE_TYPE")
    private Integer settleType;

    @Column(name="DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name="BANK_DAY")
    private Integer bankDay;

    @Column(name="VAT_NO")
    private Integer vatNo;

    @Column(name="INV_TYPE")
    private Integer invType;

    @Transient
    private String orgId;

    @Transient
    private String whCode;

    /*@OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="ORD_NO",referencedColumnName = "ORD_NO")*/
    @Transient
    private List<OrderItems> orderItemses;

    public Long getPoNo() {
        return poNo;
    }

    public void setPoNo(Long poNo) {
        this.poNo = poNo;
    }

    public Long getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Long getSupNo() {
        return supNo;
    }

    public void setSupNo(Long supNo) {
        this.supNo = supNo;
    }

    public String getUniformNo() {
        return uniformNo;
    }

    public void setUniformNo(String uniformNo) {
        this.uniformNo = uniformNo;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public Date getPlanRecptDate() {
        return planRecptDate;
    }

    public void setPlanRecptDate(Date planRecptDate) {
        this.planRecptDate = planRecptDate;
    }

    public Date getRealRecptDate() {
        return realRecptDate;
    }

    public void setRealRecptDate(Date realRecptDate) {
        this.realRecptDate = realRecptDate;
    }

    public Long getRecptNo() {
        return recptNo;
    }

    public void setRecptNo(Long recptNo) {
        this.recptNo = recptNo;
    }

    public Integer getPrint() {
        return print;
    }

    public void setPrint(Integer print) {
        this.print = print;
    }

    public Integer getPromotionNo() {
        return promotionNo;
    }

    public void setPromotionNo(Integer promotionNo) {
        this.promotionNo = promotionNo;
    }

    public Long getRefNO() {
        return refNO;
    }

    public void setRefNO(Long refNO) {
        this.refNO = refNO;
    }

    public Double getNetAmnt() {
        return netAmnt;
    }

    public void setNetAmnt(Double netAmnt) {
        this.netAmnt = netAmnt;
    }

    public Double getDepositAmnt() {
        return depositAmnt;
    }

    public void setDepositAmnt(Double depositAmnt) {
        this.depositAmnt = depositAmnt;
    }

    public Double getTotalAmnt() {
        return totalAmnt;
    }

    public void setTotalAmnt(Double totalAmnt) {
        this.totalAmnt = totalAmnt;
    }

    public Double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Double totalQty) {
        this.totalQty = totalQty;
    }

    public Integer getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(Integer paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    public Integer getSettleType() {
        return settleType;
    }

    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getBankDay() {
        return bankDay;
    }

    public void setBankDay(Integer bankDay) {
        this.bankDay = bankDay;
    }

    public Integer getVatNo() {
        return vatNo;
    }

    public void setVatNo(Integer vatNo) {
        this.vatNo = vatNo;
    }

    public Integer getInvType() {
        return invType;
    }

    public void setInvType(Integer invType) {
        this.invType = invType;
    }

    public List<OrderItems> getOrderItemses() {
        return orderItemses;
    }

    public void setOrderItemses(List<OrderItems> orderItemses) {
        this.orderItemses = orderItemses;
    }
}
