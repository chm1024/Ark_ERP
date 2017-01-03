package com.micolor.entity.userinterface;

/**接口执行返回信息类
 * Created by Administrator on 2016/11/25.
 */
public class InterfaceMsg {
    /**
     * 状态 success/fail
     */
    private String status="success";
    /**
     * 0001-接口通信错/0002-业务系统错误
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
