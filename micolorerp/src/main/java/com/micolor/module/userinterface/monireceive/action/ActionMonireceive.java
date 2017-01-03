package com.micolor.module.userinterface.monireceive.action;

import com.micolor.common.action.BaseActionSupport;
import com.micolor.common.util.SendXML;
import com.micolor.common.xmlresolve.ResolveObjectToXML;
import com.micolor.entity.userinterface.InterfaceMsg;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by Fangjw on 12/11/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/userinterface/monireceive")
public class ActionMonireceive extends BaseActionSupport {
    @Resource
    private ResolveObjectToXML resolve;

    private String reqData;

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    @Action(
            value = "index"
    )
    public String execute() {
        try {
            super.getRequest().setCharacterEncoding("gbk");
            System.out.println("1111");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        reqData = SendXML.getInputStream(super.getRequest());
        System.out.println(reqData);

        boolean validate=true;
        //将xml解析成实体类
        InterfaceMsg msgBean=new InterfaceMsg();
        //判断如果xml解析为空
        if(reqData == null || reqData.length()==0){
            validate=false;
            msgBean.setStatus("fail");
            msgBean.setErrorMsg("xml有误，解析失败");
            msgBean.setErrorCode("0002");
        }
        SendXML.printReturnXml(msgBean);
        return null;
    }
}
