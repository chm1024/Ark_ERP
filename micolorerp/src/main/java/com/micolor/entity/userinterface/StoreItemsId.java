
package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * store_items(XX表)
 */
public class StoreItemsId implements Serializable{

    private Long storeNO;

    private Long itemNo;

    public StoreItemsId() {
    }

    public StoreItemsId(Long storeNO, Long itemNo) {
        this.storeNO = storeNO;
        this.itemNo = itemNo;
    }

    public Long getStoreNO() {
        return storeNO;
    }

    public void setStoreNO(Long storeNO) {
        this.storeNO = storeNO;
    }

    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreItemsId that = (StoreItemsId) o;

        if (!storeNO.equals(that.storeNO)) return false;
        return itemNo.equals(that.itemNo);

    }

    @Override
    public int hashCode() {
        int result = storeNO.hashCode();
        result = 31 * result + itemNo.hashCode();
        return result;
    }
}
