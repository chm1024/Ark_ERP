package com.micolor.common.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.micolor.entity.userinterface.InterfaceMsg;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendXML {
	private static String ipPort="localhost:2020";
	public static String postXML(final String xml){
		return doPostXML(xml,"http://"+ipPort+"/");
	}
	public static String postXMLByUrl(final String xml,String url){
		return doPostXML(xml,url);
	}
	public static String postXML(final String xml,String url){
		return doPostXML(xml,"http://"+ipPort+"/"+url);
	}
	public static String doPostXML(final String xml,String url){
		final HttpClient httpClient = new DefaultHttpClient();
		//测试环境
		final HttpPost httpPost = new HttpPost(url);
		final StringBuffer returnXml=new StringBuffer();
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					List<NameValuePair> formparams = new ArrayList<NameValuePair>();
					formparams.add(new BasicNameValuePair("reqData", xml));
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
					httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
					httpPost.setEntity(entity);
					HttpEntity httpEntity = httpClient.execute(httpPost).getEntity();
					InputStreamReader reader = new InputStreamReader(httpEntity.getContent(), "utf-8");
					char[] buff = new char[1024];
					int length = 0;
					while ((length = reader.read(buff)) != -1) {
						returnXml.append(new String(buff, 0, length));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "Timeout guard");
		t.setDaemon(true);
		t.start();
		try {
			t.join(10000l);  //等待5s后结束
		} catch (InterruptedException e) {
			System.out.println("发送失败");
			httpClient.getConnectionManager().shutdown();
		}
		if (t.isAlive()) {
			System.out.println("发送超时");
			httpClient.getConnectionManager().shutdown();
			t.interrupt();
			return "发送超时";
		}
		System.out.println("发送成功");
		return returnXml.toString();
	}

	/**
	 * 调用接口后返回XML信息
	 * @param interfaceMsg 返回正确/错误信息类
     * @return
     */
	public static void printReturnXml(InterfaceMsg interfaceMsg){
		StringBuffer sb=new StringBuffer("");
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<response>");
		if("success".equals(interfaceMsg.getStatus())){
			sb.append("<status>success</status>");
		}else{
			sb.append("<status>fail</status>");
			sb.append("<error>");
			sb.append("<errorMsg>"+interfaceMsg.getErrorMsg()+"</errorMsg >");
			sb.append("<errorCode>"+interfaceMsg.getErrorCode()+"</errorCode >");
			sb.append("</error>");
		}
		sb.append("</response>");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 发送Http post请求
	 *
	 * @param xml
	 *            xml格式的字符串
	 * @param strURL
	 *            请求url
	 * @return 获取返回信息
	 * @throws UnsupportedEncodingException
	 */
	public static String doHttpPost(String xml,String strURL){
		StringBuffer returnValue=new StringBuffer();
		HttpURLConnection urlCon = null;
		byte[] xmlData = xml.getBytes();
		try {
			//格式化url
			URL url = new URL(strURL);
			//打开连接
			urlCon = (HttpURLConnection)url.openConnection();
			//设置输入输出流可以输入
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setRequestMethod("POST");
			urlCon.setReadTimeout(30000);

			//urlCon.setRequestProperty("Content-type", "text/html");
			//urlCon.setRequestProperty("Content-type", "multipart/form-data");
			urlCon.setRequestProperty("Content-type", "text/html");
			urlCon.setRequestProperty("Charset", "utf-8");
			urlCon.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			urlCon.setRequestProperty("Accept-Charset", "utf-8");
			urlCon.setRequestProperty("contentType", "utf-8");
			OutputStream printout = urlCon.getOutputStream();
			//把xml写入输出流
			printout.write(xmlData);
			//刷新缓存
			printout.flush();
			//关闭输出流
			printout.close();
			InputStream in = new BufferedInputStream(urlCon.getInputStream());
			InputStreamReader reader = new InputStreamReader(in,"utf-8");
			char[] buff = new char[1024];
			int length = 0;
			while ((length = reader.read(buff)) != -1) {
				returnValue.append(new String(buff, 0, length));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (urlCon != null) {
				urlCon.disconnect();
			}
		}
		return returnValue.toString();
	}

	public static String getInputStream(HttpServletRequest request){
		//获取HTTP请求的输入流
		//已HTTP请求输入流建立一个BufferedReader对象
		StringBuffer returnXml = new StringBuffer();
		BufferedReader reader =null;
		try {
			request.setCharacterEncoding("GBK");
			reader = request.getReader();

			char[] buff = new char[1024];

			int length = 0;
			while ((length = reader.read(buff)) != -1) {
				returnXml.append(new String(buff, 0, length));
			}
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(returnXml.toString().trim());
		return returnXml.toString().trim();
	}
}
