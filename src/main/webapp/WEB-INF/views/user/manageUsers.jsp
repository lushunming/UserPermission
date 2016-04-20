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
			operation : function(mode, value) {
				var row = $('#table').datagrid('getSelected');

				if (row) {
					if (mode == "Grant") {
						Util.openWin("分配角色", "/user/grantrole/" + row.id + ".html");
					} else if (mode == "Check") {
						Util.callAjax("/user/checkuser/" + row.id, {
							status : value
						}, function(data) {
							if (data.success) {
								userList.dataGrid.instance.reload();
							}
						});
					}
				} else {
					Util.showMessage("请选选择要操作的行！");
				}
			},
			dataGrid : {
				instance : '',
				init : function() { //初始化datagrid
					var t = this;
					var operationFormatter = function(val, row, index) {
						var html = '';
						html += '<a href="javascript:void(0);" class="easyui-linkbutton"  plain="true" onclick="userList.dataGrid.selectrow(' + index + ');userList.operation(\'Grant\');"><u>分配角色</u></a>'
						if (row.status == Constants.STATUS_UNCHECK) {
							html += '   <a href="javascript:void(0);" class="easyui-linkbutton"  plain="true" onclick="userList.dataGrid.selectrow(' + index + ');userList.operation(\'Check\',' + Constants.STATUS_CHECKED + ');"><u>审核通过</u></a>'
							html += '   <a href="javascript:void(0);" class="easyui-linkbutton"  plain="true" onclick="userList.dataGrid.selectrow(' + index + ');userList.operation(\'Check\',' + Constants.STATUS_CHECK_NOPASS + ');"><u>审核不通过</u></a>'
						} else if (row.status == Constants.STATUS_CHECK_NOPASS) {
							html += '   <a href="javascript:void(0);" class="easyui-linkbutton"  plain="true" onclick="userList.dataGrid.selectrow(' + index + ');userList.operation(\'Check\',' + Constants.STATUS_CHECKED + ');"><u>审核通过</u></a>'
						} else if (row.status == Constants.STATUS_CHECKED) {
							html += '   <a href="javascript:void(0);" class="easyui-linkbutton"  plain="true" onclick="userList.dataGrid.selectrow(' + index + ');userList.operation(\'Check\',' + Constants.STATUS_CHECK_NOPASS + ');"><u>审核不通过</u></a>'
						}

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
					t.selectrow = function(index) {
						userList.dataGrid.instance.selectRow(index);
					};
					var option = {
						t : this,
						id : "#table",
						url : '/user/querylowlist',
						height : $("#body").height(),

						columns : [ [ {
							field : 'ck',
							title : 'ck',
							checkbox : true,
							width : 100,
							align : "center"
						}, {
							field : 'loginname',
							title : '用户名',
							width : 100,
							align : "center"
						}, {
							field : 'status',
							title : '用户状态',
							width : 100,
							align : "center",
							formatter : statusFormatter
						}, {
							field : 'operater',
							title : '操作',
							align : "center",
							width : 100,
							formatter : operationFormatter
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