package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
@Entity
@Table(name = "v_poreceiptheader")
public class VPoReceiptHeader {

    @javax.persistence.Id
    @Column(name = "PONO")
    private Long poNo;

    @Column(name = "WHCODE")
    private String whCode;

    @Column(name = "ORGID")
    private String orgId;

    @OneToMany(fetch= FetchType.EAGER,cascade={CascadeType.ALL} )
    @JoinColumn(name="PONO",referencedColumnName = "PONO")
    private List<VPoReceiptItem> vPoReceiptItems;

    public Long getPoNo() {
        return poNo;
    }

    public void setPoNo(Long poNo) {
        this.poNo = poNo;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<VPoReceiptItem> getVPoReceiptItems() {
        return vPoReceiptItems;
    }

    public void setVPoReceiptItems(List<VPoReceiptItem> vPoReceiptItems) {
        this.vPoReceiptItems = vPoReceiptItems;
    }
}
