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
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="taskList.operation('Add')">增加</a>
	</div>
	<div id="myWindow"></div>
	<script type="text/javascript">
		$(function() {
			taskList.init();
		});
		var taskList = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			operation : function(mode) {
				if (mode == "Add") {
					Util.openWin("新增任务", '/task/add.html');
				} else if (mode == "Delete") {

				} else if (mode = "Update") {

				} else if (mode == "View") {

				}

			},
			dataGrid : {
				init : function() { //初始化datagrid
					var operationFormatter = function() {
						var html = '';
						html += '<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>'
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
							title : 'Name',
							width : 100
						}, {
							field : 'url',
							title : 'url',
							width : 100
						}, {
							field : 'operation',
							title : 'operation',
							width : 100,
							formatter : operationFormatter
						} ] ],
						toolbar : "#toolBar",//工具栏
						queryParams : {},
					};
					new DataGrid(option);
				}
			},

		};
	</script>
</body>
</html>