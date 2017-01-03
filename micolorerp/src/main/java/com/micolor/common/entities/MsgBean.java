/*
 * Copyright (c) 2015. MiColor
 */

/**
 * @Title: MsgBean.java
 * @Package initerp.entity
 * @author 钰鹏
 * @date 2014年4月2日 下午5:16:35
 * @version V1.0
 */
package com.micolor.common.entities;
import com.micolor.common.method.messageutil.MsgBeanTrans;
import com.micolor.common.statics.EnumUtil;

/**
 * @author 钰鹏
 * @ClassName: MsgBean
 * @Description: 实现层执行增删改时返回的参数
 * @date 2014年4月2日 下午5:16:35
 */
public class MsgBean {
    private String msg; // 执行消息 （1为成功，其他为不成功以及原因）
    private Object content; // 执行主键编号
    private EnumUtil.MessageStatus status; //执行状态1为成功，其他为不成功


    /**
     * <p>Title: </p>
     * <p>Description: </p>
     */
    public MsgBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     *
     * @param msg
     * @param content
     * @param status
     */
    public MsgBean(String msg, String content, EnumUtil.MessageStatus status) {
        super();
        this.msg = msg;
        this.content = content;
        this.status = status;
    }

    /**
     * 获得
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     *
     * @param msg 要设置的 msg
     */
    public void setMsg(String msg) {
        this.msg = MsgBeanTrans.transMsg(msg);
    }


    public EnumUtil.MessageStatus getStatus() {
        return status;
    }

    public void setStatus(EnumUtil.MessageStatus status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
