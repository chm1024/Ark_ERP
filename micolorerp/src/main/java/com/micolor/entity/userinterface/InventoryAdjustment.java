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
@Table(name = "InventoryAdjustment")
@XmlRootElement(name = "InventoryAdjustment")
public class InventoryAdjustment {
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
     * 单据号
     */
    @XmlElement
    @Column(name = "orderNo")
    private String orderNo;
    /**
     * 调整类型编码
     */
    @XmlElement
    @Column(name = "adjustmentTypeCode")
    private String adjustmentTypeCode;

    /**
     * 商品编码
     */
    @XmlElement
    @Column(name = "SKUCODE")
    private String skuCode;
    /**
     * 调整数量
     */
    @XmlElement
    @Column(name = "adjustQuantity")
    private Double adjustQuantity;
    /**
     * 调整可用数量
     */
    @XmlElement
    @Column(name = "adjustAvailableQuantity")
    private Double adjustAvailableQuantity;
    /**
     * 调整人
     */
    @XmlElement
    @Column(name = "adjustOperator")
    private String adjustOperator;
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
    public Double getAdjustAvailableQuantity() {
        return adjustAvailableQuantity;
    }

    public void setAdjustAvailableQuantity(Double adjustAvailableQuantity) {
        this.adjustAvailableQuantity = adjustAvailableQuantity;
    }

    @XmlTransient
    public String getAdjustmentTypeCode() {
        return adjustmentTypeCode;
    }

    public void setAdjustmentTypeCode(String adjustmentTypeCode) {
        this.adjustmentTypeCode = adjustmentTypeCode;
    }

    @XmlTransient
    public String getAdjustOperator() {
        return adjustOperator;
    }

    public void setAdjustOperator(String adjustOperator) {
        this.adjustOperator = adjustOperator;
    }

    @XmlTransient
    public Double getAdjustQuantity() {
        return adjustQuantity;
    }

    public void setAdjustQuantity(Double adjustQuantity) {
        this.adjustQuantity = adjustQuantity;
    }

    @XmlTransient
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
