<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Calev Devise Paie - Employeur</title>

<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
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
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-bordered dataTable" id="dataTable"
									role="grid" aria-describedby="dataTable_info"
									style="width: 100%;" width="100%" cellspacing="0">
<thead>
	<tr role="row">
		<th class="sorting_asc" tabindex="0"
			aria-controls="dataTable" rowspan="1" colspan="1"
			style="width: 145px;" aria-sort="ascending"
		aria-label="Name: activate to sort column descending"><fmt:message
			key="common.id" /></th>
	<th class="sorting" tabindex="0" aria-controls="dataTable"
		rowspan="1" colspan="1" style="width: 224px;"
		aria-label="Position: activate to sort column ascending"><fmt:message
			key="common.siret" /></th>
	<th class="sorting" tabindex="0" aria-controls="dataTable"
		rowspan="1" colspan="1" style="width: 103px;"
		aria-label="Office: activate to sort column ascending"><fmt:message
			key="common.raison" /></th>
	<th class="sorting" tabindex="0" aria-controls="dataTable"
		rowspan="1" colspan="1" style="width: 43px;"
		aria-label="Age: activate to sort column ascending"><fmt:message
			key="common.ape" /></th>
	<th class="sorting" tabindex="0" aria-controls="dataTable"
		rowspan="1" colspan="1" style="width: 95px;"
		aria-label="Start date: activate to sort column ascending"><fmt:message
			key="common.action" /></th>

	<fmt:message key="common.employeur.liste" />
	<div class="row">
	<div class="col-lg-12">
	<ol class="breadcrumb">
	<li><a href="<c:url value="/employeur/nouveau/" />"><i class="fas fa-plus">&nbsp;<fmt:message key="common.ajouter" />&nbsp; &nbsp; &nbsp;</i></a></li>
	<li><a href="#"/><i class="fas fa-upload">&nbsp;<fmt:message key="common.exporter" />&nbsp; &nbsp; &nbsp;</i></li>
	<li><a href="#"/><i class="fas fa-download">&nbsp;<fmt:message key="common.importer" />&nbsp; &nbsp; &nbsp;</i></li>
	</ol>
	</div>
	</div>
</thead>
<tfoot>
	<tr>
		<th rowspan="1" colspan="1"><fmt:message
			key="common.id" /></th>
	<th rowspan="1" colspan="1"><fmt:message
			key="common.siret" /></th>
	<th rowspan="1" colspan="1"><fmt:message
			key="common.raison" /></th>
	<th rowspan="1" colspan="1"><fmt:message
			key="common.ape" /></th>

</tr>
		</tfoot>
			<tbody>
			<c:forEach items="${employeurs }" var="employeur">
					<tr role="row" class="odd">
						<td class="sorting_1">${employeur.getIdEmployeur() }</td>
						<td>${employeur.getRaisonso() }</td>
						<td>${employeur.getSiret() }</td>
						<td>${employeur.getCodeAPE() }</td>
						<td>
						<c:url value="/employeur/modifier/${employeur.getIdEmployeur() }" var="urlModif"></c:url>
						<a href="${urlModif }"><i class="fa fa-edit">&nbsp;</i> </a>
			&nbsp;|&nbsp;
			<!-- Appel du notification pop up -->
			 <c:url value="/employeur/supprimer/${employeur.getIdEmployeur() }" var="urlSupprim"></c:url>	
			<a href="${urlSupprim }" data-toggle="modal" data-target="#modalEmployeur${employeur.getIdEmployeur() }"><i class="fa fa-trash-alt"></i></a>	 	
			<%--<a href="javascript:void(0);" data-toggle="modal" data-target="#modalEmployeur${employeur.getIdEmployeur() }"><i class="fa fa-trash-alt"></i></a> --%>
            <div class="modal fade" id="modalEmployeur${employeur.getIdEmployeur() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="false">&times;</button>
			<h4 class="modal-title" id="myModalLabel"><fmt:message key="common.confirm.suppression" /></h4>
		</div>
		<div class="modal-body">
			<fmt:message key="client.confirm.suppression.msg" />
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="common.annuler" /></button>
			<c:url value="/employeur/supprimer/${employeur.getIdEmployeur() }" var="urlSuppression" />
			<a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash-alt"></i>&nbsp;<fmt:message key="common.confirmer" /></a>
		</div>
	</div>

<!-- Fin appel du pop up -->
</td>
</tr>
</c:forEach>
					
</tbody>
</table>
</div>
	</div>
<div class="row">
	<div class="col-sm-12 col-md-5">
		<div class="dataTables_info" id="dataTable_info" role="status"
			aria-live="polite">Showing 1 to 10 of 57 entries</div>
	</div>
	<div class="col-sm-12 col-md-7">
		<div class="dataTables_paginate paging_simple_numbers"
			id="dataTable_paginate">
			<ul class="pagination">
				<li class="paginate_button page-item previous disabled"
					id="dataTable_previous"><a href="#"
					aria-controls="dataTable" data-dt-idx="0" tabindex="0"
					class="page-link">Previous</a></li>
				<li class="paginate_button page-item active"><a
					href="#" aria-controls="dataTable" data-dt-idx="1"
					tabindex="0" class="page-link">1</a></li>
				<li class="paginate_button page-item "><a href="#"
					aria-controls="dataTable" data-dt-idx="2" tabindex="0"
					class="page-link">2</a></li>
				<li class="paginate_button page-item "><a href="#"
					aria-controls="dataTable" data-dt-idx="3" tabindex="0"
					class="page-link">3</a></li>
				<li class="paginate_button page-item "><a href="#"
					aria-controls="dataTable" data-dt-idx="4" tabindex="0"
					class="page-link">4</a></li>
				<li class="paginate_button page-item "><a href="#"
					aria-controls="dataTable" data-dt-idx="5" tabindex="0"
					class="page-link">5</a></li>
				<li class="paginate_button page-item "><a href="#"
					aria-controls="dataTable" data-dt-idx="6" tabindex="0"
					class="page-link">6</a></li>
				<li class="paginate_button page-item next"
					id="dataTable_next"><a href="#"
					aria-controls="dataTable" data-dt-idx="7" tabindex="0"
					class="page-link">Next</a></li>
			</ul>
		</div>
	</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

	</div>
	<!-- End of Main Content -->

	<!-- Footer -->
	<footer class="sticky-footer bg-white">
		<div class="container my-auto">
			<div class="copyright text-center my-auto">
				<span>Copyright &copy; Your Website 2019</span>
			</div>
		</div>
	</footer>
	<!-- End of Footer -->

</div>
<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded"
	href="<%=request.getContextPath()%>/resources/#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button"
					data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary"
					href="<%=request.getContextPath()%>/resources/login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="<%=request.getContextPath() %>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
	<script src="<%=request.getContextPath() %>/resources/js/sb-admin-2.min.js"></script>
 <script>

 $('#modalEmployeur').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
 </script>
    
</body>

</html>
