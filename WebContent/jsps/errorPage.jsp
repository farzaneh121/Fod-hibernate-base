<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
</head>
<body id="error-body">
	<br>

	<h2>${requestScope.exception}</h2>
	<h2>${requestScope.statusCode}</h2>
	<h2>${requestScope.servletName}</h2>
	<a href="${pageContext.request.contextPath}/jsps/home.jsp"><button>home</button></a>

</body>
</html>