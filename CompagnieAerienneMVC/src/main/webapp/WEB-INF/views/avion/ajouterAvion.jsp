<%@ include file="/WEB-INF/views/header_footer/header_ajout.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
				<fmt:message key="avions.nouveau" />
			</div>
			<div class="panel-body"></div>
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">
						<fmt:message key="avions.ajouter" />
					</h1>
				</div>
				<c:url value="/avion/enregistrer" var="urlEnregistrer"></c:url>
				<f:form modelAttribute="avion" action="${urlEnregistrer }"
					method="post">
					<f:hidden path="NumAvion" />
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.avion" /></label> <select
								name="typeAvion.typeAvion" path="typeAvion.typeAvion"
								class="custom-select">
<!-- 								<option value="">(Vide)</option> -->
								<c:forEach var="item" items="${typeAvions}">
									<option value="${item.getTypeAvion()}"
										${item.getTypeAvion().equals(selectedValue2) ? 'selected="selected"' : ''}>
										${item.getTypeAvion()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-6">
							<label><fmt:message key="common.aeroport" /></label> <select
								name="baseAeroport.IdAeroport" path="baseAeroport.IdAeroport"
								class="custom-select">
<!-- 								<option value="">(Vide)</option> -->
								<c:forEach var="item" items="${aeroports}">
									<option value="${item.getIdAeroport()}"
										${item.getIdAeroport() == selectedValue ? 'selected="selected"' : ''}>
										${item.getIdAeroport()} - ${item.getNomAeroport()}</option>
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
				<a href="<c:url value="/avion/"/>" class="btn btn-danger"><i
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