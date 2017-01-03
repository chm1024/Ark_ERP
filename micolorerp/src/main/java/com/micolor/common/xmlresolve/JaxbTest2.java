package com.micolor.common.xmlresolve;

/**
 * Created by liusi on 2016/11/17.
 */
import com.micolor.common.util.SendXML;
import com.micolor.entity.userinterface.SalesDelivery;
import org.junit.Test;

import java.util.List;

/**
 * @author      zhuc
 * @create      2013-3-29 下午2:52:00
 */
public class JaxbTest2 {

    @Test
    public void showMarshaller() {

        Student student = new Student();
        student.setId(12);
        student.setName("test");

        Role role = new Role();
        role.setDesc("管理");
        role.setName("班长");

        student.setRole(role);

        String str = JaxbUtil.convertToXml(student);
        System.out.println(str);
    }

    @Test
    public void showUnMarshaller() {
        /*String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<SalesDevlivey>\n" +
                "\t<SalesDevliveyHeader>\n" +
                "\t\t<whCode>LS001</whCode>\n" +
                "\t\t<soNo>G55673</soNo>\n" +
                "\t\t<shipNo>888</shipNo>\n" +
                "\t</SalesDevliveyHeader>\n" +
                "\t<SalesDevliveyItems>\n" +
                "\t\t<SalesDevliveyItem>\n" +
                "\t\t\t<soLineNo>0001</soLineNo>\n" +
                "\t\t\t<skuCode>C001</skuCode>\n" +
                "\t\t\t<shipTime>2016-10-20 15:00:00</shipTime>\n" +
                "\t\t\t<qtyShipEa>100</qtyShipEa>\n" +
                "\t\t\t<shipAvailableQuantity>100</shipAvailableQuantity>\n" +
                "\t\t\t<amount>150</amount>\n" +
                "\t\t</SalesDevliveyItem>\n" +
                "\t\t<SalesDevliveyItem>\n" +
                "\t\t\t<soLineNo>0002</soLineNo>\n" +
                "\t\t\t<skuCode>C002</skuCode>\n" +
                "\t\t\t<shipTime>afadsfa0</shipTime>\n" +
                "\t\t\t<qtyShipEa>abcdd</qtyShipEa>\n" +
                "\t\t\t<shipAvailableQuantity>100</shipAvailableQuantity>\n" +
                "\t\t\t<amount>150</amount>\n" +
                "\t\t</SalesDevliveyItem>\n" +
                "\t</SalesDevliveyItems>\n" +
                "</SalesDevlivey>\n";*/

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<SalesDevlivey>\n" +
                "\t<SalesDevliveyHeader>\n" +
                "\t\t<whCode>LS001</whCode>\n" +
                "\t\t<soNo>G55673</soNo>\n" +
                "\t\t<shipNo>888</shipNo>\n" +
                "\t</SalesDevliveyHeader>\n" +
                "\t<SalesDevliveyItems>\n" +
                "\t\t<SalesDevliveyItem>\n" +
                "\t\t\t<soLineNo>0001</soLineNo>\n" +
                "\t\t\t<skuCode>C001</skuCode>\n" +
                "\t\t\t<shipTime>2016-10-20 15:00:00</shipTime>\n" +
                "\t\t\t<qtyShipEa>100</qtyShipEa>\n" +
                "\t\t\t<shipAvailableQuantity>100</shipAvailableQuantity>\n" +
                "\t\t\t<amount>150</amount>\n" +
                "\t\t</SalesDevliveyItem>\n" +
                "\t\t<SalesDevliveyItem>\n" +
                "\t\t\t<soLineNo>0002</soLineNo>\n" +
                "\t\t\t<skuCode>C002</skuCode>\n" +
                "\t\t\t<shipTime>afadsfa0</shipTime>\n" +
                "\t\t\t<qtyShipEa>abcdd</qtyShipEa>\n" +
                "\t\t\t<shipAvailableQuantity>100</shipAvailableQuantity>\n" +
                "\t\t\t<amount>150</amount>\n" +
                "\t\t</SalesDevliveyItem>\n" +
                "\t</SalesDevliveyItems>\n" +
                "</SalesDevlivey>\n";

        System.out.println(str);

        String returnXml=SendXML.doHttpPost(str,"http://localhost:8080/erp/jsp/userinterface/P001/transferInfo.action");
//        String returnXml=SendXML.postXML(str,"jsp/userinterface/P007/transferInfo.action");
        System.out.println(returnXml);
        /*List<SalesDelivery> s = JaxbUtil.converyToJavaBean(str, SalesDelivery.class,"SalesDevlivey");
        System.out.println(s);*/
    }

}