<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>

<title>任务管理</title>
</head>
<body>
	<div class="container-fluid">
		<form class="form-horizontal margin">
			<div class="form-group">
				 <label class="col-xs-2  control-label">名称：<span class="col-danger">*</span></label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="名称" name="name">
				</div>
			</div>
			<div class="form-group">
				 <label class="col-xs-2  control-label">URL：<span class="col-danger ">*</span></label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="URL" name="url">
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			taskList.init();
		});
		var taskAddForm = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			dataGrid : {
				init : function() { //初始化datagrid
					var operationFormatter = function() {
						var html = '';
						html += '<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>'
						html += '&nbsp;<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>'
						return html;
					};
					var operation = function(mode) {
						if (mode == "Add") {
							layer.open({
								type : 2,
								area : [ '700px', '530px' ],
								fix : false, //不固定
								maxmin : true,
								content : 'task/add.html'
							});
						} else if (mode == "Delete") {

						} else if (mode = "Update") {

						} else if (mode == "View") {

						}

					}
					var option = {
						id : "#table",
						url : '/task/querylist',
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