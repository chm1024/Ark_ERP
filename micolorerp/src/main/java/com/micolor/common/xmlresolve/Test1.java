package com.micolor.common.xmlresolve;

import com.micolor.common.util.SendXML;
import com.micolor.entity.userinterface.Barcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class Test1 {
    public static void main(String[] ar){
        ResolveObjectToXML r=new ResolveObjectToXML();
        /*Commodity c=new Commodity();
        c.setSkuCode("432432");
        c.setPackCode("234324");
        c.setSyncFlag("1");
        c.setOwnerCode("123");
        List<Barcode> list=new ArrayList<Barcode>();
        Barcode barcode=new Barcode();
        list.add(barcode);
        barcode=new Barcode();
        list.add(barcode);*//*
        XMLLayout layout=new XMLLayout("Commodity","CommodityHeader","CommodityItem",new String[]{"ownerCode","syncFlag"},new String[]{"barcode"});
        String str=r.objectToXml(c,layout,true);
        System.out.println(str);*/
    }
}
