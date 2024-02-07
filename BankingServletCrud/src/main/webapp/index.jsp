<!--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> -->
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- Font Awesome -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
	<!-- MDB -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="css/styles.css">
	<script src="https://code.jquery.com/jquery-2.2.4.js"
		integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
</head>

<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<!-- Container wrapper -->
		<div class="container-fluid">
			<!-- Navbar brand -->
			<a class="navbar-brand" href="#">Navbar</a>

			<!-- Toggle button -->
			<button class="navbar-toggler" type="button" data-mdb-toggle="collapse"
				data-mdb-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars text-light"></i>
			</button>

			<!-- Collapsible wrapper -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<!-- Left links -->
				<ul class="navbar-nav me-auto d-flex flex-row mt-3 mt-lg-0">
					<li class="nav-item text-center mx-2 mx-lg-1">
						<a class="nav-link active" aria-current="page" href="#!">
							<div>
								<i class="fas fa-home fa-lg mb-1"></i>
							</div>
							Home
						</a>
					</li>
					<li class="nav-item text-center mx-2 mx-lg-1">
						<a class="nav-link" href="#!">
							<div>
								<i class="far fa-envelope fa-lg mb-1"></i>
								<span class="badge rounded-pill badge-notification bg-danger">11</span>
							</div>
							Link
						</a>
					</li>
					<li class="nav-item text-center mx-2 mx-lg-1">
						<a class="nav-link disabled" aria-disabled="true" href="#!">
							<div>
								<i class="far fa-envelope fa-lg mb-1"></i>
								<span class="badge rounded-pill badge-notification bg-warning">11</span>
							</div>
							Disabled
						</a>
					</li>
					<li class="nav-item dropdown text-center mx-2 mx-lg-1">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
							data-mdb-toggle="dropdown" aria-expanded="false">
							<div>
								<i class="far fa-envelope fa-lg mb-1"></i>
								<span class="badge rounded-pill badge-notification bg-primary">11</span>
							</div>
							Dropdown
						</a>
						<!-- Dropdown menu -->
						<ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li>
								<hr class="dropdown-divider" />
							</li>
							<li>
								<a class="dropdown-item" href="#">Something else here</a>
							</li>
						</ul>
					</li>
				</ul>
				<!-- Left links -->

				<!-- Right links -->
				<ul class="navbar-nav ms-auto d-flex flex-row mt-3 mt-lg-0">
					<li class="nav-item text-center mx-2 mx-lg-1">
						<a class="nav-link" href="#!">
							<div>
								<i class="fas fa-bell fa-lg mb-1"></i>
								<span class="badge rounded-pill badge-notification bg-info">11</span>
							</div>
							Messages
						</a>
					</li>
					<li class="nav-item text-center mx-2 mx-lg-1">
						<a class="nav-link" href="#!">
							<div>
								<i class="fas fa-globe-americas fa-lg mb-1"></i>
								<span class="badge rounded-pill badge-notification bg-success">11</span>
							</div>
							News
						</a>
					</li>
				</ul>
				<!-- Right links -->

				<!-- Search form -->
				<form class="d-flex input-group w-auto ms-lg-3 my-3 my-lg-0">
					<input type="search" class="form-control" placeholder="Search" aria-label="Search" />
					<button class="btn btn-primary" type="button" data-mdb-ripple-color="dark">
						Search
					</button>
				</form>
			</div>
			<!-- Collapsible wrapper -->
		</div>
		<!-- Container wrapper -->
	</nav>
	<!-- Navbar -->

	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.1.0/mdb.umd.min.js"></script>
</body>

</html>