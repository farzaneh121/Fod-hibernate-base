<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/page.css">
</head>
<body>
	<a href="${pageContext.request.contextPath}/jsps/home.jsp"><button>home</button></a>
	<h2>
		<a
			href="${pageContext.request.contextPath}/UserServlet?action-mode=signOut">Sign
			out</a>
	</h2>
	<form action="${pageContext.request.contextPath}/ShoppingCartServlet"
		method="get">
		<table>
			<c:forEach var="productItem" items="${requestScope.cartProductList}">
				<c:set var="count" value="${count+1}" scope="request" />
				<c:if test="${count mod 4 eq 0 }">
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
							<td><input type="hidden" name="product-id"
								value="${productItem.id}">
								<button type="submit" name="action-mode" value="remove">remove</button>
							</td>
						</tr>

					</table>
				</td>
			</c:forEach>

		</table>
	</form>
	<h3>
		total cost :
		<c:out value="${totalCost}"></c:out>
	</h3>
</body>
</html>