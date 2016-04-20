<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/resources/common/basejs.jsp"%>
<title>权限管理系统</title>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div region="north" border="true" split="true" style="overflow: hidden; height: 80px;">
		<div class="row">
			<span class="col-md-4">任务权限管理系统</span>
			<span class="col-md-offset-7 margin-top">
				<a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'icon-edit'">${user.user.loginname}</a>
			</span>
		</div>
		<div id="mm1" style="width: 150px;">
			<div data-options="iconCls:'icon-undo'">
				<a href="/account/password/change.html" target="_blank">修改密码</a>
			</div>
			<div data-options="iconCls:'icon-redo'" onclick="logout()">退出</div>

		</div>
	</div>
	<div region="south" border="true" split="true" style="overflow: hidden; height: 40px;">
		<span id="sysVersion">系统版本：V1.0</span>
	</div>
	<div region="west" split="true" title="功能菜单" style="width: 200px;">

		<!-- 	<a href="javascript:void(0);" onclick="add()">click</a>
		<a href="javascript:void(0);" onclick="addTabs()">click</a> -->
		<ul class="easyui-tree" id="tree">

		</ul>
	</div>
	<div id="mainPanle" region="center" border="false" style="padding: 1px; overflow: hidden;">
		<!-- <div id="tabs" ></div> -->
		<iframe id="frame" scrolling="no" frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
	<script>
		$(function() {
			init();
		});

		function init() {
			$('#tree').tree({
				formatter : function(node) {
					return node.name;
				},
				loader : function(param, success, error) {
					Util.callAjax("/main/getTasks", {}, function(data) {
						if (data.success) {
							success(data.data);
						} else {
							Util.showMessage(data.msg);
						}
					});
				},
				onClick : function(node) {
					add(node.url);
				}
			});
		}
		//添加一个选项卡面板 
		function addTabs(title, icon) {
			var url = "/task/list.html"
			if (!$('#tabs').tabs('exists', title)) {
				$('#tabs').tabs('add', {
					title : title,
					content : createFrame(url),
					closable : true,
					width : $('#mainPanle').width() - 10,
					height : $('#mainPanle').height() - 26
				});
			} else {
				$('#tabs').tabs('select', title);
			}
		}
		function createFrame(url) {
			var s = '<iframe name="mainFrame" scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:100%;">_$tag____';
			return s;
		}
		function add(url) {
			$("#frame").attr("src", url);
		}
		/**退出登录*/

		function logout() {
			Util.callAjax("/account/logout", {}, function(data) {
				if (data.success) {
					window.location = "/account/login.html";
				}
			});
		}
	</script>
</body>

</html>