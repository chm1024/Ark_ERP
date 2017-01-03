
package com.micolor.entity.userinterface;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Barcode(XX表)
 */
@Embeddable
public class BarcodeId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String barCode;

    @Column(name="item_no")
    private Long itemNo;

    public BarcodeId() {
    }

    public BarcodeId(String barCode, Long itemNo) {
        this.barCode = barCode;
        this.itemNo = itemNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarcode(String barcode) {
        this.barCode = barcode;
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

        BarcodeId barcodeId = (BarcodeId) o;

        if (!barCode.equals(barcodeId.barCode)) return false;
        return itemNo.equals(barcodeId.itemNo);

    }

    @Override
    public int hashCode() {
        int result = barCode.hashCode();
        result = 31 * result + itemNo.hashCode();
        return result;
    }
}
