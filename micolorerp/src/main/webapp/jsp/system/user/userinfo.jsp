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
        <h3 class="box-title">用户信息表单</h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form id="defaultForm" class="form-horizontal"  method="post">
        <div class="box-body">
            <div class="form-group">
                <label for="id" class="col-sm-2 control-label">用户代码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="id" name="userEntity.id" readonly
                           value="<s:property value="#request.userEntity.id"/>">
                </div>

            </div>
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">用户名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="userName" name="userEntity.userName"
                           value="<s:property value="#request.userEntity.userName"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="roleName" class="col-sm-2 control-label">用户角色</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="roleName" name="userEntity.roleName"
                           value="<s:property value="#request.userEntity.roleName"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">用户邮箱</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="userEntity.email"
                           value="<s:property value="#request.userEntity.email"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">联系方式</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="userEntity.phone"
                           value="<s:property value="#request.userEntity.phone"/>">
                </div>
            </div>

            <div class="form-group">
                <label for="nickName" class="col-sm-2 control-label">用户昵称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nickName" name="userEntity.nickName"
                           value="<s:property value="#request.userEntity.nickName"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="status" class="col-sm-2 control-label">状态</label>

                <div class="col-sm-10">
                    <select class="form-control select2" id="status" name="userEntity.status" >
                        <option value="">请选择</option>
                        <option value="enabled">正常</option>
                        <option value="disabled">禁用</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="createTime" class="col-sm-2 control-label">添加时间</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="createTime" name="userEntity.createTime" readonly
                           value="<s:property value="#request.userEntity.createTime"/>">
                </div>
            </div>
        </div><!-- /.box-body -->
        <div class="box-footer">
            <button type="button" name="btngoback" id="btngoback" class="btn btn-default">取消并返回列表</button>
            <button type="button" name="btnsubmit" id="btnsubmit" class="btn btn-info pull-right">保存</button>
        </div><!-- /.box-footer -->
    </form>
</div>
<script>
    $(function () {
        //
        $('#status').val('<s:property value="#request.userEntity.status"/>');
        $('#defaultForm').bootstrapValidator({
            country: 'zh_CN',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            submitButtons: 'button[id="btnsubmit"]',
            fields: {
                "userEntity.userName": {
                    validators: {
                        notEmpty: {}
                    }
                },
                "userEntity.status": {
                    validators: {
                        notEmpty: {}
                    }
                }
            }
        });

        $('#btnsubmit').click(function () {
            if ($('#defaultForm').data('bootstrapValidator').isValid()) {
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: "useredit.action",
                    data: $('#defaultForm').serialize(),
                    async: false,
                    error: function (request) {
                        $().toastmessage('showErrorToast', "系统异常!");
                    },
                    success: function (data) {
                        if (data['msgBean']['status'] == "OK") {
                            $().toastmessage('showSuccessToast', data['msgBean']['msg']);
                            $("#id").val(data['msgBean']['content']['id']);
                            $("#createTime").val(data['msgBean']['content']['createTime']);

                            //$("#defaultForm").data('bootstrapValidator').resetForm();
                        } else {
                            $().toastmessage('showErrorToast', data['msgBean']['msg']);
                        }
                    }
                });
            }else{
                $('#defaultForm').data('bootstrapValidator').validate();
            }
        });

        $('#btngoback').click(function () {
            tab.jumpOnCurrTab("./jsp/system/user/userlistpage.action");
        });
    });
</script>
</body>
</html>