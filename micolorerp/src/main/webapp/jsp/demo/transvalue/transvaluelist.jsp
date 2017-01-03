<%--
  Created by IntelliJ IDEA.
  User: Evangoe
  Date: 24/06/16
  Time: 下午7:17
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
<div class="box box-default collapsed-box box-solid">
    <div class="box-header with-border">
        <h3 class="box-title"><i class="fa fa-search"></i> 查询</h3>

        <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
            </button>
        </div>
        <!-- /.box-tools -->
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        The body of the box
        <button type="button" class="btn btn-primary" id="btn_getColumn">获得datatable的列</button>
    </div>
    <!-- /.box-body -->
</div>
<div class="box  box-info">
    <div class="box-header">
        <h3 class="box-title"><i class="fa fa-table"></i> 翻译信息维护</h3>
    </div><!-- /.box-header -->

    <!-- /.box -->

    <div class="box-body">
        <div class="table-responsive">
            <table id="tablelist" class="table table-bordered table-striped table-hover cell-border">
                <thead>
                <tr>
                    <th>选择</th>
                    <th>编号</th>
                    <th>KEY</th>
                    <th>中文</th>
                    <th>葡文</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>选择</th>
                    <th>编号</th>
                    <th>KEY</th>
                    <th>中文</th>
                    <th>葡文</th>
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
                "url": "transvaluelist.action",
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
                {"data": null, "width": "5%"},
                {"data": "id", "width": "10%"},
                {"data": "tvkey", "width": "25%"},
                {"data": "disc", "width": "30%"},
                {"data": "transdisc", "width": "30%"}
            ],
            columnDefs: [
                {
                    "render": function (data, type, row) {
                        return '';
                    },
                    orderable: false,
                    className: 'select-checkbox',
                    targets: 0
                }],
            select: {
                style: 'os',
                selector: 'td:first-child'
            },
//            "scrollY": "350px",
//            "scrollCollapse": false,
            "paging": true,
            "lengthChange": true,
            "lengthMenu": [[20, 50, 100, -1], [20, 50, 100, "所有"]],
            "searching": false,
            "ordering": true,
            "autoWidth": false,
            stateSave: true,
            dom: 'Bfptir',
            buttons: [


//                {
//                    text: '<i class="fa fa-search"></i> 查询',
//                    action: function (e, dt, node, config) {
//                        $('#customsearch').modal('show');
//                    }
//                },
                {
                    extend: 'collection',
                    text: '<i class="fa fa-magic"></i> 操作',
                    autoClose: true,
                    buttons: [
                        {
                            text: '<i class="fa fa-files-o"></i>新增',
                            action: function (e, dt, node, config) {
                                tab.jumpOnCurrTab("./jsp/demo/transvalue/transvalueinfo.action");
                            }
                        },
                        {
                            text: '<i class="fa fa-edit"></i>编辑',
                            action: function (e, dt, node, config) {
                                var count = datatables.rows({selected: true}).count();
                                if (count != 1) {
                                    $('#onecheck').modal('show');
                                } else {
                                    var rowData = datatables.rows({selected: true}).data().toArray();
                                    tab.jumpOnCurrTab("./jsp/demo/transvalue/transvalueinfo.action?transValue.id=" + rowData[0]['id']);
                                }
                            }
                        },
                        {
                            text: '<i class="fa fa-recycle"></i>删除',
                            action: function (e, dt, node, config) {
                                var count = datatables.rows({selected: true}).count();
                                if (count != 1) {
                                    $('#onecheck').modal('show');
                                } else {
                                    $('#deletecheck').modal('show');
                                }

                            }
                        }
                    ]
                },
                {
                    extend: 'selectAll',
                    text: '<i class="fa fa-check-square-o"></i> 全选'
                },
                {
                    extend: 'selectNone',
                    text: '<i class="fa fa-square-o"></i> 全不选'
                },
                {
                    text: '<i class="fa fa-refresh"></i> 刷新',
                    action: function (e, dt, node, config) {
                        dt.ajax.reload();
                    }
                },
                {
                    extend: 'collection',
                    text: '<i class="fa fa-external-link"></i> 更多...',
                    autoClose: true,
                    buttons: [
                        {
                            extend: 'excel',
                            text: '<i class="fa fa-file-excel-o" ></i> 导出Excel',
                            title: '数据字典'
                        },
                        {
                            text: '<i class="fa fa-cloud-download"></i> 下载中文',
                            action: function (e, dt, node, config) {
                                tab.jumpOnCurrTab("./jsp/transvalue/transvaluedownload.action?langflag=zn");
                            }
                        },
                        {
                            text: '<i class="fa fa-cloud-download"></i> 下载葡文',
                            action: function (e, dt, node, config) {
                                tab.jumpOnCurrTab("./jsp/transvalue/transvaluedownload.action?langflag=br");
                            }
                        }
                    ]
                },'pageLength'
            ]
        });

        $('#deleteok').click(function () {
            var rowData = datatables.rows({selected: true}).data().toArray();
            $.ajax({
                "url": "transvaluedelete.action",
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

        $("#btn_getColumn").click(function(){
            alert(JSON.stringify(datatables.column().length));
        });

    });
</script>
</html>