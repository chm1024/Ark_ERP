<%--
  Created by IntelliJ IDEA.
  User: GEYUPENG
  Date: 2016/10/29
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
  <script src="<%=basePath%>/resources/micolor/system/user.js"></script>
</head>
<body>
<div class="box  box-info">
  <div class="box-header">
    <h3 class="box-title"><i class="fa fa-table"></i> 用户列表</h3>
  </div><!-- /.box-header -->
  <div class="box-body">
    <div class="table-responsive">
      <table id="tablelist" class="table table-bordered table-striped table-hover cell-border">
        <thead>
        <tr>
          <th>选择</th>
          <th>用户代码</th>
          <th>用户名称</th>
          <th>昵称</th>
          <th>角色名称</th>
          <th>创建时间</th>
          <th>真实姓名</th>
          <th>状态</th>
          <th>邮箱</th>
          <th>联系电话</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>选择</th>
          <th>用户代码</th>
          <th>用户名称</th>
          <th>昵称</th>
          <th>角色名称</th>
          <th>创建时间</th>
          <th>真实姓名</th>
          <th>状态</th>
          <th>邮箱</th>
          <th>联系电话</th>
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