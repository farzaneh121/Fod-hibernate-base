<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
</head>
<body>
	<h1>Login</h1>
	<a href="${pageContext.request.contextPath}/jsps/home.jsp"><button>go
			to home</button> </a>
	<form action="${pageContext.request.contextPath}/UserServlet"
		method="post">
		<table>
			<tr>
				<td>user name</td>
				<td><input type="text" name="user-name" required="required"
					title="user-name"></td>
			</tr>
			<tr>
				<td>email address</td>
				<td><input type="text" name="email-address" required="required"
					title="email-address"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" name="action-mode">
				</td>

			</tr>
		</table>
	</form>
</body>
</html>