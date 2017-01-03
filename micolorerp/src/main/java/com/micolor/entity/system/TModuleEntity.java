package com.micolor.entity.system;

import javax.persistence.*;

/**
 * Created by GEYUPENG on 2016/4/18.
 */
@Entity
@Table(name="sys_module",schema="ttdba")
public class TModuleEntity {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic
    @Column(name = "class_name")
    private String className;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "priority")
    private String priority;
    @Basic
    @Column(name = "sn")
    private String sn;
    @Basic
    @Column(name = "url")
    private String url;
    @Basic
    @Column(name = "parent_id")
    private Integer parentId;
    @Basic
    @Column(name = "icon")
    private String icon;
    @Basic
    @Column(name = "cssid")
    private String cssid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCssid() {
        return cssid;
    }

    public void setCssid(String cssid) {
        this.cssid = cssid;
    }
}
