<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>用户管理</title>
</head>
<body>
	<div class="container-fluid">
		<form class="row form-horizontal margin" id="userUpdateForm">
			<input type="hidden" name="id" value="${user.id}">
			<input type="hidden" name="password" value="${user.password}">
			<input type="hidden" name="status" value="${user.status}">
			<div class="form-group">
				<label class="col-xs-3  control-label text-center">
					用户名：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="用户名" name="loginname" value="${user.loginname}">
				</div>
			</div>
		</form>
		<button class="btn btn-success col-xs-offset-4" onclick="userUpdateForm.submitForm()">提交</button>
		<button class="btn btn-default" onclick="callback()">取消</button>
	</div>
	<script type="text/javascript">
		$(function() {
			userUpdateForm.init();
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
		var userUpdateForm = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			submitForm : function() {
				$("#userUpdateForm").submit();
				return false;
			},
			dataGrid : {
				init : function() {
					var option = {
						target : '#output2', // target element(s) to be updated with server response 
						success : callback,
						url : "/user/update",
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
					$("#userUpdateForm").validate({
						submitHandler : function(form) { //验证成功后执行的
							var t = this;
							$(form).ajaxSubmit(option);
						},
						rules : {
							loginname : {
								required : true,
								remote : "/user/check/loginname"
							}
						},
						messages : {
							loginname : {
								required : "用户名不能为空",
								remote : "该用户名已经存在,请重新选择一个"
							}
						}
					});
				}
			}
		};
	</script>
</body>
</html>