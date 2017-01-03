package com.micolor.entity.demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * FileName:com.micolor.entity.DictClass.
 * Discription: 字典类别表
 * Author: geyupeng.
 * DateTime 16/3/2.
 */
@Entity
@Table(name="t_dictclass",schema="ttdba")
public class DictClassEntity {
    @Id
    @Column(name="dicode")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String dicode;
    @Basic
    @Column(name="diname")
    private String diname;
    @Basic
    @Column(name="adtimesp")
    private Date adtimesp;

    @Basic
    @Column(name="distatus")
    private String distatus;
    @Basic
    @Column(name="cocode")
    private String cocode;

    public String getDicode() {
        return dicode;
    }

    public void setDicode(String dicode) {
        this.dicode = dicode;
    }

    public String getDiname() {
        return diname;
    }

    public void setDiname(String diname) {
        this.diname = diname;
    }

    public Date getAdtimesp() {
        return adtimesp;
    }

    public void setAdtimesp(Date adtimesp) {
        this.adtimesp = adtimesp;
    }

    public String getDistatus() {
        return distatus;
    }

    public void setDistatus(String distatus) {
        this.distatus = distatus;
    }

    public String getCocode() {
        return cocode;
    }

    public void setCocode(String cocode) {
        this.cocode = cocode;
    }
}
