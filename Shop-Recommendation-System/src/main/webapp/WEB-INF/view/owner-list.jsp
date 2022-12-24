<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owners</title>
<style type="text/css">
.content {
    max-width: max-content;
  margin: auto;
   
}
</style>
</head>
<body>
<div class="content">

	<h2>Shops</h2>
	<hr>
	<br>

	<table border="1">

		<tr>
			<th>Sl no</th>
			<th>Owner</th>
			<th></th>

		</tr>
		<c:forEach var="i" items="${owners}">
			<table>
				<tr>
					<td>${i.slNo }</td>
					<td>${i.ownerId }</td>
					<td>
					<button id="showItem" type="button"
						onclick="window.location.href='items?oId=${i.ownerId}'; return false;">Show</button>
				</td>
				</tr>
			</table>
		</c:forEach>
	</table>
</div>
</body>
</html>