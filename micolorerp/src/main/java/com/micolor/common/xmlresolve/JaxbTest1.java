package com.micolor.common.xmlresolve;

/**
 * Created by liusi on 2016/11/17.
 */
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBException;

import com.micolor.entity.userinterface.*;
import org.junit.Test;
import com.micolor.common.xmlresolve.JaxbUtil;


/**
 * @author      zhuc
 * @create      2013-3-29 下午2:50:00
 */
public class JaxbTest1 {

    /**
     * @throws JAXBException
     */
    @Test
    public void showMarshaller()  {
        Book book = new Book();
        book.setId(200);
        book.setAuthor("James");
        book.setCalendar(new Date());
        book.setPrice(23.45f);   //默认是0.0

        String str = JaxbUtil.convertToXml(book);
        System.out.println(str);
    }

    /**
     * @throws JAXBException
     */
    @Test
    public void showUnMarshaller() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<SalesReturn>\n" +
                "\t<SalesReturnHeader>\n" +
                "\t\t<whCode>LS001</whCode>\n" +
                "\t\t<soNo>G55673</soNo>\n" +
                "\t\t<asnNo>R6348</asnNo>\n" +
                "\t</SalesReturnHeader>\n" +
                "\t<SalesReturnItems>\n" +
                "\t\t<SalesReturnItem>\n" +
                "\t\t\t<soLineNo>0001</soLineNo>\n" +
                "\t\t\t<skuCode>C001</skuCode>\n" +
                "\t\t\t<shipTime>2016-10-20 15:00:00</shipTime>\n" +
                "\t\t\t<qtyRcvEa>100</qtyRcvEa>\n" +
                "\t\t\t<receiptAvailableQuantity>100</receiptAvailableQuantity>\n" +
                "\t\t\t<amount>150</amount>\n" +
                "\t\t</SalesReturnItem>\n" +
                "\t\t<SalesReturnItem>\n" +
                "\t\t\t<soLineNo>0002</soLineNo>\n" +
                "\t\t\t<skuCode>C002</skuCode>\n" +
                "\t\t\t<shipTime>2016-10-20 15:00:00</shipTime>\n" +
                "\t\t\t<qtyRcvEa>100</qtyRcvEa>\n" +
                "\t\t\t<receiptAvailableQuantity>100</receiptAvailableQuantity>\n" +
                "\t\t\t<amount>150</amount>\n" +
                "\t\t</SalesReturnItem>\n" +
                "\t</SalesReturnItems>\n" +
                "</SalesReturn>\n";

        List<SalesReturn> s = JaxbUtil.converyToJavaBean(str, SalesReturn.class,new String[]{"SalesReturn"});
        System.out.println(s);
    }
}