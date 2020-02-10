<%@ include file="/WEB-INF/views/header_footer/header.jsp"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered dataTable" id="dataTable"
			role="grid" aria-describedby="dataTable_info" style="width: 100%;"
			width="100%" cellspacing="0">
			<thead>
				<tr role="row">
					<th class="sorting_asc" tabindex="0" aria-controls="dataTable"
						rowspan="1" colspan="1" style="width: 145px;"
						aria-sort="ascending"
						aria-label="Name: activate to sort column descending"><fmt:message
							key="common.avion" /></th>
					<th class="sorting" tabindex="0" aria-controls="dataTable"
						rowspan="1" colspan="1" style="width: 224px;"
						aria-label="Position: activate to sort column ascending"><fmt:message
							key="common.type" /></th>
					<th class="sorting" tabindex="0" aria-controls="dataTable"
						rowspan="1" colspan="1" style="width: 103px;"
						aria-label="Office: activate to sort column ascending"><fmt:message
							key="common.aeroport" /></th>
					<th class="sorting" tabindex="0" aria-controls="dataTable"
						rowspan="1" colspan="1" style="width: 95px;"
						aria-label="Start date: activate to sort column ascending"><fmt:message
							key="common.action" /></th>

					<fmt:message key="common.avions.liste" />
					<div class="row">
						<div class="col-lg-12">
							<ol class="breadcrumb">
								<li><a href="<c:url value="/avion/nouveau/" />"><i
										class="fas fa-plus">&nbsp;<fmt:message
												key="common.ajouter" />&nbsp; &nbsp; &nbsp;
									</i></a></li>
							</ol>
						</div>
					</div>
			</thead>
			<tfoot>
				<tr>
					<th rowspan="1" colspan="1"><fmt:message key="common.avion" /></th>
					<th rowspan="1" colspan="1"><fmt:message key="common.type" /></th>
					<th rowspan="1" colspan="1"><fmt:message
							key="common.aeroport" /></th>

				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${avions }" var="avion">
					<tr role="row" class="odd">
						<td class="sorting_1">${avion.getNumAvion()}</td>
						<td>${avion.getTypeAvion().getTypeAvion()}</td>
						<td>${avion.getBaseAeroport().getIdAeroport()}</td>
						<td><c:url value="/avion/modifier/${avion.getNumAvion() }"
								var="urlModif"></c:url> <a href="${urlModif }"><i
								class="fa fa-edit">&nbsp;</i> </a> &nbsp;|&nbsp; <!-- Appel du notification pop up -->
							<c:url value="/avion/supprimer/${avion.getNumAvion() }"
								var="urlSupprim"></c:url> <a href="${urlSupprim }"
							data-toggle="modal"
							data-target="#modalAvion${avion.getNumAvion() }"><i
								class="fa fa-trash-alt"></i></a>
							<div class="modal fade" id="modalAvion${avion.getNumAvion() }"
								tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
								aria-hidden="false">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button avion="button" class="close" data-dismiss="modal"
												aria-hidden="false">&times;</button>
											<h4 class="modal-title" id="myModalLabel">
												<fmt:message key="common.confirm.suppression" />
											</h4>
										</div>
										<div class="modal-body">
											<fmt:message key="avion.confirm.suppression.msg" />
										</div>
										<div class="modal-footer">
											<button avion="button" class="btn btn-default"
												data-dismiss="modal">
												<fmt:message key="common.annuler" />
											</button>
											<c:url value="/avion/supprimer/${avion.getNumAvion() }"
												var="urlSuppression" />
											<a href="${urlSuppression }" class="btn btn-danger"><i
												class="fa fa-trash-alt"></i>&nbsp;<fmt:message
													key="common.confirmer" /></a>
										</div>
									</div>

									<!-- Fin appel du pop up --></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/header_footer/footer.jsp"%>