<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home | Shop Recommendation System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>

<body>
	<!-- nav bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/home">Shop
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
						aria-current="page" href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="${pageContext.request.contextPath}/about-us">About Us</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/contact-us">Contact
							Us</a></li>
				</ul>

				<div class="mx-3">
					<a class="btn btn-primary btn-sm" role="button" data-bs-toggle="modal"
						data-bs-target="#loginModal">Login</a> <span style="color: white;">/</span> <a class="btn btn-primary btn-sm"
						role="button" data-bs-toggle="modal" data-bs-target="#signUpModal">Sign
						Up</a>
				</div>
			</div>
		</div>
	</nav>

	<!-- login Modal -->
	<!-- if login error -->
	<c:if test="${param.error != null}">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<strong>Aw snap!!</strong> Something wrong in entering credentials..
			Please check and try Again.
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>

	<c:if test="${param.logout != null}">

		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			You have been logged out.
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>

	</c:if>
	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="loginModalLabel">Login</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">


					<form:form
						action="${pageContext.request.contextPath}/authenticateTheUser"
						method="POST">
						<div class="mb-3">
							<label for="username" class="form-label">Username</label> <input
								type="text" name="username" class="form-control" id="username">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">Password</label> <input
								type="password" name="password" class="form-control"
								id="password">
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div>

	<!-- signUp Modal -->
	<div class="modal fade" id="signUpModal" tabindex="-1"
		aria-labelledby="signUpModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="signUpModalLabel">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">

					<!--button for customer and owner sign up-->
					<div class="container">
						<div class="row">
							<!-- customer signup -->
							<div class="col">
								<div class="card" style="width: 13rem;">
									<img
										src="${pageContext.request.contextPath}/resources/images/customer.png"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Customer</h5>
										<a href="${pageContext.request.contextPath}/customer-register"
											class="btn btn-primary">Sign up as Customer</a>
									</div>
								</div>
							</div>
							<!-- Owner signup -->
							<div class="col">
								<div class="card" style="width: 13rem;">
									<img
										src="${pageContext.request.contextPath}/resources/images/seller.jpg"
										class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">Shop Owner</h5>
										<a href="${pageContext.request.contextPath}/shop-register"
											class="btn btn-primary">Sign up as Owner</a>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel"
		data-interval="3000">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="${pageContext.request.contextPath}/resources/images/shoppingCarousel.jpg"
					class="d-block w-100" alt="...">
				<div
					class="carousel-caption d-none d-md-block bg-dark text-white bg-opacity-75">
					<h5>Unique Shopping Site</h5>
					<p>An idea to merge technology with the shopping experience to
						revolutionize E-Commerce world.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img
					src="${pageContext.request.contextPath}/resources/images/recommendCarousel.jpg"
					class="d-block w-100" alt="...">
				<div
					class="carousel-caption d-none d-md-block bg-dark text-white bg-opacity-75">
					<h5>Let's Recommend</h5>
					<p>With our amazing recommendation tool we can help your
						business grow!!.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img
					src="${pageContext.request.contextPath}/resources/images/managementCarousel.jpg"
					class="d-block w-100" alt="...">
				<div
					class="carousel-caption d-none d-md-block bg-dark text-white bg-opacity-75">
					<h5>Your Inventory - Our responsibility</h5>
					<p>Tired of managing your stock? Let us handle it..</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container my-4">
		<div
			class="row featurette d-flex justify-content-center align-items-center">
			<div class="col-md-7">
				<h2 class="featurette-heading fw-normal lh-1">Shop management.</h2>
				<p class="lead">Add your stocks to your inventory, We will
					manage them.</p>
			</div>
			<div class="col-md-5">
				<img
					src="${pageContext.request.contextPath}/resources/images/shop-manage.jpg"
					alt="">
			</div>
		</div>
		<div
			class="row featurette d-flex justify-content-center align-items-center">
			<div class="col-md-7 order-md-2">
				<h2 class="featurette-heading fw-normal lh-1">Recomendation.</h2>
				<p class="lead">We will help you grow your buisness through
					recomendation</p>
			</div>
			<div class="col-md-5 order-md-1">
				<img
					src="${pageContext.request.contextPath}/resources/images/recommend.jpg"
					alt="recommend image">
			</div>
		</div>
	</div>


	<footer class="mt-4">
		<ul class="nav justify-content-center border-bottom mb-3">
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/home"
				class="nav-link px-2 text-muted">Home</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Features</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Pricing</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">FAQs</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">About</a></li>
		</ul>
		<p class="text-center text-muted">© 2023 Sourav Kumar Sahoo, Shop
			Recomendation System, Inc</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>