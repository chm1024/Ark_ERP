package com.micolor.entity.system;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by GEYUPENG on 2016/4/14.
 */
@Entity
@Table(name = "SYS_USER",schema="ttdba")
public class UserEntity {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String Id;
    @Basic
    @Column(name = "USERNAME")
    private String userName;
    @Basic
    @Column(name = "NICKNAME")
    private String nickName;
    @Basic
    @Column(name = "ROLENAME")
    private String roleName;
    @Basic
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "PASSWORD")
    private String passWord;
    @Basic
    @Column(name = "PHONE")
    private String phone;
    @Basic
    @Column(name = "REALNAME")
    private String realName;
    @Basic
    @Column(name = "SALT")
    private String salt;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "ORGANIZATION_ID")
    private Integer organizationId;
    @Basic
    @Column(name = "STAFF_ID")
    private Integer staffId;
    @Basic
    @Column(name = "TYPE")
    private String type;
    @Basic
    @Column(name = "GUID")
    private String guid;
    @Basic
    @Column(name = "PAY")
    private String pay;
    @Basic
    @Column(name = "MEMBER_ID")
    private Integer memberId;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }



}
