<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style>
::-webkit-scrollbar {
	display: none;
}
</style>
</head>

<body>
	<c:set var="ownerName" value="model"></c:set>

	<!-- nav bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="/owner-home.html">Shop
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

	<!-- edit detail form -->
	<div class="modal fade" id="editDetailFromModal" tabindex="-1"
		aria-labelledby="editDetailFromModal" aria-hidden="true">
		<div
			class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="editDetailFromModal">Edit
						details</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form class="row g-3">
						<div class="col-md-6">
							<label for="fullname" class="form-label">Full name</label> <input
								type="text" class="form-control" id="fullname">
						</div>
						<div class="col-md-6">
							<label for="license" class="form-label">License Number</label> <input
								type="text" class="form-control" id="license">
						</div>
						<div class="col-12">
							<label for="inputAddress" class="form-label">Address</label> <input
								type="text" class="form-control" id="inputAddress"
								placeholder="1234 Main St">
						</div>
						<div class="col-md-3">
							<label for="inputAge" class="form-label">Age</label> <input
								type="number" class="form-control" id="inputAge">
						</div>

						<div class="col-12">
							<button type="submit" class="btn btn-primary">Save</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div>

	<div class="container py-4 mb-5">
		<div class="row rounded shadow border border-dark-subtle p-3">
			<div class="col-2 text-center">
				<img
					src="${pageContext.request.contextPath}/resources/images/ownerdp.png"
					class="bd-placeholder-img rounded-circle" width="140" height="140">
			</div>
			<div class="col-md-4 align-self-center">

				<p style="color: rgb(37, 37, 37); font-size: 25px;">Sourav Kumar
					Sahoo</p>
				<p
					style="color: rgb(151, 150, 150); font-size: 18px; margin-top: 1em;">OD19734BS</p>
				<p
					style="color: rgb(151, 150, 150); font-size: 18px; margin-top: -1em;">Sailashree
					vihar, Bhubaneswar-21, Odisha</p>
				<p
					style="color: rgb(151, 150, 150); font-size: 18px; margin-top: -1em;">Shop
					Type : Grocery</p>
				<div class="d-grid gap-1 col-md-8" style="margin-top: 1em;">
					<button class="btn btn-outline-success btn-sm" type="button"
						data-bs-toggle="modal" data-bs-target="#editDetailFromModal">Edit</button>
				</div>
			</div>
		</div>

		<div class="row rounded shadow border border-dark-subtle mt-4 p-3">

			<h4>Do you have any budget constraint?</h4>

			<form:form class="row g-3" action="searchBudgetItems"
				modelAttribute="maxBudget" method="POST">
				<!-- <div class="col-md-4">
                    <label for="minBudget" class="form-label">Minimum budget</label>
                    <input type="number" class="form-control" id="minBudget">
                </div> -->
				<div class="col-md-4">
					<label for="maxBudget" class="form-label">Maximum budget</label>
					<form:input type="number" path="maxBudget" class="form-control"
						id="maxBudget" />
				</div>
				<div class="col-12">
					<button type="submit" class="btn btn-primary">Recommend
						items</button>
				</div>

			</form:form>

			<c:set var="rItems" value="${recommendedItems}"></c:set>
			<c:if test="${not empty rItems}">
				<div class="row" id="itemRecommendationDiv">
					<table class="table-responsive">
						<thead>
							<tr>
								<th scope="col">Item Type</th>
								<th scope="col">Item</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${recommendedItems}">
								<tr>
									<td>${item.itemType}</td>
									<td>${item.itemName}</td>
									<td>${item.itemPrice}</td>
									<td>${item.quantity}</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>

</body>

<!-- <script> 
	$(document)
			.ready(
					function() {
						// Submit form using AJAX
						$('#recommendForm').submit(function(event) {
							event.preventDefault(); // Prevent default form submission

							var formData = $(this).serialize(); // Serialize form data
							var url = $(this).attr('action'); // Get form action URL

							// Send AJAX request
							$.ajax({
								type : 'POST',
								url : url,
								data : formData,
								success : function(response) {
									// Update table with recommended items
									populateTable(response);
								},
								error : function(xhr, status, error) {
									// Handle error
									console.log('Error:', error);
								}
							});
						});

						// Function to populate the table with recommended items
						function populateTable(items) {
							var tableBody = $('#itemRecommendationDiv tbody');
							tableBody.empty(); // Clear existing table rows

							// Iterate over the recommended items and append rows to the table
							$
									.each(
											items,
											function(index, item) {
												var row = $('<tr>');
												row.append('<td>' + (index + 1)
														+ '</td>');
												row.append('<td>'
														+ item.itemName
														+ '</td>');
												row.append('<td>'
														+ item.avgPrice
														+ '</td>');
												row.append('<td>'
														+ item.quantity
														+ '</td>');
												row
														.append('<td><button class="btn btn-primary">Add to Cart</button></td>');
												tableBody.append(row);
											});

							// Show the recommendation table
							$('#itemRecommendationDiv').show();
						}
					});
</script>

-->
</html>