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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/datepicker/datepicker.min.css"
	rel="stylesheet" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/datepicker/datepicker.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<style>
::-webkit-scrollbar {
	display: none;
}
</style>
</head>

<body>

	<!-- nav bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid me-3">
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
				<!-- <div class="mx-1">
					<a class="btn btn-primary btn-sm" role="button"
						data-bs-toggle="modal" data-bs-target="#logoutModal">Logout</a>
				</div>
 -->

				<div class="dropdown text-end">
					<a href="#"
						class="d-block text-white text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <img
						src="https://github.com/mdo.png" alt="mdo" width="32" height="32"
						class="rounded-circle">
					</a>
					<ul
						class="dropdown-menu dropdown-menu-dark text-small dropdown-menu-end"
						style="">
						<li><a class="dropdown-item" href="#">New project...</a></li>
						<li><a class="dropdown-item" href="#">Settings</a></li>
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/owner/profile">Profile</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" data-bs-toggle="modal"
							data-bs-target="#logoutModal">Sign out</a></li>
					</ul>
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

	<!-- expiredProductListModal -->
	<div class="modal fade" id="expiredProductListModal" tabindex="-1"
		aria-labelledby="expiredProductListModal" aria-hidden="true">
		<div
			class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="expiredProductListModal">Expied
						product list</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table table-striped table-sm table-hover mt-md-2">

							<tr>
								<th>Item Id</th>
								<th>Item Name</th>
								<th>Stock</th>
								<th>Price</th>
								<th>Expiry date</th>
							</tr>

							<c:forEach var="item" items="${expProd}">
								<tr>
									<td>${item.itemId}</td>
									<td>${item.itemName}</td>
									<td>${item.stock}</td>
									<td>Rs. ${item.price}</td>
									<td>${item.expDate}</td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<a type="button" class="btn btn-primary"
						href="${pageContext.request.contextPath}/owner/items?product-prob=prodExp">Check
						items</a>
				</div>
			</div>
		</div>
	</div>

	<!-- peak sale month modal -->
	<div class="modal fade" id="peakSaleMonthModal" tabindex="-1"
		aria-labelledby="peakSaleMonthModal" aria-hidden="true">
		<div
			class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="peakSaleMonthModal">Items sold in ${peakSaleMonthModel}</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table table-striped table-sm table-hover mt-md-2">

							<tr>
								<th>Item Id</th>
								<th>Item Name</th>
								<th>Quantity sold</th>
								<th>Price</th>
								
							</tr>

							<c:forEach var="item" items="${peakSaleItems}">
								<tr>
									<td>${item[0]}</td>
									<td>${item[1]}</td>
									<td>${item[2]}</td>
									<td>Rs. ${item[3]}</td>
									
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<a type="button" class="btn btn-primary"
						href="${pageContext.request.contextPath}/owner/items?product-prob=zeroStock">Check
						items</a>
				</div>
			</div>
		</div>
	</div>
	<!-- zeroStockListModal -->
	<div class="modal fade" id="zeroStockListModal" tabindex="-1"
		aria-labelledby="zeroStockListModal" aria-hidden="true">
		<div
			class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="zeroStockListModal">Zero
						Stock items</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table table-striped table-sm table-hover mt-md-2">

							<tr>
								<th>Item Id</th>
								<th>Item Name</th>
								<th>Stock</th>
								<th>Price</th>
								<th>Expiry date</th>
							</tr>

							<c:forEach var="item" items="${zeroProd}">
								<tr>
									<td>${item.itemId}</td>
									<td>${item.itemName}</td>
									<td>${item.stock}</td>
									<td>Rs. ${item.price}</td>
									<td>${item.expDate}</td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<a type="button" class="btn btn-primary"
						href="${pageContext.request.contextPath}/owner/items?product-prob=zeroStock">Check
						items</a>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">

		<!-- side nav-bar -->
		<div class="row">
			<div
				class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark min-vh-100 text-white bg-dark border-end border-bottom"
				style="width: 250px; height: 600px;">
				<a href="/"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
					<span class="fs-4">Welcome<br>${ownerName}!</span>
				</a>
				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/owner/home"
						class="nav-link  active" aria-current="page"> <svg
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
						class="nav-link text-white"> <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-inboxes-fill"
								viewBox="0 0 16 16">
  						<path
									d="M4.98 1a.5.5 0 0 0-.39.188L1.54 5H6a.5.5 0 0 1 .5.5 1.5 1.5 0 0 0 3 0A.5.5 0 0 1 10 5h4.46l-3.05-3.812A.5.5 0 0 0 11.02 1H4.98zM3.81.563A1.5 1.5 0 0 1 4.98 0h6.04a1.5 1.5 0 0 1 1.17.563l3.7 4.625a.5.5 0 0 1 .106.374l-.39 3.124A1.5 1.5 0 0 1 14.117 10H1.883A1.5 1.5 0 0 1 .394 8.686l-.39-3.124a.5.5 0 0 1 .106-.374L3.81.563zM.125 11.17A.5.5 0 0 1 .5 11H6a.5.5 0 0 1 .5.5 1.5 1.5 0 0 0 3 0 .5.5 0 0 1 .5-.5h5.5a.5.5 0 0 1 .496.562l-.39 3.124A1.5 1.5 0 0 1 14.117 16H1.883a1.5 1.5 0 0 1-1.489-1.314l-.39-3.124a.5.5 0 0 1 .121-.393z" />
						</svg> Inventory
					</a></li>

					<li><a
						href="${pageContext.request.contextPath}/owner/customer-outlet"
						class="nav-link text-white"> <svg
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
			<div class="col mx-3">

				<div class="row mb-1">
					<h3 class="h3 mt-3">Dashboard</h3>
				</div>

				<div class="row px-2 py-3" style="width: 1050px;">
					<!--    flex-nowrap     overflow-x: scroll; -->
					<!-- total orders -->
					<div class="col-3 px-1" style="width: 290px;">
						<div class="border border-dark border-1 rounded-3 shadow p-3">
							<div class="row">
								<div class="col">
									<h5 class="h5">
										Total orders<br>today
									</h5>

								</div>
								<div class="col">
									<a type="link" class="rounded-5 float-end"
										href="${pageContext.request.contextPath}/owner/home/show-total-orders">
										<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
											fill="#000000" class="bi bi-arrow-right-short"
											viewBox="0 0 16 16">
                      						<path fill-rule="evenodd"
												d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z">
                      						</path>
                    					</svg>
									</a>
								</div>
							</div>

							<div class="row">
								<p class="col h2"
									style="color: #19B211; font-size: 25px; font-weight: bold;">
									${totalOrdersModel}</p>
							</div>
						</div>
					</div>

					<!-- revenue 
					<div class="col-3 px-1" style="width: 290px;">
						<div class="border border-dark border-1 rounded-3 shadow p-3">
							<div class="row">
								<div class="col">
									<h5 class="h5">
										Revenue in<br>${revenueMonthModel}</h5>

								</div>
								<div class="col">
									<a type="link" class="rounded-5 "> <svg
											xmlns="http://www.w3.org/2000/svg" width="27" height="27"
											fill="#000000" class="bi bi-calendar-date float-end"
											viewBox="0 0 16 16" id="picker">
                      						<path
												d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z" />
                      						<path
												d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
                    					</svg>
									</a> <input type="text" id="date" readonly>
									<script>
										$(function() {
											$("#picker").datepicker();
										});
									</script>
								</div>
							</div>

							<div class="row">
								<p class="col h2"
									style="color: #19B211; font-size: 25px; font-weight: bold;">
									Rs. ${revenueAmountOfMonth}</p>
							</div>
						</div>
					</div> -->

					<!-- peak sale -->
					<div class="col-3 px-1" style="width: 290px;">
						<div class="border border-dark border-1 rounded-3 shadow p-3">
							<div class="row">
								<div class="col">
									<h5 class="h5">Peak sale month</h5>
								</div>
								<div class="col">
									<a type="link" class="rounded-5 float-end" href=""
										data-bs-toggle="modal"
										data-bs-target="#peakSaleMonthModal"> <svg
											xmlns="http://www.w3.org/2000/svg" width="30" height="30"
											fill="#000000" class="bi bi-arrow-right-short"
											viewBox="0 0 16 16">
                      						<path fill-rule="evenodd"
												d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z">
                      						</path>
                   						</svg>
									</a>
								</div>
							</div>

							<div class="row">
								<p class="col h2"
									style="color: #19B211; font-size: 25px; font-weight: bold;">
									${peakSaleMonthModel}</p>
							</div>
						</div>
					</div>

					<!-- Expired products -->
					<div class="col-3 px-1" style="width: 290px;">
						<div class="border border-dark border-1 rounded-3 shadow p-3">
							<div class="row">
								<div class="col">
									<h5 class="h5">Expired products</h5>

								</div>
								<div class="col">
									<a type="link" class="rounded-5 float-end"
										data-bs-toggle="modal"
										data-bs-target="#expiredProductListModal"> <svg
											xmlns="http://www.w3.org/2000/svg" width="30" height="30"
											fill="#000000" class="bi bi-arrow-right-short"
											viewBox="0 0 16 16">
                   	   						<path fill-rule="evenodd"
												d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z">
                      						</path>
                    					</svg>
									</a>
								</div>
							</div>

							<div class="row">
								<p class="col h2"
									style="color: #f82a23; font-size: 25px; font-weight: bold;">
									${noOfExpProducts}</p>
							</div>
						</div>
					</div>

					<!-- Out of Stock -->
					<div class="col-3 px-1 mt-3" style="width: 290px;">
						<div class="border border-dark border-1 rounded-3 shadow p-3">
							<div class="row">
								<div class="col">
									<h5 class="h5">Out of stock</h5>

								</div>
								<div class="col">
									<a type="link" class="rounded-5 float-end"
										data-bs-toggle="modal" data-bs-target="#zeroStockListModal">
										<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
											fill="#000000" class="bi bi-arrow-right-short"
											viewBox="0 0 16 16">
                      						<path fill-rule="evenodd"
												d="M4 8a.5.5 0 0 1 .5-.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5A.5.5 0 0 1 4 8z">
                      						</path>
                    					</svg>
									</a>
								</div>
							</div>

							<div class="row">
								<p class="col h2 mt-4"
									style="color: #f82a23; font-size: 25px; font-weight: bold;">
									${outOfStockCount}</p>
							</div>
						</div>
					</div>
				</div>

				<div class="row">

					<!-- graph canvas here 
					<div class="col p-1">
						<form>
							<label for="year-select">Select year:</label> <select
								id="year-select" onchange="loadChart(this.value)">
								<option value="${selectedYear}">${selectedYear}</option>
								<option value="${selectedYear - 1}">${selectedYear- 1}</option>
								<option value="${selectedYear- 4}">${selectedYear - 4}</option>
								
							</select>
						</form>

						<canvas id="revenueChart"></canvas>

						<script type="text/javascript">
							function loadChart(year) {
								var url = "${pageContext.request.contextPath}/owner/home/revenue-chart-data?y="
										+ year;
								$
										.get(
												url,
												function(data) {
													var revenues = data
															.map(function(obj) {
																return obj.revenue;
															});
													console.log(revenues);
													var chartData = {
														labels : [ 'Jan',
																'Feb', 'Mar',
																'Apr', 'May',
																'Jun', 'Jul',
																'Aug', 'Sep',
																'Oct', 'Nov',
																'Dec' ],
														datasets : [ {
															label : "Revenue",
															backgroundColor : "rgba(0, 99, 132, 0.2)",
															borderColor : "rgba(0, 99, 132, 1)",
															borderWidth : 2,
															hoverBackgroundColor : "rgba(0, 99, 132, 0.4)",
															hoverBorderColor : "rgba(0, 99, 132, 1)",
															data : revenues
														} ]
													};
													var chartOptions = {
														responsive : true,
														maintainAspectRatio : false,
														scales : {
															yAxes : [ {
																ticks : {
																	beginAtZero : true
																}
															} ]
														}
													};
													var chart = new Chart(
															$("#revenueChart"),
															{
																type : 'bar',
																data : chartData,
																options : chartOptions
															});
												}, "json");
							}
						</script>

					</div>-->

				</div>

			</div>

		</div>


		<!-- Recommendation module -->
		<div class="row px-3 pt-3">
			<div
				class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center mb-1 border-bottom">
				<h2 class="h2">Recommendation module</h2>
			</div>
		</div>

		<!-- most sold products -->
		<div
			class="row rounded-3 shadow border border-dark-subtle my-3 mx-2 p-2">
			<div class="d-flex flex-row">
				<h2 class="h4">Most sold products during this month</h2>
			</div>

			<div class="table-responsive">
				<table
					class="table table-striped table-sm table-hover text-center mt-md-2">

					<tr>
						<th>Item Id</th>
						<th>Item Name</th>
						<th>Product Line</th>
						<th>Item type</th>
						<th>Total Sold</th>
					</tr>

					<c:forEach var="item" items="${mostSoldProductModel}">
						<tr>
							<td>${item[0]}</td>
							<td>${item[1]}</td>
							<td>${item[2]}</td>
							<td>${item[3]}</td>
							<td>${item[4]}</td>
						</tr>
					</c:forEach>

				</table>
			</div>

		</div>

		<!-- least sold products -->
		<div
			class="row rounded-3 shadow border border-dark-subtle my-3 mx-2 p-2">
			<div class="d-flex flex-row">
				<h2 class="h4">Least sold products</h2>
				<p class="mt-1 ms-3" style="color: rgb(247, 72, 41);">
					<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
						fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
            			<path
							d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
            			<path
							d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
          			</svg>
					<strong><em> (These item prices needs to be updated
							or dis-continued temporarily.)</em></strong>
				</p>
			</div>

			<div class="table-responsive">
				<table
					class="table table-dark table-striped table-sm table-hover text-center mt-md-2">

					<tr>
						<th>Item Id</th>
						<th>Item Name</th>
						<th>Product Line</th>
						<th>Item type</th>
						<th>Total Sold</th>
					</tr>

					<c:forEach var="item" items="${leastSoldProductModel}">
						<tr>
							<td>${item[0]}</td>
							<td>${item[1]}</td>
							<td>${item[2]}</td>
							<td>${item[3]}</td>
							<td>${item[4]}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>

		<!-- profitablity -->
		<div
			class="row rounded-3 shadow border border-dark-subtle my-3 mx-2 p-2">
			<div class="d-flex flex-row">
				<h2 class="h4">Profitability</h2>
				<!-- <p class="mt-1 ms-3" style="color: rgb(247, 72, 41);">
					<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
						fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
            			<path
							d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
            			<path
							d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
          			</svg>
					<strong><em> (These item prices needs to be updated
							or dis-continued temporarily.)</em></strong>
				</p> -->
			</div>

			<div class="table-responsive">
				<table
					class="table table-striped table-sm table-hover text-center mt-md-2">

					<tr>
						<th>Item Id</th>
						<th>Item Name</th>
						<th>Product Line</th>
						<th>Item type</th>
						<th>Profit/loss</th>
					</tr>

					<c:forEach var="item" items="${profitabilityModel}">
						<tr>
							<td>${item[0]}</td>
							<td>${item[1]}</td>
							<td>${item[2]}</td>
							<td>${item[3]}</td>
							<td>${item[4]}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>

	</div>

</body>
</html>