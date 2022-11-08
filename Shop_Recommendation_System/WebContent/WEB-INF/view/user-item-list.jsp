<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping</title>
</head>
<body>

	<!-- search dialogue -->
	<form:form action="search" method="get">
		Search item: <input type="text" name="searchItemName" />
		<input type="submit" value="Search" class="" />
	</form:form>


	<table border="1">

		<tr>
			<th>Item Name</th>
			<th>Price</th>
			<th>Expiry date</th>
			<th>Action</th>
		</tr>

		<c:forEach var="item" items="${shopList}">
			<!-- How to check for value in shopList ???? -->

			<tr>
				<td>${item.itemName}</td>
				<td>Rs. ${item.price}</td>
				<td>${item.expDate}</td>
				<td>
					<button id="addToCartButton" type="button"
						onclick="window.location.href='cart?itemId=${item.itemId}'; return false;">Add to cart</button>
				</td>

			</tr>


		</c:forEach>

	</table>

</body>
</html>