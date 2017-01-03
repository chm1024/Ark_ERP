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
 * @author      方锦文
 * @create      2016-11-27 下午2:40:14
 */
public class ResolveXMLToObject {

	/**
	 * xml转换成JavaBean(格式:<BEAN><BEANINFO></BEANINFO></BEAN>)
	 * @param xml xml信息
	 * @param c 转义的类
	 * @param rootElement 需要替换的标签（根标签）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> converyToJavaBean(String xml, Class<T> c,String rootElement) {
		List<T> listObject=new ArrayList<T>();
		try {
			List<String> list=new ArrayList<String>();
			getElement(xml,list,rootElement);
			for(int i=0;i<list.size();i++){
				String xmlInfo="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><"+rootElement+">";
				xmlInfo+=list.get(i)+"</"+rootElement+">";
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
	public static void getElement(String xml,List<String> list,String rootElement){
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
			traversalElement(root,list,rootElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**递归获取xml信息并将Info内的xml截取出来
	 * @param et
	 * @throws Exception
	 */
	public static void traversalElement(Element et,List<String> list , String rootElement) throws Exception{
		List subElements = et.elements();
		for( int i=0;i<subElements.size();i++){
			Element ele = (Element)subElements.get(i);
            /*截取出Info内xml beign*/
			if((rootElement+"Info").toLowerCase().equals(ele.getName().toLowerCase())) {
				List itemElements = ele.elements();
				StringBuffer itemXml=new StringBuffer();
				for(int j=0;j<itemElements.size();j++){
					Element eleItem = (Element)itemElements.get(j);
					itemXml.append("<"+eleItem.getName()+">"+eleItem.getText()+"</"+eleItem.getName()+">");
				}
				list.add(itemXml.toString());
			}
            /*截取出Info内xml end*/
		}
	}
}