package com.micolor.entity.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by GEYUPENG on 2016/4/18.
 */
@Entity
@Table(name = "sys_organization",schema="ttdba")
public class TOrganizationEntity {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Basic
    @Column(name = "organcode")
    private String organcode;

    @Basic
    @Column(name = "organname")
    private String organname;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "tel")
    private String tel;

    @Basic
    @Column(name = "fax")
    private String fax;

    @Basic
    @Column(name = "mail")
    private String mail;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "priority")
    private Integer priority;

    @Basic
    @Column(name = "parent_id")
    private Integer parent_id;

    @Basic
    @Column(name = "status")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
