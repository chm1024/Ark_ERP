<%--
  Created by IntelliJ IDEA.
  User: Evangoe
  Date: 06/04/16
  Time: 下午3:44
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
        <h3 class="box-title"><i class="fa fa-columns"></i> 翻译文件下载</h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form id="defaultForm" class="form-horizontal" action="transvaluedownloadfile.action" method="post">
        <div class="box-body">
            <div class="form-group">
                <label for="fileName" class="col-sm-2 control-label">文件名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="fileName" name="fileName" readonly
                           value="<s:property value="#request.filepath"/>">
                </div>
            </div>
        </div><!-- /.box-body -->
        <div class="box-footer">
            <button type="button" name="btngoback" id="btngoback" class="btn btn-default"><i class="fa fa-undo"></i> 取消并返回列表</button>
            <button type="submit" name="btnsubmit" id="btnsubmit" class="btn btn-info pull-right"><i class="fa fa-cloud-download"></i> 下载</button>
        </div><!-- /.box-footer -->
    </form>
</div>
<script>
    $(function () {
        $('#btngoback').click(function () {
            tab.jumpOnCurrTab("./jsp/transvalue/transvaluelistpage.action");
        });
    });
</script>
</body>
</html>
