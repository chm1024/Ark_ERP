package com.micolor.entity.system;

import javax.persistence.*;

/**
 * Created by Evangoe on 03/06/16.
 */

@Entity
@Table(name="sys_dictionary",schema="ttdba")

public class TDictionary {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic
    @Column(name="name")
    private String name;
    @Basic
    @Column(name="priority")
    private Integer priority;
    @Basic
    @Column(name="type")
    private String type;
    @Basic
    @Column(name="value")
    private String value;
    @Basic
    @Column(name="parent_id")
    private Integer parent_id;
    @Basic
    @Column(name="code")
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
