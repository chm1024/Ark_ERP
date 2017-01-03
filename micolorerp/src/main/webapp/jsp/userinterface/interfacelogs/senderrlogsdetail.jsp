<%--
  Created by IntelliJ IDEA.
  User: GEYUPENG
  Date: 2016/4/18
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Micolor ERP 2</title>
    <jsp:include page="/resources/include/include.jsp"/>
    <jsp:include page="/resources/include/include_form.jsp"/>
</head>
<body>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">发送错误信息详情</h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form id="defaultForm" class="form-horizontal"  method="post">
        <div class="box-body">
            <div class="form-group">
                <label for="interfaceCode" class="col-sm-2 control-label">接口编码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="interfaceCode" readonly
                           value="<s:property value="#request.interfaceLogsErr.interfaceCode"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="interfaceName" class="col-sm-2 control-label">接口名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="interfaceName" value="<s:property value="#request.interfaceLogsErr.interfaceName"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="primaryColumn" class="col-sm-2 control-label">主键字段</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="primaryColumn"
                           value="<s:property value="#request.interfaceLogsErr.primaryColumn"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="primaryKey" class="col-sm-2 control-label">主键值</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="primaryKey" name="interfaceLogsErr.primaryKey"
                           value="<s:property value="#request.interfaceLogsErr.primaryKey"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="errCode" class="col-sm-2 control-label">错误编码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="errCode" name="interfaceLogsErr.errCode"
                           value="<s:property value="#request.interfaceLogsErr.errCode"/>">
                </div>
            </div>

            <div class="form-group">
                <label for="errMsg" class="col-sm-2 control-label">错误信息</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="errMsg" name="interfaceLogsErr.errMsg">
                        <s:property value="#request.interfaceLogsErr.errMsg"/>
                    </textarea>
                    <%--<input type="text" class="form-control" id="errMsg" name="interfaceLogsErr.errMsg"
                           value="<s:property value="#request.interfaceLogsErr.errMsg"/>">--%>
                </div>
            </div>
        </div><!-- /.box-body -->
        <div class="box-footer">
            <button type="button" name="btngoback" id="btngoback" class="btn btn-default">返回列表</button>
        </div><!-- /.box-footer -->
    </form>
</div>
<script>
    $(function () {
        $('#btngoback').click(function () {
            history.back();
        });
    });
</script>
</body>
</html>