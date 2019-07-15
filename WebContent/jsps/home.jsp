<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h2><a
		href="${pageContext.request.contextPath}/UserServlet?action-mode=signOut">Sign
		out</a>
</h2>
	<h1>welcome to Fari shop</h1>
	<a href="${pageContext.request.contextPath}/jsps/login.jsp"><button>Login</button>
	</a>
	<a href="${pageContext.request.contextPath}/jsps/register.jsp"><button>Register</button>
	</a>
	<a href="${pageContext.request.contextPath}/ProductServlet"><button>products</button>
	</a>

	<c:if test="${member.firstName ne null}">
		<h2>welcome dear ${member.firstName} , you can login with your
			user name and email. have e good time :)</h2>
	</c:if>


</body>
</html>