package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**入库物流状态反馈表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "WHLogisticsFeedback")
@XmlRootElement(name = "WHLogisticsFeedback")
public class WHLogisticsFeedback {
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
     * 采购订单号
     */
    @XmlElement
    @Column(name = "poNo")
    private String poNo;
    /**
     * 入库单号
     */
    @XmlElement
    @Column(name = "asnNo")
    private String asnNo;
    /**
     * 客户订单行号
     */
    @XmlElement(name="status")
    @Column(name = "orderStatus")
    private String orderStatus;

    /**
     * 状态描述
     */
    @XmlElement(name="statusDescription")
    @Column(name = "orderStatusDescription")
    private String orderStatusDescription;
    /**
     * 时间
     */
    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateTimeSerializer.class)
    @Column(name = "dateTime")
    private Date dateTime;
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
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @XmlTransient
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @XmlTransient
    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

    @XmlTransient
    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }
}
