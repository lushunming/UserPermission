<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>

<title>用户管理</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false" style="width: 100%; height: 100%;">
	<div data-options="region:'center',fit:true" style="overflow: hidden;">
		<table id="table" data-options="fit:true,border:false"></table>
	</div>

	<div id="toolBar">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="userList.operation('Add')">增加</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="userList.operation('Delete')">删除</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="userList.operation('Update')">更新</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="userList.operation('View')">查看</a>
	</div>
	<div id="myWindow"></div>
	<script type="text/javascript">
		$(function() {
			userList.init();
		});
		//新增后的回调
		function callback(msg) {
			userList.dataGrid.instance.reload();
			$("#myWindow").window("close");
			if (msg) {
				Util.showMessage(msg);
			}
		};
		var userList = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			operation : function(mode) {
				var row = $('#table').datagrid('getSelected');
				if (mode == "Add") { //添加
					Util.openWin("新增用户", '/user/add.html');
				} else { //增删改
					if (row) {
						if (mode == "Delete") {
							var url = "/user/delete/" + row.id;
							Util.callAjax(url, {}, function(data) {
								userList.dataGrid.instance.reload();
								Util.showMessage(data.msg);
							});
						} else if (mode == "Update") {
							Util.openWin("更新用户", '/user/update/' + row.id + '.html');
						} else if (mode == "View") {
							Util.openWin("查看用户", "/user/view/" + row.id + ".html");
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
						html += '<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="userList.operation(\'Update\')">修改</a>'
						html += '&nbsp;<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>'
						return html;
					};
					var statusFormatter = function(value, row, index) {
						var textdis = '';
						if (value == Constants.STATUS_UNCHECK) {
							textdis = "未审核";
						} else if (value == Constants.STATUS_CHECKED) {
							textdis = "审核通过";
						} else if (value == Constants.STATUS_CHECK_NOPASS) {
							textdis = "审核不通过";
						}
						return textdis;
					};
					var option = {
						t : this,
						id : "#table",
						url : '/user/querylist',
						height : $("#body").height(),

						columns : [ [ {
							field : 'ck',
							title : 'ck',
							checkbox : true,
							width : 100
						}, {
							field : 'loginname',
							title : '用户名',
							width : 100
						}, {
							field : 'status',
							title : '用户状态',
							width : 100,
							formatter : statusFormatter
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