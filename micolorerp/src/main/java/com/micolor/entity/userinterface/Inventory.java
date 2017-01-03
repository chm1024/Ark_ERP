package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**库存同步表
 * Created by Administrator on 2016/11/23.
 */
@Entity
@Table(name = "Inventory")
@XmlRootElement(name = "Inventory")
public class Inventory {
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
     * 商品编码
     */
    @XmlElement
    @Column(name = "SKUCODE")
    private String skuCode;
    /**
     * 库存数量
     */
    @XmlElement
    @Column(name = "qty")
    private Double qty;
    /**
     * 库存可用数量
     */
    @XmlElement
    @Column(name = "qtyAvailable")
    private Double qtyAvailable;
    /**
     * 日期
     */
    @XmlElement
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @Column(name = "date_")
    private Date date;

    /**
     * 是否采购开票
     */
    @XmlElement
    @Column(name = "isInvoice")
    private String isInvoice;
    /**
     * 当前行数
     */
    @XmlElement
    @Column(name = "currentLine")
    private String currentLine;
    /**
     * 总行数
     */
    @XmlElement
    @Column(name = "totalLine")
    private String totalLine;
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
    public String getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine;
    }

    @XmlTransient
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }

    @XmlTransient
    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    @XmlTransient
    public Double getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(Double qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    @XmlTransient
    public String getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(String totalLine) {
        this.totalLine = totalLine;
    }
}
