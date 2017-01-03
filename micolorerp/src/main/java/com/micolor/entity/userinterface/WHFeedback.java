package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**入库反馈表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "WHFeedback")
@XmlRootElement(name = "WHFeedback")
public class WHFeedback {
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
    @Column(name = "asnType")
    private String asnType;
    /**
     * 客户订单号
     */
    @XmlElement
    @Column(name = "logisticNo")
    private String logisticNo;
    /**
     * 入库单号
     */
    @XmlElement
    @Column(name = "asnNo")
    private String asnNo;
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
     * 收货日期
     */
    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateTimeSerializer.class)
    @Column(name = "rcvTime")
    private Date rcvTime;
    /**
     * 发货数量
     */
    @XmlElement
    @Column(name = "qtyRcvEa")
    private Double qtyRcvEa;
    /**
     * 收货可用数量
     */
    @XmlElement
    @Column(name = "receiptAvailableQuantity")
    private Double receiptAvailableQuantity;
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
    public Double getQtyRcvEa() {
        return qtyRcvEa;
    }

    public void setQtyRcvEa(Double qtyRcvEa) {
        this.qtyRcvEa = qtyRcvEa;
    }

    @XmlTransient
    public Double getReceiptAvailableQuantity() {
        return receiptAvailableQuantity;
    }

    public void setReceiptAvailableQuantity(Double receiptAvailableQuantity) {
        this.receiptAvailableQuantity = receiptAvailableQuantity;
    }

    @XmlTransient
    public Date getRcvTime() {
        return rcvTime;
    }

    public void setRcvTime(Date rcvTime) {
        this.rcvTime = rcvTime;
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
    public String getAsnNo() {
        return asnNo;
    }

    public void setAsnNo(String asnNo) {
        this.asnNo = asnNo;
    }


    @XmlTransient
    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    @XmlTransient
    public String getAsnType() {
        return asnType;
    }

    public void setAsnType(String asnType) {
        this.asnType = asnType;
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
}
