package com.micolor.common.xmlresolve;

/**
 * Created by liusi on 2016/11/17.
 */
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Jaxb2工具类
 * @author      zhuc
 * @create      2013-3-29 下午2:40:14
 */
public class JaxbUtil {

    /**
     * JavaBean转换成xml
     * 默认编码UTF-8
     * @param obj
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        return convertToXml(obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * xml转换成JavaBean(xml内 存在多条Item的情况下，保存多条)
     * @param xml xml信息
     * @param c 转义的类
     * @param replaceElements 需要替换的标签（根标签、head、item）
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> converyToJavaBean(String xml, Class<T> c,String[] replaceElements) {
        List<T> listObject=new ArrayList<T>();
        try {
            List<String> list=new ArrayList<String>();
            String headXml=getElement(xml,list,replaceElements);
            for(int i=0;i<list.size();i++){
                String xmlInfo="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><"+replaceElements[0]+">";
                xmlInfo+=headXml+list.get(i)+"</"+replaceElements[0]+">";
                JAXBContext context = JAXBContext.newInstance(c);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                T t = (T) unmarshaller.unmarshal(new StringReader(xmlInfo));
                listObject.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listObject;
    }

    /**解析xml
     * @param xml
     * @return
     */
    public static String getElement(String xml,List<String> list,String[] replaceElements){
        //申明上下文
        Document doc=null;
        String headXml="";
        try {
            //获取返回接口的xml的上下文
            doc = (Document) DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        try {
            headXml=traversalElement(root,list,replaceElements);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headXml;
    }
    /**递归获取xml信息并将ITEM内的xml截取出来
     * @param et
     * @throws Exception
     */
    public static String traversalElement(Element et,List<String> list , String[] replaceElements) throws Exception{
        String headXml="";
        List subElements = et.elements();
        for( int i=0;i<subElements.size();i++){
            Element ele = (Element)subElements.get(i);
            /*截取出headxml beign*/
            if(replaceElements[1].toLowerCase().equals(ele.getName().toLowerCase())) {
                List itemElements = ele.elements();
                for(int j=0;j<itemElements.size();j++){
                    Element eleItem = (Element)itemElements.get(j);
                    headXml+="<"+eleItem.getName()+">"+eleItem.getText()+"</"+eleItem.getName()+">";
                }
            }
            /*截取出headxml end*/
            if((replaceElements[2]+"s").toLowerCase().equals(ele.getName().toLowerCase())) {
                traversalElement(ele, list, replaceElements);
            }
            /*截取出itemxml beign*/
            if(replaceElements[2].toLowerCase().equals(ele.getName().toLowerCase())) {
                List itemElements = ele.elements();
                StringBuffer itemXml=new StringBuffer();
                for(int j=0;j<itemElements.size();j++){
                    Element eleItem = (Element)itemElements.get(j);
                    itemXml.append("<"+eleItem.getName()+">"+eleItem.getText()+"</"+eleItem.getName()+">");
                }
                list.add(itemXml.toString());
            }
            /*截取出itemxml end*/
        }
        return headXml;
    }
}