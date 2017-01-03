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
        <h3 class="box-title"><i class="fa fa-columns"></i> 翻译维护表单</h3>
    </div><!-- /.box-header -->
    <!-- form start -->
    <form id="defaultForm" class="form-horizontal" action="dictclasslist.jsp" method="post">
        <div class="box-body">
            <div class="form-group">
                <label for="id" class="col-sm-2 control-label">编号</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="id" name="transValue.id" readonly
                           value="<s:property value="#request.transValue.id"/>">
                </div>

            </div>
            <div class="form-group">
                <label for="tvkey" class="col-sm-2 control-label">KEY</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="tvkey" name="transValue.tvkey"
                           value="<s:property value="#request.transValue.tvkey"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="disc" class="col-sm-2 control-label">中文</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="disc" name="transValue.disc"
                           value="<s:property value="#request.transValue.disc"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="transdisc" class="col-sm-2 control-label">葡文</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="transdisc" name="transValue.transdisc"
                           value="<s:property value="#request.transValue.transdisc"/>">
                </div>
            </div>
        </div><!-- /.box-body -->
        <div class="box-footer">
            <button type="button" name="btngoback" id="btngoback" class="btn btn-default"><i class="fa fa-undo"></i> 取消并返回列表</button>
            <button type="button" name="btnsubmit" id="btnsubmit" class="btn btn-info pull-right"><i class="fa fa-floppy-o"></i> 保存</button>
        </div><!-- /.box-footer -->
    </form>
</div>
<script>
    $(function () {
        //
        $('#distatus').val('<s:property value="#request.transValue.distatus"/>');
        $('#defaultForm').bootstrapValidator({
            country: 'zh_CN',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            submitButtons: 'button[id="btnsubmit"]',
            fields: {
                "transValue.key": {
                    validators: {
                        notEmpty: {}
                    }
                },
                "transValue.disc": {
                    validators: {
                        notEmpty: {}
                    }
                },
                "transValue.transdisc": {
                    validators: {
                        notEmpty: {}
                    }
                }
            }
        });

        $('#btnsubmit').click(function () {
            $('#defaultForm').data('bootstrapValidator').validate();

            if ($('#defaultForm').data('bootstrapValidator').isValid()) {
                $.ajax({
                    cache: true,
                    type: "POST",
                    url: "transvalueedit.action",
                    data: $('#defaultForm').serialize(),
                    async: false,
                    error: function (request) {
                        $().toastmessage('showErrorToast', "系统异常!");
                    },
                    success: function (data) {
                        if (data['msgBean']['status'] == "OK") {
                            $().toastmessage('showSuccessToast', data['msgBean']['msg']);
                            $("#id").val(data['msgBean']['content']['id']);
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
            tab.jumpOnCurrTab("./jsp/demo/transvalue/transvaluelistpage.action");
        });
    });
</script>
</body>
</html>