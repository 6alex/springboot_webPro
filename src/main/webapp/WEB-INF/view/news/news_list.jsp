<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>
<body>
	<ul style="width:1000px;margin: auto;">
		<c:forEach var="news" items="${news}">
			<li><h2>${news.account }</h2><h3>${news.title }</h3><div>${news.content }</div></li>
		</c:forEach>
	</ul>



	<script src="../assets/js/jquery.min.js"></script>	
</body>
</html>
