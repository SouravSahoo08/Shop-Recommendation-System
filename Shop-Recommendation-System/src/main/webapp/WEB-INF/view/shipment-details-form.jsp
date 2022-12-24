<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Detail</title>

<style>
.error {
	color: red
}
.content {
    max-width: max-content;
  margin: auto;
   
}
</style>
</head>
<body>
<div class="content">
	<h3>Fill your shipment details</h3>

	<form:form action="checkout" modelAttribute="shipmentModel">

		<table>



			<tr>
				<td><label>Name: </label></td>
				<td><form:input path="customerName" /> <form:errors
						path="customerName" cssClass="error" /></td>

			</tr>

			<tr>
				<td><label>address: </label></td>
				<td><form:input path="address" /> <form:errors path="address"
						cssClass="error" /></td>

			</tr>

			<tr>
				<td><label>Pincode: </label></td>
				<td><form:input path="pincode" /> <form:errors path="pincode"
						cssClass="error" /></td>

			</tr>

			<tr>
				<td><label>Contact no.: </label></td>
				<td><form:input path="contactNo" /> <form:errors
						path="contactNo" cssClass="error" /></td>

			</tr>

			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Place order" /></td>
			</tr>



		</table>

	</form:form>


	<a href="cart">Back to cart</a>
</div>
</body>
</html>