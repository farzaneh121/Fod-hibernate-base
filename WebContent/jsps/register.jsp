<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
</head>
<body>
	<a href="${pageContext.request.contextPath}/jsps/home.jsp"><button>home</button></a>

	<h1>Register user</h1>

	<form action="${pageContext.request.contextPath}/UserServlet"
		method="post">
		<table>
			<tr>
				<td>first name:</td>
				<td><input type="text" name="first-name" required="required"">
				</td>
			</tr>
			<tr>
				<td>last name:</td>
				<td><input type="text" name="last-name" required="required"">
				</td>
			</tr>
			<tr>
				<td>email address:</td>
				<td><input type="text" name="email-address" required="required"">
				</td>
			</tr>
			<tr>
				<td>user name:</td>
				<td><input type="text" name="user-name" required="required"">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="action-mode" value="save"">
				</td>
				<td><a href="${pageContext.request.contextPath}/jsps/home.jsp"><button>go
							to home</button> </a></td>
			</tr>
		</table>
	</form>
</body>
</html>