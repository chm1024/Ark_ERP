<%--
  Created by IntelliJ IDEA.
  User: geyupeng
  Date: 16/3/2
  Time: 18:52
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

</head>
<body>
<div class="box  box-info">
    <div class="box-header">
        <h3 class="box-title">字典类型列表</h3>
    </div><!-- /.box-header -->
    <div class="box-body">
        <div class="table-responsive">
            <table id="tablelist" class="table table-bordered table-striped table-hover cell-border">
                <thead>
                <tr>
                    <th>选择</th>
                    <th>类型编号</th>
                    <th>类型名称</th>
                    <th>添加时间</th>
                    <th>字典状态</th>
                    <th>所属机构</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>选择</th>
                    <th>类型编号</th>
                    <th>类型名称</th>
                    <th>添加时间</th>
                    <th>字典状态</th>
                    <th>所属机构</th>
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
<script>
    $(function () {
        var datatables = $('#tablelist').DataTable({
            "language": {
                "url": "<%=basePath%>/resources/micolor/plugins/datatables/zh_CN.txt",
                "select": {
                    rows: {
                        _: "选中 %d 行",
                        0: "点击条目选择一行",
                        1: "只有1行选中"
                    }
                }
            },
            "order": [[1, "desc"]],
            "processing": true,
            "serverSide": true,
            'ajax': {
                "type": "post",//更改Ajax的请求方式
                "url": "dictclasslist.action",
                "data": function (aoData) {
                    var reqData = {};
                    reqData['dtJson'] = JSON.stringify(aoData);
                    return reqData;
                },
                dataSrc: function (json) {
                    json.draw = json.repdata["draw"];
                    json.recordsTotal = json.repdata["recordsTotal"];
                    json.recordsFiltered = json.repdata["recordsFiltered"];
                    return json.repdata["data"];
                }
            },
            "autoFill": true,
            select: true,
            "columns": [
                {"data": null},
                {"data": "dicode"},
                {"data": "diname"},
                {"data": "adtimesp"},
                {"data": "distatus"},
                {"data": "cocode"}
            ],
            columnDefs: [
                {
                    "render": function (data, type, row) {
                        return '';
                    },
                    orderable: false,
                    className: 'select-checkbox',
                    targets: 0
                }, {
                    "render": function (data, type, row) {
                        if (data == '1') {
                            return '正常';
                        } else {
                            return '禁用';
                        }
                    },
                    targets: 4
                }],
            select: {
                style: 'os',
                selector: 'td:first-child'
            },
            //"scrollY": "350px",
            //"scrollCollapse": false,
            "paging": true,
            "lengthChange": true,
            "lengthMenu": [[20, 50, 100, -1], [20, 50, 100, "所有"]],
            "searching": false,
            "ordering": true,
            "autoWidth": true,
            stateSave: true,
            dom: 'Bfptir',
            buttons: [
                'pageLength',
                {
                    text: '查询',
                    action: function (e, dt, node, config) {
                        $('#customsearch').modal('show');
                    }
                },

                {
                    extend: 'selectAll',
                    text: '全选'
                },
                {
                    extend: 'selectNone',
                    text: '全不选'
                },
                {
                    text: '刷新',
                    action: function (e, dt, node, config) {
                        dt.ajax.reload();
                    }
                },
                {
                    extend: 'excel',
                    text: '导出',
                    title: '数据字典'
                },
                {
                    text: '新增',
                    action: function (e, dt, node, config) {
                        tab.jumpOnCurrTab("./jsp/dictclass/dictclassinfo.action");
                    }
                },
                {
                    text: '编辑',
                    action: function (e, dt, node, config) {
                        var count = datatables.rows({selected: true}).count();
                        if (count != 1) {
                            $('#onecheck').modal('show');
                        } else {
                            var rowData = datatables.rows({selected: true}).data().toArray();
                            tab.jumpOnCurrTab("./jsp/dictclass/dictclassinfo.action?dictClassEntity.dicode=" + rowData[0]['dicode']);
                        }
                    }
                },
                {
                    text: '删除',
                    action: function (e, dt, node, config) {
                        var count = datatables.rows({selected: true}).count();
                        if (count != 1) {
                            $('#onecheck').modal('show');
                        } else {
                            $('#deletecheck').modal('show');
                        }

                    }
                },
                {
                    text: '集合',
                    action: function (e, dt, node, config) {
                        var count = datatables.rows({selected: true}).count();
                        if (count != 1) {
                            $('#onecheck').modal('show');
                        } else {
                            var rowData = datatables.rows({selected: true}).data().toArray();
                            tab.jumpOnCurrTab("./jsp/dictclass/dictclassinfo.action?dictClassEntity.dicode=" + rowData[0]['dicode']);
                        }
                    }
                },
            ]
        });

        $('#deleteok').click(function () {
            var rowData = datatables.rows({selected: true}).data().toArray();
            $.ajax({
                "url": "dictclassdelete.action",
                "contentType": "application/x-www-form-urlencoded",
                "async": false,
                "type": "POST",
                "data": {
                    "rowDatas": JSON.stringify(rowData)
                },
                "dataType": "json",
                "success": function (data, callback, settings) {
                    if (data['msgBean']['status'] == "OK") {
                        $().toastmessage('showSuccessToast', "删除成功!");
                    } else {
                        $().toastmessage('showErrorToast', "删除失败!");
                    }
                },
                "error": function (data, callback, settings) {
                    alert("error");
                }
            });
            datatables.ajax.reload();
            $('#deletecheck').modal('toggle');
        });
    });
</script>
</html>
