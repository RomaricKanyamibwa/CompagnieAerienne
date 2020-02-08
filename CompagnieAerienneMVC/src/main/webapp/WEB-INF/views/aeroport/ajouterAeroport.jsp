<%@ include file="/WEB-INF/views/header_footer/header_ajout.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
				<fmt:message key="aeroports.nouveau" />
			</div>
			<div class="panel-body"></div>
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">
						<fmt:message key="aeroports.ajouter" />
					</h1>
				</div>
				<c:url value="/aeroport/enregistrer" var="urlEnregistrer"></c:url>
				<f:form modelAttribute="aeroport" action="${urlEnregistrer }"
					method="post">
					<%--               <f:hidden path="idAeroport"/> --%>
					<div class="form-group">
						<label><fmt:message key="common.id" /></label>
						<f:input type="text" path="idAeroport"
							class="form-control form-control-user"
							placeholder="identifiant de l'aeroport e.g. CDG"
							pattern="[A-Za-z]{3}"
							title="L'identifiant doit être un mot de 3 lettres"
							required="true" />
					</div>
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.aeroport" /></label>
							<f:input type="text" path="nomAeroport"
								class="form-control form-control-user"
								placeholder="Nom Aeroport" required="true" />
						</div>
						<div class="col-sm-6">
							<label><fmt:message key="common.villeD" /></label>
							<f:input type="text" path="NomVilleDesservie"
								class="form-control form-control-user" placeholder="Ville" />
						</div>
					</div>
			</div>
			<div class="panel-footer">
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-save">&nbsp;<fmt:message
							key="common.enregistrer" /></i>
				</button>
				<a href="<c:url value="/aeroport/"/>" class="btn btn-danger"><i
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