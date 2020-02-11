<%@ include file="/WEB-INF/views/header_footer/header_ajout.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
				<fmt:message key="vols.nouveau" />
			</div>
			<div class="panel-body"></div>
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">
						<fmt:message key="vols.ajouter" />
					</h1>
				</div>
				<c:url value="/vol/enregistrer" var="urlEnregistrer"></c:url>
				<f:form modelAttribute="vol" action="${urlEnregistrer }"
					method="post">
					<f:hidden path="NumVol" />
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.Dep" /></label> <select
								name="AeroportDept.IdAeroport" path="AeroportDept.IdAeroport"
								class="custom-select">
								<!-- 								<option value="0">(Vide)</option> -->
								<c:forEach var="item" items="${aeroports}">
									<option value="${item.getIdAeroport()}"
										${item.getIdAeroport() == selectedValue2 ? 'selected="selected"' : ''}>
										${item.getIdAeroport()} - ${item.getNomAeroport()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.hdep" /></label>
							<div class='input-group date' id='datetimepicker3'>
								<f:input type='text' class="form-control" path="Hdepart"
									name="Hdepart" placeholder="HH:mm" required="true"/>
								<span class="input-group-append input-group-addon">
									<button type="button" class="btn btn-primary">
										<i class="fas fa-business-time"></i>
									</button>
								</span>
							</div>

						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.Arr" /></label> <select
								name="AeroportArr.IdAeroport" path="AeroportArr.IdAeroport"
								class="custom-select">
								<!-- 								<option value="0">(Vide)</option> -->
								<c:forEach var="item" items="${aeroports}">
									<option value="${item.getIdAeroport()}"
										${item.getIdAeroport() == selectedValue ? 'selected="selected"' : ''}>
										${item.getIdAeroport()} - ${item.getNomAeroport()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.harr" /></label>
							<div class='input-group date' id='datetimepicker2'>
								<f:input type='text' class="form-control" path="HArrivee"
									name="HArrivee" placeholder="HH:mm" required="true"/>
								<span class="input-group-append input-group-addon">
									<button type="button" class="btn btn-primary">
										<i class="fas fa-business-time"></i>
									</button>
								</span>
							</div>

						</div>
					</div>
			</div>
			<div class="panel-footer">
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-save">&nbsp;<fmt:message
							key="common.enregistrer" /></i>
				</button>
				<a href="<c:url value="/vol/"/>" class="btn btn-danger"><i
					class="fa fa-arrow-left">&nbsp;<fmt:message
							key="common.annuler" /></i></a>
			</div>
			<hr>
			</f:form>

			<hr>
			<div class="text-center">
				<a class="small" href="forgot-password.html">Forgot Password?</a>
			</div>
			<div class="text-center">
				<a class="small" href="login.html">Already have an account?
					Login!</a>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->

</div>
<%@ include file="/WEB-INF/views/header_footer/footer_ajout.jsp"%>