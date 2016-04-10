<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>

<title>任务管理</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false" style="width: 100%; height: 100%;">
	<div data-options="region:'center',fit:true" style="overflow: hidden;">
		<table id="table" data-options="fit:true,border:false"></table>
	</div>

	<div id="toolBar">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="taskList.operation('Add')">增加</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="taskList.operation('Delete')">删除</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="taskList.operation('Update')">更新</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="taskList.operation('View')">查看</a>
	</div>
	<div id="myWindow"></div>
	<script type="text/javascript">
		$(function() {
			taskList.init();
		});
		//新增后的回调
		function callback() {
			taskList.dataGrid.instance.reload();
			$("#myWindow").window("close");
		};
		var taskList = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			operation : function(mode) {
				var row = $('#table').datagrid('getSelected');
				if (mode == "Add") { //添加
					Util.openWin("新增任务", '/task/add.html');
				} else { //增删改
					if (row) {
						if (mode == "Delete") {
							var url = "/task/delete/" + row.id;
							Util.callAjax(url, {}, function(data) {
								taskList.dataGrid.instance.reload();
								Util.showMessage(data.msg);
							});
						} else if (mode == "Update") {
							Util.openWin("更新任务", '/task/update/' + row.id + '.html');
						} else if (mode == "View") {
							Util.openWin("查看任务", "/task/view/" + row.id + ".html");
						}
					} else {
						Util.showMessage("请选选择要操作的行！");
					}
				}

			},
			dataGrid : {
				instance : '',
				init : function() { //初始化datagrid
					var t = this;
					var operationFormatter = function() {
						var html = '';
						html += '<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="taskList.operation(\'Update\')">修改</a>'
						html += '&nbsp;<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>'
						return html;
					};

					var option = {
						id : "#table",
						url : '/task/querylist',
						height : $("#body").height(),
						columns : [ [ {
							field : 'ck',
							title : 'ck',
							checkbox : true,
							width : 100
						}, {
							field : 'name',
							title : 'name',
							width : 100
						}, {
							field : 'url',
							title : 'url',
							width : 100
						}, {
							field : 'description',
							title : '描述',
							width : 100
						} ] ],
						toolbar : "#toolBar",//工具栏
						queryParams : {},
					};
					t.instance = new DataGrid(option);
				}
			},

		};
	</script>
</body>
</html>