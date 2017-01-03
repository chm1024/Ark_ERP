package com.micolor.common.interceptors;


import com.micolor.module.system.login.action.ActionLogin;
import com.micolor.module.system.login.action.ActionPrepareLogin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * Session拦截器，判断用户是否登录或是否会话过期。 对于普通action的会话拦截
 *
 * @author 钰鹏
 * @date Oct 23, 2013
 */
@Component(value = "sessioninterceptoraction")
public class SessionInterceptorAction extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        System.out.println("##########[启动Session拦截器]######################");
        super.init();
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext
                .getContext().get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) ActionContext
                .getContext().get(ServletActionContext.HTTP_RESPONSE);
        //指定一些action不参与拦截
        if (ai.getAction() instanceof ActionLogin || ai.getAction() instanceof ActionPrepareLogin) {
            return ai.invoke();
        } else {
            if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
                response.setHeader("Access-Control-Allow-Origin", "*");
                //连接类型为Ajax方式的请求
                Subject currentUser = SecurityUtils.getSubject();
                if (currentUser==null) {
                    PrintWriter out = response.getWriter();
                    JSONObject result = new JSONObject();
                    result.put("invalidSession", true);
                    result.put("success", true);
                    out.print(result);
                    out.flush();
                    return null;
                } else {
                    return ai.invoke();
                }
            } else {
                response.setHeader("Access-Control-Allow-Origin", "*");
                //拦截普通的action跳转的请求
                Subject currentUser = SecurityUtils.getSubject();
                if (currentUser==null) {
                    return ai.invoke();
                    //return "sesserr";
                } else {
                    return ai.invoke();
                }
            }
        }
    }
}