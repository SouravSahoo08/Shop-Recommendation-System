<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

	<table border="1">
		<tr>
			<th></th>
			<th>Item Type</th>
			<th>Item Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Expiry date</th>
			<th>Total</th>
		</tr>
		
		<c:forEach var="it" items="${cartItems}">
			<tr>
				<td>${cartItems.itemType}</td>
				<td>${cartItems.itemName}</td>
				<td>${cartItems.itemPrice}</td>
				<td>${cartItems.quantity}</td>
				<td>${cartItems.expDate}</td>
				<td>${cartItems.itemPrice * cartItems.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a herf="items">Shop more</a>

</body>
</html>