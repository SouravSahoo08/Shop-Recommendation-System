<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration-Customer</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>

<h3> Customer Registration</h3>

	<!-- check if owner exist -->
	<c:if test="${registrationError != null}">
		<div class="error">${registrationError}</div>
	</c:if>

	<form:form action="saveUser" modelAttribute="customer-registration-details" method="POST">
		
		<table>
		
			<tbody>
			
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="cutomerName"/></td>
					
				</tr>
		
				<tr>
					<td><label>Age</label></td>
					<td><form:input path="age"/></td>
				</tr>

				<tr>
					<td><label>Phone number</label></td>
					<td><form:input path="phoneNo"/></td>
				</tr>
								
				<tr><td>----------Login details----------</td></tr>
				
				<tr>
					<td><label>Username</label></td>
					<td><form:input path="cUsername"/></td>
				</tr>	

				<tr>
					<td><label>Password</label></td>
					<td><form:input path="cPwd"/></td>
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