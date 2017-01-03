package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by liusi on 2016/11/26.
 * 接口F003实体 采购订单主数据视图ID联合主键类
 *
 */
@Embeddable
public class VPoHeaderId implements java.io.Serializable{

    public VPoHeaderId() {
    }

    public VPoHeaderId(String poNo) {
        this.poNo = poNo;
    }

    @Column(name = "PONO")
    private String poNo;

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }
}
