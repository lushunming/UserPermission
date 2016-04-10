<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>角色管理</title>
</head>
<body>
	<div class="container-fluid">
		<form class="row form-horizontal margin" id="roleAddForm">
			<div class="form-group">
				<label class="col-xs-2  control-label">
					名称：
					<span class="col-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="名称" name="name">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2  control-label">
					URL：
					<span class="col-danger ">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="URL" name="url">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2  control-label">
					描述：
					<span class="col-danger ">*</span>
				</label>
				<div class="col-xs-8">
					<textarea class="form-control" rows="3" placeholder="描述" name="description"></textarea>
				</div>
			</div>

		</form>
		<a class="btn btn-success col-xs-offset-4" onclick="roleAddForm.submitForm()">提交</a>
		<a class="btn btn-default" onclick="callback()">取消</a>
	</div>
	<script type="text/javascript">
		$(function() {
			roleAddForm.init();
		});
		function callback(responseText, statusText, xhr, $form) {
			if (responseText.success) {
				Util.showMessage(responseText.msg);
				setTimeout('parent.callback()', 5000);
			} else {
				Util.showMessage(responseText.msg);
			}
		};
		var roleAddForm = {
			init : function() {
				var t = this;
				t.dataGrid.init();
			},
			submitForm : function() {
				$("#roleAddForm").submit();
				return false;
			},
			dataGrid : {
				init : function() {
					var option = {
						target : '#output2', // target element(s) to be updated with server response 
						success : callback,
						url : "/role/save",
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
					$("#roleAddForm").validate({
						submitHandler : function(form) { //验证成功后执行的
							var t = this;
							$(form).ajaxSubmit(option);
							return false;
						},
						rules : {
							name : "required",
							url : "required"
						},
						messages : {
							name : "角色名不能为空",
							url : "角色的URL不能为空"
						}
					});
				}
			}
		};
	</script>
</body>
</html>