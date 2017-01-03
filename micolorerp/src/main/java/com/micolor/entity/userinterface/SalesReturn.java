package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**销售退货表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "SalesReturn")
@XmlRootElement(name = "SalesReturn")
public class SalesReturn {
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
     * 销售订单号
     */
    @XmlElement
    @Column(name = "SONO")
    private String soNo;
    /**
     * 入库单号
     */
    @XmlElement
    @Column(name = "asnNo")
    private String asnNo;
    /**
     * 销售订单行号
     */
    @XmlElement
    @Column(name = "SOLINENO")
    private String soLineNo;

    /**
     * 商品编码
     */
    @XmlElement
    @Column(name = "SKUCODE")
    private String skuCode;
    /**
     * 收货日期
     */
    @XmlElement(name="shipTime")
    @XmlJavaTypeAdapter(JaxbDateTimeSerializer.class)
    @Column(name = "rcvTime")
    private Date rcvTime;
    /**
     * 收货数量
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
     * 金额
     */
    @XmlElement
    @Column(name = "AMOUNT")
    private Double amount;
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
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

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
    public String getSoNo() {
        return soNo;
    }

    public void setSoNo(String soNo) {
        this.soNo = soNo;
    }

    @XmlTransient
    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    @XmlTransient
    public String getSoLineNo() {
        return soLineNo;
    }

    public void setSoLineNo(String soLineNo) {
        this.soLineNo = soLineNo;
    }
}
