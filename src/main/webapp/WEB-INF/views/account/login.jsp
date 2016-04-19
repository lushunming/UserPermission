<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
</head>
<body>
	<div class="container">
		<form class="row col-md-4 col-md-offset-4" id="loginform" >
			<h2 class="">请登录</h2>
			<label for="loginName" class="sr-only">登录名</label> <input type="text" name="loginName" class="form-control" placeholder="请输入登录名" required autofocus> <label for="password" class="sr-only">密码</label> <input type="password" name="password" class="form-control" placeholder="请输入密码" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
	<!-- /container -->
	<script type="text/javascript">
		$(function() {
			loginform.init();

		});
		function callback(result) {
			if (result.success) {
				window.location="/main/main.html";
			} else {
				$.messager.show({
					title : '提交信息',
					msg : result.msg,
					timeout : 5000,
					showType : 'slide'
				});
			}
		};
		var loginform = {

			init : function() {
				var option = {
					target : '#output2', // target element(s) to be updated with server response 
					success : callback,
					url:"/account/login",
					type:"post",
					dataType:"json"
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
				$("#loginform").validate({
					submitHandler : function(form) { //验证成功后执行的
						var t = this;
						$(form).ajaxSubmit(option);
					},
					rules : {
						loginName : "required",
						password : "required"
					},
					messages : {
						loginName : "登录名不能为空",
						password : "密码不能为空"
					}
				});
			}

		};
	</script>
</body>
</html>