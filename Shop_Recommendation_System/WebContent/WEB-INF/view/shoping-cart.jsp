<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
</head>
<body>

	<button id="emptyCart" type="button"
			onclick="window.location.href='emptyCart'; return false;">Empty cart</button>

	<table border="1">
		<tr>
			<th></th>
			<th>Item Name</th>
			<th>Item Type</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Expiry date</th>
			<th>Total</th>
		</tr>

		<c:set var="sum" value = "0"></c:set>
		<c:forEach var="it" items="${cartItems}">
			<c:set var="sum" value="${sum + it.itemPrice * it.quantity }"></c:set>
			<tr>
				<td><button id="removeFromCart" type="button"
						onclick="window.location.href='remove?itemId=${it.itemId}'; return false;">Remove
						item</button></td>
				<td>${it.itemName}</td>
				<td>${it.itemType}</td>
				<td>${it.itemPrice}</td>
				<td>${it.quantity}</td>
				<td>${it.expDate}</td>
				<td>${Math.round(it.itemPrice * it.quantity*100)/100.0}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total to pay: </td>
			<td>${sum}</td>
		</tr>
	</table>
	<br>
	
	<table>
		<tr>
			<td><a href="items">Shop more</a></td>
			
			<td><button id="checkout" type="button"
						onclick="window.location.href='checkout'; return false;">Checkout</button></td>
		</tr>
	</table>
	<!--   <a href="items">Shop more</a>  -->

</body>
</html>