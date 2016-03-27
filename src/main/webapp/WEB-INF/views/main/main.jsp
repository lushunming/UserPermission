<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>

<title>任务管理</title>
</head>
<body>
<body class="easyui-layout">
	<!--北上-->
	<div data-options="region:'north',title:'North Title',split:true,collapsible:false" style="height: 100px;">north</div>
	<!--南下-->
	<div data-options="region:'south',title:'South Title',split:true,collapsible:false" style="height: 100px;">south</div>
	<!--西左-->
	<div data-options="region:'west',title:'West',split:true,collapsible:false" style="width: 200px;">
		<div id="aa" class="easyui-accordion">
			<div title="Title1">content1</div>
			<div title="Title2">content2</div>
			<div title="Title3">content3</div>
		</div>
	</div>
	<!--中-->
	<div data-options="region:'center',title:'center title',collapsible:false" style="padding: 5px; background: #eee;">
		<div id="tab" class="easyui-tabs">
			<div title="Home"></div>
		</div>
	</div>
	<script>
		$(function() {
			$('#tab').tabs('add', {
				title : 'New Tab',
				content : 'Tab Body',
				closable : true,
				href : "/task/list.html"	
			});
		});
	</script>
</body>
</body>

</html>