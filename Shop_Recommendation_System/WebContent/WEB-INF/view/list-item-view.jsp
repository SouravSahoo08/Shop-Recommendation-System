<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping</title>
</head>
<body>

	<h2>Available items</h2>
	
	<input type="button" value="Add item"
		onClick = "window.location.href='addItemForm'; return false;"/>
	
	<table border = "1">
	
		<tr>
			<th>Item Name</th>
			<th>Price</th>
			<th>Expiry date</th>
		</tr>
		
		<c:forEach var="item" items = "${shopList}">
		
			<tr>
				<td>${item.itemName}</td>
				<td>Rs. ${item.price}</td>
				<td>${item.expDate}</td>
			</tr>
			
		</c:forEach>
	
	</table> 

</body>
</html>