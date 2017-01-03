package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/11/27 0027.
 */
@Entity
@Table(name = "daily_log")
public class DailyLog implements java.io.Serializable{

    @EmbeddedId
    private DailyLogId dailyLogId;

    @Column(name="status")
    private Integer status;

    public DailyLogId getDailyLogId() {
        return dailyLogId;
    }

    public void setDailyLogId(DailyLogId dailyLogId) {
        this.dailyLogId = dailyLogId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
