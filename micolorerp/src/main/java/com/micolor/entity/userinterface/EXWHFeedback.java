package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**出库反馈表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "EXWHFeedback")
@XmlRootElement(name = "EXWHFeedback")
public class EXWHFeedback {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    /**
     * 仓库编码
     */
    @XmlElement
    @Column(name = "WHCODE")
    private String whCode;
    /**
     * 订单类型
     */
    @XmlElement
    @Column(name = "shipType")
    private String shipType;
    /**
     * 客户订单号
     */
    @XmlElement
    @Column(name = "logisticNo")
    private String logisticNo;
    /**
     * 出库单号
     */
    @XmlElement
    @Column(name = "shipNo")
    private String shipNo;
    /**
     * 客户订单行号
     */
    @XmlElement
    @Column(name = "logisticLineNo")
    private String logisticLineNo;

    /**
     * 商品编码
     */
    @XmlElement
    @Column(name = "SKUCODE")
    private String skuCode;
    /**
     * 发货日期
     */
    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateTimeSerializer.class)
    @Column(name = "shipTime")
    private Date shipTime;
    /**
     * 发货数量
     */
    @XmlElement(name="qtyRcvEa")
    @Column(name = "qtyShipEa")
    private Double qtyShipEa;
    /**
     * 发货可用数量
     */
    @XmlElement
    @Column(name = "shipAvailableQuantity")
    private Double shipAvailableQuantity;
    /**
     * 是否采购开票
     */
    @XmlElement
    @Column(name = "isInvoice")
    private String isInvoice;
    /**
     * 创建时间
     */
    @XmlElement
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 状态
     */
    @XmlElement
    @Column(name = "STATUS")
    private Long status;

    @XmlTransient
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlTransient
    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    @XmlTransient
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @XmlTransient
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlTransient
    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    @XmlTransient
    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }

    @XmlTransient
    public String getLogisticLineNo() {
        return logisticLineNo;
    }

    public void setLogisticLineNo(String logisticLineNo) {
        this.logisticLineNo = logisticLineNo;
    }

    @XmlTransient
    public String getLogisticNo() {
        return logisticNo;
    }

    public void setLogisticNo(String logisticNo) {
        this.logisticNo = logisticNo;
    }

    @XmlTransient
    public Double getQtyShipEa() {
        return qtyShipEa;
    }

    public void setQtyShipEa(Double qtyShipEa) {
        this.qtyShipEa = qtyShipEa;
    }

    @XmlTransient
    public Double getShipAvailableQuantity() {
        return shipAvailableQuantity;
    }

    public void setShipAvailableQuantity(Double shipAvailableQuantity) {
        this.shipAvailableQuantity = shipAvailableQuantity;
    }

    @XmlTransient
    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    @XmlTransient
    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    @XmlTransient
    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }
}
