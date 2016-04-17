<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>

<title>分配任务</title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false" style="width: 100%; height: 100%;">
	<div data-options="region:'center',fit:true">
		<table id="table" data-options="fit:true,border:false"></table>
	</div>
	<div data-options="region:'south',border:false" style="overflow: hidden;">
		<a class="btn btn-success col-xs-offset-4" onclick="roleTaskList.submitForm()">提交</a>
		<a class="btn btn-default" onclick="callback()">取消</a>
	</div>

	<script type="text/javascript">
		var roleId = '${roleId}';
		$(function() {
			roleTaskList.init();
		});
		function callback(responseText, statusText, xhr, $form) {
			if (responseText) {
				if (responseText.success) {
					parent.callback(responseText.msg);
				} else {
					Util.showMessage(responseText.msg);
				}
			} else {
				parent.callback();
			}
		};
		var roleTaskList = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			submitForm : function() {
				var rows = roleTaskList.dataGrid.instance.getChecked();
				var ids = [];
				var url = "/role/granttask/" + roleId;
				$.each(rows, function(index, row) {
					ids.push(row.id);
				});
				Util.callAjax(url, {
					taskIds : ids
				}, callback);
			},
			dataGrid : {
				t : this,
				instance : '',

				init : function() { //初始化datagrid
					var t = this;
					t.loadSuccess = function(data) {
						var url = "/role/taskList/" + roleId;
						Util.callAjax(url, {}, function(rows) {
							console.log(rows);
							$.each(data.rows, function(index, ele) {
								$.each(rows, function(index1, row) {

									if (ele.id == row.taskId) {
										roleTaskList.dataGrid.instance.selectRow(index);
									}
								});
							});
						});
					};
					var option = {
						id : "#table",
						url : '/task/queryalllist',
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
						queryParams : {},
						singleSelect : false,
						pagination : false,
						onLoadSuccess : t.loadSuccess
					};
					t.instance = new DataGrid(option);
				}
			},

		};
	</script>
</body>
</html>