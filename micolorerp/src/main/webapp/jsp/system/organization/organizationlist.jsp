<%--
  Created by IntelliJ IDEA.
  User: GEYUPENG
  Date: 2016/4/19
  Time: 17:34
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
    <jsp:include page="/resources/include/include_datatables.jsp"/>


    <script src="<%=basePath%>/resources/micolor/common/defaultDataTable.js"></script>
    <script src="<%=basePath%>/resources/micolor/system/organizationlist.js"></script>
</head>
<body>
<div class="box  box-info">
    <div class="box-header">
        <h3 class="box-title"><i class="fa fa-table"></i> 企业机构信息维护</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <div class="table-responsive">
            <table id="tablelist" class="table table-bordered table-striped table-hover cell-border">
                <thead>
                <tr>
                    <th>选择</th>
                    <th>机构代码</th>
                    <th>机构编号</th>
                    <th>机构名称</th>
                    <th>机构地址</th>
                    <th>机构电话</th>
                    <th>机构传真</th>
                    <th>机构邮箱</th>
                    <th>机构描述</th>
                    <th>优先级</th>
                    <th>父机构</th>

                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>选择</th>
                    <th>机构代码</th>
                    <th>机构编号</th>
                    <th>机构名称</th>
                    <th>机构地址</th>
                    <th>机构电话</th>
                    <th>机构传真</th>
                    <th>机构邮箱</th>
                    <th>机构描述</th>
                    <th>优先级</th>
                    <th>父机构</th>

                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
</body>
<jsp:include page="/resources/include/include_modal.jsp"/>
<div id="customsearch" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="onecheckModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="customsearchModalLabel2">自定义查询</h4>
            </div>
            <div class="modal-body">
                comming soon...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="customsearchok" data-dismiss="modal">查询</button>
            </div>
        </div>
    </div>
</div>

</body>

</html>