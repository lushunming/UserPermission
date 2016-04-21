<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
</head>
<body>
	<div class="container">
		<form class="row col-md-4 col-md-offset-4" id="registerForm">
			<h2 class="">请注册</h2>

			<div class="form-group">
				<label for="loginname">注册名</label>
				<input type="text" name="loginname" class="form-control" placeholder="请输入注册名" autofocus>
			</div>
			<div class="form-group">
				<label for="password">密码</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
			</div>
			<div class="form-group">
				<label for="password">确认密码</label>
				<input type="password" name="confirm_password" class="form-control" placeholder="请重新输入密码">
			</div>
			<div class="form-group">
				<label for="roleIds">选择角色</label>
				<select multiple class="form-control" name="roleIds" id="roles">
					
				</select>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
		</form>
	</div>
	<!-- /container -->
	<script type="text/javascript">
		$(function() {
			registerForm.init();

		});
		function callback(result) {
			if (result.success) {
				Util.showMessage(result.msg);
				setTimeout('window.location = "/account/login.html"', 3000);
			} else {
				Util.showMessage(result.msg)
			}
		};
		var registerForm = {

			init : function() {
				var option = {
					target : '#output2', // target element(s) to be updated with server response 
					success : callback,
					url : "/account/register",
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
				$("#registerForm").validate({
					submitHandler : function(form) { //验证成功后执行的
						var t = this;
						$(form).ajaxSubmit(option);
					},
					rules : {
						loginname : "required",
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
						loginname : "用户名不能为空",
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
				Util.callAjax("/role/queryalllist", {}, function(data) {
					var _roles = $("#roles");
					$.each(data, function(index, role) {
						_roles.append('<option value="'+role.id+'">'+role.name+'</option>');
					});

				});
			}

		};
	</script>
</body>
</html>