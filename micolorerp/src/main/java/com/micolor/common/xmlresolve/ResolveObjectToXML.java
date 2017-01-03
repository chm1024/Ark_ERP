package com.micolor.common.xmlresolve;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**XML解析类
 * @author 方锦文
 *
 */
@Component
public class ResolveObjectToXML<T> {
	/**将实体类解析成XML  排除父节点
	 * @param entity 需要转换的实体
	 * @param layout XML节点类
	 * @param hasChild 是否有子节点
	 * @return XML
     */
    public String objectToXml(T entity,XMLLayout layout,boolean hasChild){
		Field[] contentFields=entity.getClass().getDeclaredFields();
		StringBuffer sb=new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<"+layout.getRoot()+">\n"); //根标签
		sb.append("\t<"+layout.getHead()+">\n"); //头部标签
		//遍历字段
		for(Field field:contentFields){
			try {
				String type=field.getType().toString();//获取字段类型
				//list类型不处理
				if(!type.equals("interface java.util.List")){
					// 如果实体属性在排除数组中，则continue。否则拼接XML字符串
					boolean contain = Arrays.asList(layout.getNotShowNode()).contains(field.getName());
					if(contain){
						continue;
					}else{
						Method method = entity.getClass().getMethod("get"+captureName(field.getName()));
						Object obj=method.invoke(entity);
						if(obj==null)
							obj="";
						sb.append("\t\t<"+field.getName()+">"+obj+"</"+field.getName()+">\n");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sb.append("\t</"+layout.getHead()+">\n");//头部结束标签
		sb.append("\t<"+layout.getItem()+"s>\n");//子内容标签
		//如果有子标签，则遍历list
		if(hasChild) {
			for (Field field : contentFields) {
				try {
					String type = field.getType().toString();
					if (type.equals("interface java.util.List")) {
						//获取list的get方法
						Method listMethod = entity.getClass().getMethod("get"+captureName(field.getName()));
						//获取List字段类型
						ParameterizedType pt = (ParameterizedType) field.getGenericType();
						//得到泛型里的class类型。
						Class genericClazz = (Class) pt.getActualTypeArguments()[0];
						Object listObject=listMethod.invoke(entity);
						List list=null;
						if(listObject!=null)
							list= (List) listObject;
						else
							continue;
						String[] childNames=layout.getChildName();
						if(list.size() == 0){
							sb.append("\t\t<" + layout.getItem() + ">\n");
							for (int i = 0; i < childNames.length; i++) {
								Method method = genericClazz.getMethod("get" + captureName(childNames[i]));
								sb.append("\t\t\t<" + childNames[i] + "></" + childNames[i] + ">\n");
							}
							sb.append("\t\t</" + layout.getItem() + ">\n");
						}
						for(Object listObj:list) {
							sb.append("\t\t<" + layout.getItem() + ">\n");
							for (int i = 0; i < childNames.length; i++) {
								Method method = genericClazz.getMethod("get" + captureName(childNames[i]));
								Object obj = method.invoke(listObj);
								if (obj == null)
									obj = "";
								sb.append("\t\t\t<" + childNames[i] + ">" + obj + "</" + childNames[i] + ">\n");
							}
							sb.append("\t\t</" + layout.getItem() + ">\n");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		sb.append("\t</"+layout.getItem()+"s>\n");//子内容结束标签
		sb.append("</"+layout.getRoot()+">\n");//根结束标签
		return sb.toString();
	}

	/**将实体类解析成XML 指定父节点
	 * @param entity 需要转换的实体
	 * @param layout XML节点类
	 * @param hasChild 是否有子节点
	 * @return XML
	 */
	public String objectToXmlInclude(T entity,XMLLayout layout,boolean hasChild){
		Field[] contentFields=entity.getClass().getDeclaredFields();
		StringBuffer sb=new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<"+layout.getRoot()+">\n"); //根标签
		sb.append("\t<"+layout.getHead()+">\n"); //头部标签
		//遍历字段
		for(Field field:contentFields){
			try {
				String type=field.getType().toString();//获取字段类型
				//list类型不处理
				if(!type.equals("interface java.util.List")){
					// 如果实体属性在排除数组中，则continue。否则拼接XML字符串
					boolean contain = Arrays.asList(layout.getNotShowNode()).contains(field.getName());
					if(contain){
						Method method = entity.getClass().getMethod("get"+captureName(field.getName()));
						Object obj=method.invoke(entity);
						if(obj==null)
							obj="";
						sb.append("\t\t<"+field.getName()+">"+obj+"</"+field.getName()+">\n");
					}else{
						continue;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sb.append("\t</"+layout.getHead()+">\n");//头部结束标签
		sb.append("\t<"+layout.getItem()+"s>\n");//子内容标签
		//如果有子标签，则遍历list
		if(hasChild) {
			for (Field field : contentFields) {
				try {
					String type = field.getType().toString();
					if (type.equals("interface java.util.List")) {
						//获取list的get方法
						Method listMethod = entity.getClass().getMethod("get"+captureName(field.getName()));
						//获取List字段类型
						ParameterizedType pt = (ParameterizedType) field.getGenericType();
						//得到泛型里的class类型。
						Class genericClazz = (Class) pt.getActualTypeArguments()[0];
						Object listObject=listMethod.invoke(entity);
						List list=null;
						if(listObject!=null)
							list= (List) listObject;
						else
							continue;
						String[] childNames=layout.getChildName();
						for(Object listObj:list) {
							sb.append("\t\t<" + layout.getItem() + ">\n");
							for (int i = 0; i < childNames.length; i++) {
								Method method = genericClazz.getMethod("get" + captureName(childNames[i]));
								Object obj = method.invoke(listObj);
								if (obj == null)
									obj = "";
								sb.append("\t\t\t<" + childNames[i] + ">" + obj + "</" + childNames[i] + ">\n");
							}
							sb.append("\t\t</" + layout.getItem() + ">\n");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		sb.append("\t</"+layout.getItem()+"s>\n");//子内容结束标签
		sb.append("</"+layout.getRoot()+">\n");//根结束标签
		return sb.toString();
	}

	/**首字母转为大写
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
		char[] cs=name.toCharArray();
		cs[0]-=(cs[0]>96&&cs[0]<123)?32:0;
		return String.valueOf(cs);
	}
}
