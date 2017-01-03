package com.micolor.entity.demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Evangoe on 24/06/16.
 */
@Entity
@Table(name="t_transvalue",schema="ttdba")
public class TransValue {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Basic
    @Column(name="tvkey")
    private String tvkey;
    @Basic
    @Column(name="disc")
    private String disc;
    @Basic
    @Column(name="transdisc")
    private String transdisc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTvkey() {
        return tvkey;
    }

    public void setTvkey(String tvkey) {
        this.tvkey = tvkey;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getTransdisc() {
        return transdisc;
    }

    public void setTransdisc(String transdisc) {
        this.transdisc = transdisc;
    }

}
