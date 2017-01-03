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
        <h3 class="box-title">字典类别表单</h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form id="defaultForm" class="form-horizontal" action="dictclasslist.jsp" method="post">
        <div class="box-body">
            <div class="form-group">
                <label for="dicode" class="col-sm-2 control-label">字典类别编号</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="dicode" name="dictClassEntity.dicode" readonly
                           value="<s:property value="#request.dictClassEntity.dicode"/>">
                </div>

            </div>
            <div class="form-group">
                <label for="diname" class="col-sm-2 control-label">字典类别名称</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="diname" name="dictClassEntity.diname"
                           value="<s:property value="#request.dictClassEntity.diname"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="diname" class="col-sm-2 control-label">状态</label>

                <div class="col-sm-10">
                    <select class="form-control select2" id="distatus" name="dictClassEntity.distatus" >
                        <option value="">请选择</option>
                        <option value="1">正常</option>
                        <option value="0">禁用</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="diname" class="col-sm-2 control-label">所属机构</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="cocode" name="dictClassEntity.cocode"
                           value="<s:property value="#request.dictClassEntity.cocode"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="adtimesp" class="col-sm-2 control-label">添加时间</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="adtimesp" name="dictClassEntity.adtimesp" readonly
                           value="<s:property value="#request.dictClassEntity.adtimesp"/>">
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
        $('#distatus').val('<s:property value="#request.dictClassEntity.distatus"/>');
        $('#defaultForm').bootstrapValidator({
            country: 'zh_CN',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            submitButtons: 'button[id="btnsubmit"]',
            fields: {
                "dictClassEntity.diname": {
                    validators: {
                        notEmpty: {}
                    }
                },
                "dictClassEntity.distatus": {
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
                    url: "dictclassedit.action",
                    data: $('#defaultForm').serialize(),
                    async: false,
                    error: function (request) {
                        $().toastmessage('showErrorToast', "系统异常!");
                    },
                    success: function (data) {
                        if (data['msgBean']['status'] == "OK") {
                            $().toastmessage('showSuccessToast', data['msgBean']['msg']);
                            $("#dicode").val(data['msgBean']['content']['dicode']);
                            $("#adtimesp").val(data['msgBean']['content']['adtimesp']);

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
            tab.jumpOnCurrTab("./jsp/dictclass/dictclasslistpage.action");
        });
    });
</script>
</body>
</html>
