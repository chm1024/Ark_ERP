package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by GeYupeng on 2016-11-02.
 */

@Entity
@Table(name = "INTERFALIST",schema="ttdba")
public class InterfaceEntity {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String Id;


    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "DISCRIPTION")
    private String discription;

    @Basic
    @Column(name = "STATUS")
    private String status;

    @Basic
    @Column(name = "URL")
    private String url;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
