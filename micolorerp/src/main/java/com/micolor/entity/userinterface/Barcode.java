
package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Barcode(XX表)
 */
@Entity
@Table(name="barcode")
public class Barcode implements Serializable {

    @EmbeddedId
    private BarcodeId barcodeId;

    public BarcodeId getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(BarcodeId barcodeId) {
        this.barcodeId = barcodeId;
    }
}
