<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
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
			<div class="col-md-3 col-lg-2 d-md-block p-3 text-white bg-dark"
				style="width: 250px; height: 533px;">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
					<span class="fs-4">Welcome<br>${ownerName}!</span>
				</a>
				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/owner/home"
						class="nav-link text-white" aria-current="page"> <svg
								class="bi me-2" width="16" height="16">
							<use xlink:href="#home"></use></svg> Home
					</a></li>
					<li><a href="${pageContext.request.contextPath}/owner/items"
						class="nav-link  active"> <svg class="bi me-2" width="16"
								height="16">
							<use xlink:href="#speedometer2"></use></svg> Inventory
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi me-2" width="16" height="16">
							<use xlink:href="#table"></use></svg> Orders
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi me-2" width="16" height="16">
							<use xlink:href="#grid"></use></svg> Products
					</a></li>
					<li><a href="#" class="nav-link text-white"> <svg
								class="bi me-2" width="16" height="16">
							<use xlink:href="#people-circle"></use></svg> Customers
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
							<h1 class="h2">Add new item</h1>
						</div>

					</div>
				</div>

				<!-- add item form -->
				<form:form action="saveItem" modelAttribute="item" method="POST">
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
						<label for="stock">Enter Available stock</label>
					</div>
					<div class="row gy-2 gx-1 align-items-center">
						<div class="col-auto">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
						<div class="col-auto">
							<a class="btn btn-danger" href="items">Cancel</a>
						</div>
					</div>
				</form:form>

			</div>

		</div>
	</div>

</body>
</html>