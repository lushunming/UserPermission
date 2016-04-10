<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>任务查看</title>
</head>
<body>
	<div class="container-fluid">
		<form class="row form-horizontal margin" id="taskAddForm">
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
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>