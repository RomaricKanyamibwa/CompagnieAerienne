<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Yes">
<link rel="icon"
	href="<%=request.getContextPath()%>/resources/img/logo2.png">

<title>${title}</title>

<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Navigation -->
		<%@include file="/WEB-INF/views/menu_left/leftMenu.jsp"%>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Top Menu -->
				<%@include file="/WEB-INF/views/menu_top/topMenu.jsp"%>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">
						<fmt:message key="common.dashboard" />
					</h1>
					<!-- Mettre le tableau ici -->
					<div class="card-body">
						<div class="table-responsive">
							<div id="dataTable_wrapper"
								class="dataTables_wrapper dt-bootstrap4">
								<div class="row">
									<div class="col-sm-12 col-md-6">
										<div class="dataTables_length" id="dataTable_length">
											<label>Show <select name="dataTable_length"
												aria-controls="dataTable"
												class="custom-select custom-select-sm form-control form-control-sm"><option
														value="10">10</option>
													<option value="25">25</option>
													<option value="50">50</option>
													<option value="100">100</option></select> entries
											</label>
										</div>
									</div>
									<div class="col-sm-12 col-md-6">
										<div id="dataTable_filter" class="dataTables_filter">
											<label>Search:<input type="search"
												class="form-control form-control-sm" placeholder=""
												aria-controls="dataTable"></label>
										</div>
									</div>
								</div>