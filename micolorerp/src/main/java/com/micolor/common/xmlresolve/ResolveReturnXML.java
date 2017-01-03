package com.micolor.common.xmlresolve;

/**
 * Created by liusi on 2016/11/17.
 */

import com.micolor.entity.userinterface.InterfaceMsg;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Jaxb2工具类
 * @author      方锦文
 * @create      2016-11-27 下午2:40:14
 */
public class ResolveReturnXML {

	/**解析xml
	 * @param xml
	 * @return
	 */
	public static InterfaceMsg getReturnXml(String xml){
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
		InterfaceMsg msg=new InterfaceMsg();
		try {
			traversalElement(root,msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	/**递归获取xml信息并将Info内的xml截取出来
	 * @param et
	 * @throws Exception
	 */
	public static void traversalElement(Element et,InterfaceMsg msg) throws Exception{
		List subElements = et.elements();
		for( int i=0;i<subElements.size();i++){
			Element ele = (Element)subElements.get(i);
			if("status".toLowerCase().equals(ele.getName().toLowerCase())) {
				msg.setStatus(ele.getText());
			}
			if("errorMsg".toLowerCase().equals(ele.getName().toLowerCase())) {
				msg.setErrorMsg(ele.getText());
			}
			if("errorCode".toLowerCase().equals(ele.getName().toLowerCase())) {
				msg.setErrorCode(ele.getText());
			}
		}
	}
}