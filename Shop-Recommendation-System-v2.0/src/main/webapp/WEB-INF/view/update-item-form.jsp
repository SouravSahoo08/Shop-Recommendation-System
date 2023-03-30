<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Item | Shop Recommendation System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<title>Item modification</title>

<style type="text/css">
.content {
	max-width: max-content;
	margin: auto;
}
</style>
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/owner/home">Shop
				Recommendation System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto me-2 mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath}/owner/home">Home</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/about-us">About Us</a></li>
					<li class="nav-item"><a class="nav-link" href="/contact-us">Contact
							Us</a></li>
				</ul>
				<div class="mx-1">
					<a class="btn btn-primary btn-sm" role="button"
						data-bs-toggle="modal" data-bs-target="#logoutModal">Logout</a>
				</div>
			</div>
		</div>
	</nav>

	<!-- logout alert box-->
	<div class="modal fade" id="logoutModal" tabindex="-1"
		aria-labelledby="logoutModalLabel" aria-hidden="true">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="logoutModalLabel">Logging out</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<div class="alert alert-danger" role="alert">You will be
						logged out. Are you sure?</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">No</button>
					<form:form action="${pageContext.request.contextPath}/logout"
						method="POST">

						<input class="btn btn-primary" type="submit"
							value="Yes, Log me out" />

					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- main content -->
	<div class="container-fluid">

		<!-- side nav-bar -->
		<div class="row">
			<div
				class="col-md-3 col-lg-2 d-md-block p-3 min-vh-100 text-white bg-dark border-end border-bottom"
				style="width: 250px; height: 600px;">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
					<span class="fs-4">Welcome<br>${ownerName}!</span>
				</a>
				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/owner/home"
						class="nav-link text-white" aria-current="page"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-house-check-fill"
								viewBox="0 0 16 16">
  						<path
									d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
  						<path
									d="m8 3.293 4.712 4.712A4.5 4.5 0 0 0 8.758 15H3.5A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
  						<path
									d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm1.679-4.493-1.335 2.226a.75.75 0 0 1-1.174.144l-.774-.773a.5.5 0 0 1 .708-.707l.547.547 1.17-1.951a.5.5 0 1 1 .858.514Z" />
						</svg> Home
					</a></li>

					<li><a href="${pageContext.request.contextPath}/owner/items"
						class="nav-link  active"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-inboxes-fill"
								viewBox="0 0 16 16">
  						<path
									d="M4.98 1a.5.5 0 0 0-.39.188L1.54 5H6a.5.5 0 0 1 .5.5 1.5 1.5 0 0 0 3 0A.5.5 0 0 1 10 5h4.46l-3.05-3.812A.5.5 0 0 0 11.02 1H4.98zM3.81.563A1.5 1.5 0 0 1 4.98 0h6.04a1.5 1.5 0 0 1 1.17.563l3.7 4.625a.5.5 0 0 1 .106.374l-.39 3.124A1.5 1.5 0 0 1 14.117 10H1.883A1.5 1.5 0 0 1 .394 8.686l-.39-3.124a.5.5 0 0 1 .106-.374L3.81.563zM.125 11.17A.5.5 0 0 1 .5 11H6a.5.5 0 0 1 .5.5 1.5 1.5 0 0 0 3 0 .5.5 0 0 1 .5-.5h5.5a.5.5 0 0 1 .496.562l-.39 3.124A1.5 1.5 0 0 1 14.117 16H1.883a1.5 1.5 0 0 1-1.489-1.314l-.39-3.124a.5.5 0 0 1 .121-.393z" />
						</svg> Inventory
					</a></li>
					
					<li><a href="${pageContext.request.contextPath}/owner/customer-outlet" class="nav-link text-white"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-cart3" viewBox="0 0 16 16">
  						<path
									d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
						</svg> Customer Outlet
					</a></li>
				</ul>
				<hr>

			</div>

			<!-- Content div -->
			<div class="col-md-9 mx-auto">

				<div class="my-md-4">
					<div class="row">

						<div
							class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
							<h1 class="h2">Update item</h1>
						</div>

					</div>
				</div>

				<!-- update item form -->
				<form:form action="saveItem" modelAttribute="item" method="POST">

					<form:hidden path="itemId" />
					<div class="form-floating mb-3">
						<form:input path="itemType" type="text" class="form-control"
							id="itemType" placeholder="Milk" />
						<label for="itemType">Item type</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="itemName" type="text" class="form-control"
							id="itemName" placeholder="Omfed" />
						<label for="itemName">Item Name</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="price" type="number" class="form-control"
							id="itemPrice" placeholder="Rs 32.00" />
						<label for="itemPrice">Item price</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="expDate" type="date" class="form-control"
							id="expDate" placeholder="DD-MM-YYYY" />
						<label for="expDate">Expiry date</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="stock" type="number" class="form-control"
							id="stock" placeholder="stock" />
						<label for="stock">Available stock</label>
					</div>
					<div class="row gy-2 gx-1 align-items-center">
						<div class="col-auto">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
						<div class="col-auto">
							<a class="btn btn-danger" href="items">Cancel</a>
						</div>
					</div>
				</form:form>

			</div>

		</div>
	</div>


	<%-- 
<div class="content">
	<h2>Update item.</h2>

	<form:form action="saveItem" modelAttribute="item" method="POST">

		<form:hidden path="itemId" />
		<table>

			<tbody>

				<tr>
					<td><label>Item type: </label></td>
					<td><form:input path="itemType" /></td>
					<form:errors path="itemName" cssClass="error" />
				</tr>

				<tr>
					<td><label>Item name: </label></td>
					<td><form:input path="itemName" /></td>
					<form:errors path="itemType" cssClass="error" />
				</tr>

				<tr>
					<td><label>Price: </label></td>
					<td><form:input path="price" /></td>
					<form:errors path="price" cssClass="error" />
				</tr>

				<tr>
					<td><label>Expiry Date: </label></td>
					<td><form:input path="expDate" /></td>
					<form:errors path="expDate" cssClass="error" />
				</tr>

				<tr>
					<td><label>Stock available: </label></td>
					<td><form:input path="stock" /></td>
					<!-- <form:errors path="expDate" cssClass="error" /> -->
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Update" /></td>
				</tr>

			</tbody>

		</table>

	</form:form>

	<p>
		<a href="items">Back to list</a>
	</p>
</div> --%>
</body>
</html>