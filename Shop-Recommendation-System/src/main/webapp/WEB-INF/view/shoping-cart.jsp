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
		
		var emptyButton = document.getElementById("emptyCart") 
		var checkOutButton = document.getElementById("checkout");
		if(sum==0){
			alert("Cart is empty.. add more items.")
			emptyButton.disabled = true;
			checkOutButton.disabled = true;
		}
		else{
			emptyButton.disabled = false;
			checkOutButton.disabled = false;
		}
		
	} 
	
</script>
<style type="text/css">
.content {
    max-width: max-content;
  margin: auto;
   
}
</style>

</head>
<body>
<div class="content">

	<h2>Your shopping cart</h2>
	<hr>
	<br>

	<c:set var="sum" value="0"></c:set>
	
	<a id="emptyCart" href="emptyCart" onclick="">
		<button type="button">Empty cart</button>
	</a>
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
			<td><a href="items?oId=${ownerId}">Shop more</a></td>

			<td><a id="checkout" href="shipping-details"
				onclick="isCartEmpty(${sum})"><button type="button">Next</button></a></td>
		</tr>
	</table>

</div>
</body>
</html>