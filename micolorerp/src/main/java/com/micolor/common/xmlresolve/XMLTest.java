package com.micolor.common.xmlresolve;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
public class XMLTest {
    public static void main(String[] args){
        StringBuffer sb=new StringBuffer();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://192.168.18.65:10099/webws/GenXmlServlet");
        try{
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("reqData", ""));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
            httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
            httpPost.setEntity(entity);
            HttpEntity httpEntity = httpclient.execute(httpPost).getEntity();

            InputStreamReader reader = new InputStreamReader(httpEntity.getContent(), "utf-8");
            char[] buff = new char[1024];
            int length = 0;
            while ((length = reader.read(buff)) != -1) {
                sb.append(new String(buff,0,length));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

}
