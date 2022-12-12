<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store</title>
<style type="text/css">
.content {
    max-width: max-content;
  margin: auto;
   
}
</style>
</head>
<body>
<div class="content">
	
	<h2>Available stock</h2>
	<hr>
	<br>

	<input type="button" value="Add item"
		onClick="window.location.href='addItemForm'; return false;" />

	<!-- search dialogue -->
	<form:form action="search" method="get">
		Search item: <input type="text" name="searchItemName"/>
		<input type="submit" value="Search" class=""/>
	</form:form>


	<table border="1">

		<tr>
			<th>Item Name</th>
			<th>Stock</th>
			<th>Price</th>
			<th>Expiry date</th>
			<th>Action</th>
		</tr>

		<c:forEach var="item" items="${shopList}"> <!-- How to check for value in shopList ???? -->

			<tr>
				<td>${item.itemName}</td>
				<td>${item.stock}</td>
				<td>Rs. ${item.price}</td>
				<td>${item.expDate}</td>
				<td><a href="showItem?id=${item.itemId}">Update</a> / <a
					href="removeItem?id=${item.itemId}"
					onClick="if(!(confirm('Are you sure you want to delete this item?'))) return false">Remove</a></td>
			</tr>


		</c:forEach>

	</table>
</div>
</body>
</html>