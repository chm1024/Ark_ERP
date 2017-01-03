package com.micolor.entity.userinterface;


/**
 * Created by liusi on 2016/11/23.
 * 订单实体联合主键类
 */
public class OrdersId implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private Long poNo;
    private Long storeNo;

    public OrdersId(){}

    public OrdersId(Long poNo, Long storeNo) {
        this.poNo = poNo;
        this.storeNo = storeNo;
    }

    public Long getPoNo() {
        return poNo;
    }

    public void setPoNo(Long poNo) {
        this.poNo = poNo;
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

        OrdersId ordersId = (OrdersId) o;

        if (!poNo.equals(ordersId.poNo)) return false;
        return storeNo.equals(ordersId.storeNo);

    }

    @Override
    public int hashCode() {
        int result = poNo.hashCode();
        result = 31 * result + storeNo.hashCode();
        return result;
    }
}
