package com.micolor.entity.userinterface;

/**
 * Created by liuhx on 2016/11/23 0023.
 */
public class OrderItemsId implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private Integer storeNo;

    private Long ordNo;

    private Long skuCode;

    private Integer free;


    public OrderItemsId() {

    }

    public OrderItemsId(Integer storeNo, Long ordNo, Long skuCode, Integer free) {
        this.storeNo = storeNo;
        this.ordNo = ordNo;
        this.skuCode = skuCode;
        this.free = free;
    }

    public Integer getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Integer storeNo) {
        this.storeNo = storeNo;
    }

    public Long getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(Long ordNo) {
        this.ordNo = ordNo;
    }

    public Long getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Long skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemsId that = (OrderItemsId) o;

        if (!storeNo.equals(that.storeNo)) return false;
        if (!ordNo.equals(that.ordNo)) return false;
        if (!skuCode.equals(that.skuCode)) return false;
        return free.equals(that.free);

    }

    @Override
    public int hashCode() {
        int result = storeNo.hashCode();
        result = 31 * result + ordNo.hashCode();
        result = 31 * result + skuCode.hashCode();
        result = 31 * result + free.hashCode();
        return result;
    }
}
