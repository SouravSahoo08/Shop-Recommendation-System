<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="light">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard | Shop Recommendation System</title>
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

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark border-bottom border-light-subtle">
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
			<div class="col-md-3 col-lg-2 d-md-block p-3 text-white bg-dark border-end border-bottom"
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
							<h1 class="h2">Available stock</h1>
							<div class="btn-toolbar mb-2 mb-md-0">
								<form:form class="mb-3 mb-lg-0 me-lg-3" action="search"
									method="get">
									<input type="search" class="form-control" name="searchItemName"
										placeholder="Search item..." aria-label="Search" />
								</form:form>

								<div class="col d-grid gap-2">
									<input class="btn btn-primary" type="button" value="Add item"
										onClick="window.location.href='addItemForm'; return false;" />
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-sm table-hover mt-md-2">

						<tr>
							<th>Item Name</th>
							<th>Stock</th>
							<th>Price</th>
							<th>Expiry date</th>
							<th>Action</th>
						</tr>

						<c:forEach var="item" items="${shopList}">
							<!-- How to check for value in shopList ???? -->

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
			</div>

		</div>
	</div>


</body>
</html>