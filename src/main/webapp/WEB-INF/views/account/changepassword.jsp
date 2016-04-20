<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
</head>
<body>
	<div class="container">
		<form class="row col-md-4 col-md-offset-4" id="changePasswordForm">
			<div class="form-group">
				<label for="password">新密码</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
			</div>
			<div class="form-group">
				<label for="password">确认密码</label>
				<input type="password" name="confirm_password" class="form-control" placeholder="请重新输入密码">
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">确认</button>
		</form>
	</div>
	<!-- /container -->
	<script type="text/javascript">
		$(function() {
			changePasswordForm.init();
		});
		function callback(result) {
			if (result.success) {
				//	window.location = "/main/main.html";
			
				Util.showMessage(result.msg);
				setTimeout("window.close()", 3000);
			} else {
				Util.showMessage(result.msg);
			}
		};
		var changePasswordForm = {
			init : function() {
				var option = {
					target : '#output2', // target element(s) to be updated with server response 
					success : callback,
					url : "/account/password/change",
					type : "post",
					dataType : "json"
				};
				$("#changePasswordForm").validate({
					submitHandler : function(form) { //验证成功后执行的
						var t = this;
						$(form).ajaxSubmit(option);
					},
					rules : {
						password : {
							required : true,
							minlength : 6
						},
						confirm_password : {
							required : true,
							minlength : 6,
							equalTo : "#password"
						}
					},
					messages : {
						password : {
							required : "请输入密码",
							minlength : "密码长度不能小于6 个字母"
						},
						confirm_password : {
							required : "请输入密码",
							minlength : "密码长度不能小于 6 个字母",
							equalTo : "两次密码输入不一致"
						}
					}
				});
			}
		};
	</script>
</body>
</html>