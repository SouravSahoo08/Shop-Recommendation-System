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
				<td><button id="removeFromCart" type="button">Remove item</button>
						<!-- onclick="window.location.href='cart?itemId=${item.itemId}'; return false;" -->
						
				</td>
				<td>${it.itemType}</td>
				<td>${it.itemName}</td>
				<td>${it.itemPrice}</td>
				<td>${it.quantity}</td>
				<td>${it.expDate}</td>
				<td>${it.itemPrice * it.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="items">Shop more</a>

</body>
</html>