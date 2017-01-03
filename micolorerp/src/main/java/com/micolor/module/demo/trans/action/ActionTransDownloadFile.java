package com.micolor.module.demo.trans.action;

import com.micolor.common.action.BaseActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by Evangoe on 26/06/16.
 */
@Scope("session")
@ParentPackage("mc_interceptor_action")
@Namespace("/jsp/demo/transvalue")
public class ActionTransDownloadFile extends BaseActionSupport {
    private String fileName;

    /**
     * 获得
     *
     * @return fileName
     */
    public String getFileName() throws UnsupportedEncodingException {
        fileName = new String(fileName.getBytes(), "ISO-8859-1");
        return fileName;
    }

    public void setFileName(String fileName) {
        String fname = ServletActionContext.getRequest().getParameter(
                "fileName");
        try {
			/*
			 * 对fname参数进行UTF-8解码,注意:实际进行UTF-8解码时会使用本地编码，本机为GBK。
			 * 这里使用request.setCharacterEncoding解码无效.
			 * 只有解码了getDownloadFile()方法才能在下载目录下正确找到请求的文件
			 */
            fname = new String(fname.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fileName = fname;
    }

    public InputStream getInputStream() {
        InputStream inputStream = ServletActionContext.getServletContext()
                .getResourceAsStream("/download/" + fileName);
        return inputStream;
    }

    /*
     * (非 Javadoc) <p>Title: execute</p> <p>Description: </p>
     *
     * @return
     *
     * @throws Exception
     *
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    @Override
    @Action(
            value = "transvaluedownloadfile",
            results = {
                    @Result(name = "success", type = "stream", params = {
                            "contentType", "application/octet-stream",
                            "inputName", "inputStream", "contentDisposition",
                            "attachment;filename=\"${fileName}\"", "bufferSize",
                            "4096"})
            }
    )
    public String execute() throws Exception {
        return "success";
    }
}
