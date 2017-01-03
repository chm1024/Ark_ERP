package com.micolor.module.userinterface.F001.service;

import com.micolor.common.entities.MsgBean;
import com.micolor.entity.userinterface.Barcode;
import com.micolor.entity.userinterface.VCommodityHeader;

import java.util.List;

/**
 * Created by liuhx on 24/11/16.
 * F001 商品主数据SERVICE
 */
public interface VCommodityHeaderSerivce {
//    Commodity getCommodityByKey(String skuCode);

    void sendVCommodityHeader();

    List<VCommodityHeader> getList();

    List<Barcode> getBarcodeByItemNo(Long itemNo);
}
