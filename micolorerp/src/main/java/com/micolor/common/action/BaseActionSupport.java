/**
 * @Title: BaseActionSupport.java
 * @Package common
 * @Description: Action
 * @author 葛钰鹏
 * @date Feb 14, 2014 10:47:16 PM
 * @version V1.0
 */

package com.micolor.common.action;

import com.micolor.common.entities.datatables.Columns;
import com.micolor.common.entities.datatables.DataTables;
import com.micolor.common.entities.datatables.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: BaseActionSupport
 * @Description: 封装一些基本的Action功能.
 * @author: 葛钰鹏
 * @date Feb 14, 2014 10:47:16 PM
 *
 */

public abstract class BaseActionSupport<T> extends ActionSupport {
    private static final long serialVersionUID = -1787627531196824071L;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public ServletContext context;


    public String getCurrDate() {
        String dateStr = "";
        Calendar cal = Calendar.getInstance();// 使用日历类
        int year = cal.get(Calendar.YEAR);// 得到年
        int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
        String monthStr = "";
        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = String.valueOf(month);
        }
        int day = cal.get(Calendar.DAY_OF_MONTH);// 得到天
        dateStr = year + "-" + monthStr + "-" + day;
        return dateStr;
    }

    public String mergeParamsAsURI() {
        Map<String, String[]> params = getRequest().getParameterMap();
        StringBuffer out = new StringBuffer();
        Set<String> keys = params.keySet();// 列出所有表单参数
        for (String key : keys) {
            if (!"page".equals(key)) {
                // TODO 发现Map值有乱码 --> Tomcat
                String[] values = params.get(key);// 尝试获取多个参数
                // 不管单个参数还是多个参数统一转成了数组
                if (values.length > 1) {
                    values = getRequest().getParameterValues(key);
                } else {
                    values = new String[]{getParameter(key)};
                }
                // System.out.println("key=" + key);
                try {
                    for (String value : values) {
                        // System.out.println("value=" + value);
                        out.append(java.net.URLEncoder.encode(key, "UTF-8")
                                + "=");
                        out.append(java.net.URLEncoder.encode(value, "UTF-8")
                                + "&");
                        // key=value&
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        // 删除末尾多余的 & 字符
        if (out.toString().endsWith("&")) {
            out.deleteCharAt(out.length() - 1);
        }
        return out.toString();
    }

    /**
     * 得到Attribute
     *
     * @param name
     *            - 名称(key)
     * @return Object - 对象(value)
     */

    public Object getAttribute(String name) {
        return ServletActionContext.getRequest().getAttribute(name);
    }

    /**
     * 设置Attribute
     *
     * @param name
     *            - 名称(key)
     * @param value
     *            - 对象(value)
     */
    public void setAttribute(String name, Object value) {
        ServletActionContext.getRequest().setAttribute(name, value);
    }

    /**
     * 获取Parameter
     *
     * @param name
     *            - 参数的name
     * @return String - 参数值
     */

    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取Parameter数组
     *
     * @param name
     *            - 参数的name
     * @return String[] - 参数值数组
     */

    public String[] getParameterValues(String name) {
        return getRequest().getParameterValues(name);
    }

    /**
     * 获取Session
     *
     * @param name
     *            - Session的name
     * @return Object - 对象
     */

    public Object getSession(String name) {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        return session.get(name);
    }

    /**
     *
     *
     * @Title: getSessionUser
     *
     * @Description: 获得session中的用户对象信息
     *
     * @param
     * @return 设定文件
     *
     * @return Object 返回类型
     *
     * @throws
     */

    public Map<String, Object> getUser() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) session.get("usermap");
        return map;
    }

    /**
     * 获得当前人员登录时的企业代码
     *
     * @Title: getCocode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return
     */

    public String getCocode() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        HashMap userMap = (HashMap) session.get("usermap");
        return userMap.get("cocode").toString();
    }

    /**
     * 获得当前人员登录时的用户代码
     *
     * @Title: getCocode
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return
     */

    public String getUcode() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        HashMap userMap = (HashMap) session.get("usermap");
        return userMap.get("ucode").toString();
    }

    /**
     * 获取Session
     *
     * @return Map - Map
     */

    public Map<String, Object> getSession() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        return session;
    }

    /**
     * 设置Session
     *
     * @param name
     *            - Session的name
     * @param value
     *            - Session的value
     */
    public void setSession(String name, Object value) {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        session.put(name, value);
    }

    /**
     * 获取Request
     *
     * @return HttpServletRequest - HttpServletRequest
     */

    public HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * 获取Response
     *
     * @return HttpServletResponse - HttpServletResponse
     */

    public HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * 获取Application
     *
     * @return ServletContext - ServletContext
     */

    public ServletContext getApplication() {
        return ServletActionContext.getServletContext();
    }

    public DataTables getDataTables() {
        DataTables dataTables = null;
        HttpServletRequest request = ServletActionContext.getRequest();
        Map map = request.getParameterMap();
        try {
            String json = ((String[]) map.get("dtJson")).length > 0 ? json = ((String[]) map.get("dtJson"))[0] : "";

            JSONObject jsonobj = JSONObject.fromObject(json);
            Map<String, Class> clsMap = new HashMap<String, Class>();
            clsMap.put("columns", Columns.class);
            clsMap.put("order", Order.class);
            dataTables = (DataTables) JSONObject.toBean(jsonobj, DataTables.class, clsMap);

			/*
            String[] dtjson = (String[]) map.get("dtJson");
			if (dtjson != null && dtjson.length > 0) {
				JSONObject jsonObject = JSONObject.fromObject(dtjson[0]);
				dataTables = (DataTables) JSONObject.toBean(jsonObject, DataTables.class);
			}*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTables;
    }
}
