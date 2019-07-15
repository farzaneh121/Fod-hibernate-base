<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
</head>
<body>
	<a href="${pageContext.request.contextPath}/jsps/home.jsp"><button>home</button></a>
	<h2>
		<a
			href="${pageContext.request.contextPath}/ShoppingCartServlet?action-mode=goToCart">
			Shopping cart</a>
	</h2>
	<h2>
		<a
			href="${pageContext.request.contextPath}/UserServlet?action-mode=signOut">Sign
			out</a>
	</h2>
	<form action="${pageContext.request.contextPath}/ShoppingCartServlet"
		method="get">
		<table>
			<c:forEach var="productItem" items="${requestScope.productList}">
				<c:set var="countRow" value="${countRow+1}" scope="request" />
				<c:if test="${countRow mod 4 eq 0}">
					<tr>
				</c:if>
				<td>
					<table id="mini-table">
						<tr>
							<td><c:out value="${productItem.name}" /></td>
						</tr>
						<tr>
							<td><c:out value="${productItem.cost}" /></td>
						</tr>
						<tr>
							<td><c:out value="${productItem.category.categoryName}" /></td>
						</tr>
						<tr>
							<td><c:out value="${productItem.productStatus}" /></td>
						</tr>
						<tr>
							<td><a
								href="${pageContext.request.contextPath}/ShoppingCartServlet?action-mode=add&product-id=${productItem.id}">
									Add</a></td>
						</tr>

					</table>
				</td>

			</c:forEach>
		</table>
	</form>

</body>
</html>