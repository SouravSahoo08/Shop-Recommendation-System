<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration-Shop</title>

<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>

<h3> Shop owner Registration</h3>

	<!-- check if owner exist -->
	<c:if test="${registrationError != null}">
		<div class="error">
			${registrationError}
		</div>
	</c:if>

	<form:form action="saveOwner" modelAttribute="shop-registration-details" method="POST">
		
		<table>
		
			<tbody>
			
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="ownerName"/></td>
					
				</tr>
				
				<tr>
					<td><label>License No.</label></td>
					<td><form:input path="licenseNo"/></td>
				</tr>

				<tr>
					<td><label>Age</label></td>
					<td><form:input path="age"/></td>
				</tr>

				<tr>
					<td><label>Phone number</label></td>
					<td><form:input path="phoneNo"/></td>
				</tr>
				
				<tr>
					<td><label>Shop type</label></td>
					<td><form:input path="shopType"/></td>
				</tr>
				
				<tr>
					<td><label>Shop address</label></td>
					<td><form:input path="shopAddress"/></td>
				</tr>
				
				<tr><td>----------Login details----------</td></tr>
				
				<tr>
					<td><label>Username</label></td>
					<td><form:input path="sUsername"/></td>
				</tr>	

				<tr>
					<td><label>Password</label></td>
					<td><form:input path="sPwd"/></td>
				</tr>	
						
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Register Me" /></td>
				</tr>	
			</tbody>
			
		</table>
			
	</form:form>

</body>
</html>