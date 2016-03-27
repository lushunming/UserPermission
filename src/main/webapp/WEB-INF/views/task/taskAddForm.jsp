<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>

<title>任务管理</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">账号：</label>
				<div class="col-sm-8 padding-top padding-left-lg" data-bind="text:loginName">admin</div>
			</div>
			<div class="form-group">
				<span class="col-danger font-size-large line-height">*</span> <label class="col-sm-2  control-label">姓名：</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" placeholder="姓名" name="username" data-bind="value:userName,event:{blur:checkUserName}">
				</div>
				<div class="bg-danger" id="username_msg" style="display: none;">必填！</div>
			</div>
			<div class="form-group" id="sex">
				<label class="col-sm-2  control-label">性别：</label>
				<div class="col-sm-8">
					<label class="radio-inline col-sm-2"> <input type="radio" name="sex" value="1" data-bind="checked:sex">男
					</label> <label class="radio-inline col-sm-2"> <input type="radio" name="sex" value="0" data-bind="checked:sex">女
					</label>
				</div>
			</div>
			<div class="form-group">
				<span class="col-danger font-size-large line-height">*</span> <label class="col-sm-2 control-label">邮箱：</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" placeholder="邮箱" name="email" data-bind="value:email,event:{blur:checkEmail}">
				</div>
				<div class="bg-danger" id="email_msg" style="display: none;">必填！</div>
			</div>
			<div class="form-group">
				<span class="col-danger font-size-large line-height">*</span> <label class="col-sm-2 control-label">手机号：</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" placeholder="通过认证的手机号可以直接登录平台" name="mobile" data-bind="value:mobile,event:{blur:checkMobile}">
				</div>
				<div class="bg-danger" id="mobile_msg" style="display: none;">必填！</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">个人签名：</label>
				<div class="col-sm-12 ">
					<textarea rows="6" class="col-sm-10 padding" name="userText" id="userText" data-bind="value:userText,event:{blur:checkUserText}"></textarea>
				</div>
				<div class="bg-danger" id="userText_msg" style="display: none;">必填！</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3">
					<button type="button" class="btn btn-warning" data-bind="click:checkSubmit">确认修改</button>
					<button type="button" class="btn btn-cancle col-sm-offset-3" data-bind="click:cancle">取消</button>
				</div>
			</div>
		</form>

	</div>
	<script type="text/javascript">
		$(function() {
			taskList.init();
		});
		var taskList = {
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