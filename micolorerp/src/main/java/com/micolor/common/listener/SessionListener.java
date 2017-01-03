package com.micolor.common.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by geyupeng on 15/10/2.
 * 用于监听用户登录的Session，同时支持用户单一登录。
 */
public class SessionListener implements HttpSessionListener {

    private static HashMap hashUserName = new HashMap();//保存sessionID和username的映射

    /**
     * 以下是实现HttpSessionListener中的方法
     **/
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionCreatedsessionCreatedsessionCreated!!  session id " +httpSessionEvent.getSession().getId() );
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessionDestroyedsessionDestroyedsessionDestroyed!!  session id " +httpSessionEvent.getSession().getId() );
    }

    /**
     * isLogining-判断用户是否登录
     *
     * @param sessinUserName String-登录的用户名
     * @return boolean-该用户是否已经登录的标志
     * @throws Exception
     */
    public static boolean isLogining(String sessinUserName) throws Exception {
        return hashUserName.containsValue(sessinUserName);
    }

    /**
     * isOnline 判断用户是否在线
     *
     * @param session HttpSession-登录的用户名称
     * @return boolean-该用户是否在线的标志
     * @throws Exception
     */
    public static boolean isOnline(HttpSession session) throws Exception {
        return hashUserName.containsKey(session.getId());
    }

    /**
     * createUserSession-用于建立用户session
     *
     * @param session
     * @param sessionUserName String-登录的用户名称
     * @throws Exception
     */
    public static void createUserSession(HttpSession session, String sessionUserName)
            throws Exception {
        hashUserName.put(session.getId(), sessionUserName);
    }

    public static void removeUserSession(String sessionUserName)
            throws Exception {
        Iterator iter = hashUserName.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();

            if (val.toString().equals(sessionUserName)) {
                hashUserName.put(key, null);
                iter.remove();
            }

        }
    }

    public static void replaceUserSession(HttpSession session, String sessionUserName)
            throws Exception {
        if (hashUserName.containsValue(sessionUserName)) {
            //如果该用户已经登录过，则使上次登录的用户掉线(依据使用户名是否在hashUserName中)
            Iterator iter = hashUserName.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                if (((String) val).equals(sessionUserName)) {
                    hashUserName.put(key, null);
                    iter.remove();
                }
            }
            //添加现在的sessionID和username
            hashUserName.put(session.getId(),sessionUserName);
        } else {
            //如果该用户没登录过，直接添加现在的sessionID和username
            hashUserName.put(session.getId(), sessionUserName);
        }
    }
}
