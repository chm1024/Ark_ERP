package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**销售发货主表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "SalesDelivery")
@XmlRootElement(name = "SalesDevlivey")
public class SalesDelivery {
    /**
     * 主键ID
     */
    @javax.persistence.Id
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
     * 出库单号
     */
    @XmlElement
    @Column(name = "SHIPNO")
    private String shipNo;
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
     * 发货日期
     */
    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateTimeSerializer.class)
    @Column(name = "SHIPTIME")
    private Date shipTime;
    /**
     * 发货数量
     */
    @XmlElement
    @Column(name = "QTYSHIPEA")
    private Double qtyShipEa;
    /**
     * 发货可用数量
     */
    @XmlElement
    @Column(name = "SHIPAVAILABLEQUANTITY")
    private Double shipAvailableQuantity;
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
    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
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
    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
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
