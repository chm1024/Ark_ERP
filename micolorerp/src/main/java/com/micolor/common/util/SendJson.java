package com.micolor.common.util;

import com.micolor.entity.userinterface.InterfaceMsg;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by liusi on 2016/11/29.
 */
public class SendJson {
    /**
     * 调用接口后返回XML信息
     * @param interfaceMsg 返回正确/错误信息类
     * @return
     */
    public static void printReturnJson(InterfaceMsg interfaceMsg){
        StringBuffer sb=new StringBuffer("");
        sb.append("{\"state\":\"");
        if("success".equals(interfaceMsg.getStatus())){
            sb.append("success");
        }else{
            sb.append("failure");
        }
        sb.append("\"}");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.write(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
