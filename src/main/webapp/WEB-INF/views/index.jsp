<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>welcome</title>

<style type="text/css">
.cover {
	vertical-align: middle;
	min-height: 600px;
	margin-top: 250px;
}

body {
	background-color: gray;
}
</style>
</head>
<body>
	<div class="container">
		<div class="cover">
			<div class="container">
				<div class="text-center">
					<div class="col-md-offset-3 col-md-3">
						<a class="btn btn-default btn-lg col-md-10" href="/account/register.html">去注册</a>
					</div>
					<div class="col-md-3">
						<a class="btn btn-primary btn-lg col-md-10" href="/account/login.html">去登陆</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>