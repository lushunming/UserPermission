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
		<form class="row form-horizontal margin" id="userAddForm">
			<div class="form-group">
				<label class="col-xs-3  control-label text-center">
					用户名：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="用户名" name="loginname">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3  control-label text-center">
					密码：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="密码" name="password" value="111111" readonly="readonly">
				</div>
			</div>

		</form>
		<a class="btn btn-success col-xs-offset-4" onclick="userAddForm.submitForm()">提交</a>
		<a class="btn btn-default" onclick="callback()">取消</a>
	</div>
	<script type="text/javascript">
		$(function() {
			userAddForm.init();
		});
		function callback(responseText, statusText, xhr, $form) {
			if (responseText) {
				if (responseText.success) {
					parent.callback(responseText.msg);
				} else {
					Util.showMessage(responseText.msg);
				}
			}else{
				parent.callback();
			}
		};
		var userAddForm = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			submitForm : function() {
				$("#userAddForm").submit();
				return false;
			},
			dataGrid : {
				init : function() {
					var option = {
						target : '#output2', // target element(s) to be updated with server response 
						success : callback,
						url : "/user/save",
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
					$("#userAddForm").validate({
						submitHandler : function(form) { //验证成功后执行的
							var t = this;
							$(form).ajaxSubmit(option);
							return false;
						},
						rules : {
							name : "required",
							level : {
								required : true,
								digits : true,//整数
								maxlength : 5
							}
						},
						messages : {
							name : "用户名不能为空",
							level : "请输入一个整数"
						}
					});
				}
			}
		};
	</script>
</body>
</html>