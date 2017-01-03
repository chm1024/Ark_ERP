package com.micolor.entity.userinterface;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by liusi on 2016/11/24.
 * 接口F001实体 商品主数据视图ID联合主键类
 *
 */
@Embeddable
public class VCommodityHeaderId implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    public VCommodityHeaderId() {
    }

    public VCommodityHeaderId(Long skuCode,Long storeNo) {
        this.storeNo = storeNo;
        this.skuCode = skuCode;
    }

    private Long skuCode;

    private Long storeNo;

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public Long getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VCommodityHeaderId that = (VCommodityHeaderId) o;

        if (skuCode != null ? !skuCode.equals(that.skuCode) : that.skuCode != null) return false;
        return storeNo != null ? storeNo.equals(that.storeNo) : that.storeNo == null;

    }

    @Override
    public int hashCode() {
        int result = skuCode != null ? skuCode.hashCode() : 0;
        result = 31 * result + (storeNo != null ? storeNo.hashCode() : 0);
        return result;
    }
}
