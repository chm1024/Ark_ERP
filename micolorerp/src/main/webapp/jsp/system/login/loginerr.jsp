<%--
  Created by IntelliJ IDEA.
  User: geyupeng
  Date: 16/2/26
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>用户登录错误</title>
    <jsp:include page="/resources/include/include.jsp"/>
    <script src="<%=basePath%>/resources/micolor/system/login.js"></script>
</head>
<body>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>MiColor</b>ERP</a>
    </div><!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg"><span class="label label-danger">登录失败</span></p>
        <p class="login-box-msg text-center text-danger"><s:property value="errorMsg"/></p>
        <button type="button" class="btn btn-primary btn-block" onclick="micolor.login.goLoginPage()">返回登录</button>
    </div><!-- /.login-box-body -->
</div><!-- /.login-box -->
</body>
</body>
</html>
