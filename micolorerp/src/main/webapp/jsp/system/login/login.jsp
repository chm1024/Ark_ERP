<%--
  Created by IntelliJ IDEA.
  User: geyupeng
  Date: 16/2/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>用户登录</title>
    <jsp:include page="/resources/include/include.jsp"/>
    <script>
        $(function () {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });
    </script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>MiColor</b>ERP</a>
    </div><!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">登录体验系统</p>
        <form action="login.action" method="post">
            <div class="form-group has-feedback">
                <input name="account" type="text" class="form-control" placeholder="邮件地址">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="password" type="password" class="form-control" placeholder="用户密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox" name="rememberMe" value=true>&nbsp;&nbsp;记住我
                        </label>
                    </div>
                </div><!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div><!-- /.col -->
            </div>
        </form>

        <a href="#">忘记密码</a>&nbsp;
        <a href="register.html" class="text-center">注册会员</a>

    </div><!-- /.login-box-body -->
</div><!-- /.login-box -->
</body>
</html>
