<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>任务管理</title>
</head>
<body>
	<div class="container-fluid">
		<form class="row form-horizontal margin" id="taskUpdateForm">
			<input type="hidden" name="id" value="${task.id}">
			<div class="form-group">
				<label class="col-xs-2  control-label">名称：<span class="col-danger">*</span></label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="名称" name="name" value="${task.name}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2  control-label">URL：<span class="col-danger ">*</span></label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="URL" name="url" value="${task.url}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2  control-label">描述：<span class="col-danger ">*</span></label>
				<div class="col-xs-8">
					<textarea class="form-control" rows="3" placeholder="描述" name="description">${task.description}</textarea>
				</div>
			</div>
		</form>
		<button class="btn btn-success col-xs-offset-4" onclick="taskUpdateForm.submitForm()">提交</button>
		<button class="btn btn-default" onclick="callback()">取消</button>
	</div>
	<script type="text/javascript">
		$(function() {
			taskUpdateForm.init();
		});
		function callback() {
			parent.callback();
		};
		var taskUpdateForm = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			submitForm : function() {
				$("#taskUpdateForm").submit();
				return false;
			},
			dataGrid : {
				init : function() {
					var option = {
						target : '#output2', // target element(s) to be updated with server response 
						success : callback,
						url : "/task/update",
						type : "post",
						dataType : "json"
					// post-submit callback 
					// other available options: 
					//url:       url         // override for form's 'action' attribute 
					//type:      type        // 'get' or 'post', override for form's 'method' attribute 
					//dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
					//clearForm: true        // clear all form fields after successful submit 
					//resetForm: true        // reset the form after successful submit 

					// $.ajax options can be used here too, for example: 
					//timeout:   3000 
					};
					$("#taskUpdateForm").validate({
						submitHandler : function(form) { //验证成功后执行的
							var t = this;
							$(form).ajaxSubmit(option);
						},
						rules : {
							name : "required",
							url : "required"
						},
						messages : {
							name : "任务名不能为空",
							url : "任务的URL不能为空"
						}
					});
				}
			}
		};
	</script>
</body>
</html>