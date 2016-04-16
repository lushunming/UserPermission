<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>角色查看</title>
</head>
<body>
	<div class="container-fluid">
		<form class="row form-horizontal margin" id="roleAddForm">
			<div class="form-group">
				<label class="col-xs-3 control-label">
					名称：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="名称" name="name" value="${role.name}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3  control-label">
					角色等级：
					<span class="text-danger">*</span>
				</label>
				<div class="col-xs-8">
					<input type="text" class="form-control" placeholder="等级" name="level" value="${role.level}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-3  control-label"> 描述： </label>
				<div class="col-xs-8">
					<textarea class="form-control" rows="3" placeholder="描述" name="description">${role.description}</textarea>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>