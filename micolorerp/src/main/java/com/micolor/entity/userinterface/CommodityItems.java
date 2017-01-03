package com.micolor.entity.userinterface;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.List;

/**商品条码类
 * Created by Administrator on 2016/11/11.
 */
@Entity
@Table(name = "COMMODITYITEMS")
public class CommodityItems {
    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String Id;
    @Column(name = "SKUCODE")
    private String skuCode;
    @Column(name = "BARCODE")
    private String barCode;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
}
