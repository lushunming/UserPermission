<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>任务管理</title>
</head>

<!-- <body class="easyui-layout">
	头部标题
	<div data-options="region:'north',border:false" style="height: 60px; padding: 5px; background: #E0ECFF">
		<span class="northTitle">后台管理系统模板</span> <span class="loginInfo">登录用户：admin&nbsp;&nbsp;姓名：管理员&nbsp;&nbsp;角色：系统管理员</span>
	</div>
	页脚信息
	<div data-options="region:'south',border:false" style="height: 20px; background: #E6EEF8; padding: 2px; vertical-align: middle;">
		<span id="sysVersion">系统版本：V1.0</span> <span id="nowTime"></span>
	</div>

	西左
	<div data-options="region:'west',title:'West',split:true,collapsible:false" style="width: 200px;">
		<div id="aa" class="easyui-accordion">
			<div title="Title1">
				<a onclick="addTabs()">click</a>
			</div>
			<div title="Title2">content2</div>
			<div title="Title3">content3</div>
		</div>
	</div>
	内容tabs
	<div id="center" data-options="region:'center'">
		<div id="tabs" class="easyui-tabs" border="false" fit="true">
			<div title="首页" style="padding: 5px; display: block;">
				<p>模板说明：</p>
				<ul>
					<li>主界面使用 easyui1.3.5</li>
					<li>导航树使用 JQuery-zTree-v3.5.15</li>
				</ul>
				<p>特性说明：</p>
				<ul>
					<li>所有弹出框均显示在顶级父窗口</li>
					<li>修改easyui window拖动，移动时显示窗口而不显示虚线框，并限制拖动范围</li>
				</ul>
			</div>
		</div>
	</div> -->
<body class="easyui-layout" data-options="fit : true,border : false" >
	<div region="north" border="true" split="true" style="overflow: hidden; height: 80px;">
		<div class="top-bg">
				"${user}",${user.roles}
		</div>
	</div>
	<div region="south" border="true" split="true" style="overflow: hidden; height: 40px;">
		<div class="footer">footer</div>
	</div>
	<div region="west" split="true" title="导航菜单" style="width: 200px;">

		<a href="javascript:void(0);" onclick="add()">click</a>
		<a href="javascript:void(0);" onclick="addTabs()">click</a>

	</div>
	<div id="mainPanle" region="center" border="false" style="padding: 1px; overflow: hidden;">
		<!-- <div id="tabs" ></div> -->
		<iframe id="frame" scrolling="no" frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
	</div>
	<script>
		$(function() {
			$("#tabs").tabs({
				width : $("#tabs").parent().width(),
				height : $("#tabs").parent().height(),
				fit:true
			});
		});
		//添加一个选项卡面板 
		function addTabs(title, icon) {
			var url = "/task/list.html"
			if (!$('#tabs').tabs('exists', title)) {
				$('#tabs').tabs('add', {
					title : title,
					content : createFrame(url),
					closable : true,
					 width: $('#mainPanle').width() - 10,
                     height: $('#mainPanle').height() - 26
				});
			} else {
				$('#tabs').tabs('select', title);
			}
		}
		function createFrame(url) {
		    var s = '<iframe name="mainFrame" scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
		    return s;
		}
		function add(){
			$("#frame").attr("src","/task/list.html");
		}
	</script>
</body>

</html>