package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by liuhx on 2016/11/27 0027.
 */
@Embeddable
public class DailyLogId implements java.io.Serializable{

    public DailyLogId() {
    }

    public DailyLogId(String tName, String keyvalue) {
        this.tName = tName;
        this.keyvalue = keyvalue;
    }

    @Column(name="TNAME")
    private String tName;

    @Column(name="VALUE")
    private String keyvalue;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue;
    }
}
