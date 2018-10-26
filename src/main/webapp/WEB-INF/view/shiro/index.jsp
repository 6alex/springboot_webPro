<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>
<body>

	<h1>欢迎${user.username }光临!请选择你的操作:</h1>
	<br>
	<ul>
		<shiro:hasPermission name="add">
			<li>增加</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="delete">
			<li>删除</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="update">
			<li>修改</li>
		</shiro:hasPermission>
		<shiro:hasPermission name="query">
			<li id="query">查询</li>
		</shiro:hasPermission>
	</ul>
	<a href="${pageContext.request.contextPath }/logOut">点我注销</a>

	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript">
		$("#query").click(function() {
			window.open("queryNews.html?currentPage=1&pageSize=10");
		});
	</script>
</body>
</html>