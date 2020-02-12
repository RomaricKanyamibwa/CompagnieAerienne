<%@ include file="/WEB-INF/views/header_footer/header_ajout.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
				<fmt:message key="affectations.nouveau" />
			</div>
			<div class="panel-body"></div>
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">
						<fmt:message key="affectations.ajouter" />
					</h1>
				</div>
				<c:url value="/affectation/enregistrer" var="urlEnregistrer"></c:url>
				<f:form modelAttribute="affectation" action="${urlEnregistrer }"
					method="post">
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.vol" /></label> <select
								name="pkAffectation.NumVol" path="pkAffectation.NumVol"
								class="custom-select">
								<!-- 								<option value="0">(Vide)</option> -->
								<c:forEach var="item" items="${vols}">
									<option value="${item.getNumVol()}"
										${item.getNumVol() == selectedValue ? 'selected="selected"' : ''}>
										${item.getNumVol()} - ${item.getAeroportDept().getNomAeroport()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.date" /></label>
							<div class='input-group date'>
								<f:input type='text' class="form-control" path="pkAffectation.DateVol"
									name="pkAffectation.DateVol" placeholder="DD-MM-YYYY"
									 id='datetimepicker4' required="true"/>
							</div>

						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.vol" /></label> <select
								name="avion.NumAvion" path="avion.NumAvion"
								class="custom-select">
								<!-- 								<option value="0">(Vide)</option> -->
								<c:forEach var="item" items="${avions}">
									<option value="${item.getNumAvion()}"
										${item.getNumAvion() == selectedValue2 ? 'selected="selected"' : ''}>
										${item.getNumAvion()} - ${item.getTypeAvion().getTypeAvion()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.pilote" /></label> <select
								name="pilote.idPilote" path="pilote.idPilote"
								class="custom-select">
								<c:forEach var="item" items="${pilotes}">
									<option value="${item.getIdPilote()}"
										${item.getIdPilote() == selectedValue3 ? 'selected="selected"' : ''}>
										${item.getIdPilote()} / ${item.getNomPilote()} - ${item.getPrenomPilote()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
			</div>
			<div class="panel-footer">
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-save">&nbsp;<fmt:message
							key="common.enregistrer" /></i>
				</button>
				<a href="<c:url value="/affectation/"/>" class="btn btn-danger"><i
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