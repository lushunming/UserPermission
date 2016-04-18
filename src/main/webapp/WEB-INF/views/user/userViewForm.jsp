<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>用户查看</title>
</head>
<body>
	<div class="container-fluid">
		<form class="row form-horizontal margin" id="userAddForm">
			<div class="form-group">
				<label class="col-xs-3 control-label">
					名称：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="名称" name="name" value="${user.loginname}" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3  control-label">
					用户状态：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="用户状态" id="status" name="status" disabled="disabled">
				</div>
			</div>
		
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			var _status = $("#status");
			if ('${user.status}' == Constants.STATUS_UNCHECK) {
				_status.val("未审核");
			} else if ('${user.status}' == Constants.STATUS_CHECKED) {
				_status.val("审核通过");
			} else if ('${user.status}' == Constants.STATUS_CHECK_NOPASS) {
				_status.val("审核不通过");
			}

		});
	</script>
</body>
</html>