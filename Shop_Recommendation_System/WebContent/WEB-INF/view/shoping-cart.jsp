<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>

<script type="text/javascript">
	
	function isCartEmpty(sum){
		
		var button = document.getElementById("checkout");
		if(sum==0){
			alert("Cart is empty.. add more items.")
			button.disabled = true;
		}
		else{
			button.disabled = false;
		}
		
	} 
	
</script>


</head>
<body>

	<button id="emptyCart" type="button"
		onclick="window.location.href='emptyCart'; return false;">Empty
		cart</button>

	<c:set var="sum" value="0"></c:set>
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
			<td colspan="6" align="right">Total to pay:</td>
			<td>${sum}</td>
		</tr>
	</table>
	<br>

	<table>
		<tr>
			<td><a href="items">Shop more</a></td>

			<td><a id="checkout" href="checkout"
				onclick="isCartEmpty(${sum})"><button type="button">Checkout</button></a></td>
		</tr>
	</table>


</body>
</html>