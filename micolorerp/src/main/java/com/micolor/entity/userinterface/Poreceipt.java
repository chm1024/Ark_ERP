package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**采购收货类
 * Created by fangjw on 2016/11/21.
 */
@Entity
@Table(name="PORECEIPT")
public class Poreceipt {
    /**
     * 仓库编码
     */
    @javax.persistence.Id
    @Column(name = "WHCODE")
    private String whCode;
    /**
     * 采购订单号
     */
    @Column(name = "PONO")
    private String poNo;
    /**
     * 组织编码
     */
    @Column(name = "ORGID")
    private String orgId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
}
