<%@ include file="/WEB-INF/views/header_footer/header_ajout.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
				<fmt:message key="constructeurs.nouveau" />
			</div>
			<div class="panel-body"></div>
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">
						<fmt:message key="constructeurs.ajouter" />
					</h1>
				</div>
				<c:url value="/constructeur/enregistrer" var="urlEnregistrer"></c:url>
				<f:form modelAttribute="constructeur" action="${urlEnregistrer }"
					method="post">
					<f:hidden path="idConstructeur" />
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.constructeur" /></label>
							<f:input type="text" path="nomConstructeur"
								class="form-control form-control-user" placeholder="Nom Constructeur e.g. Airbus"
								required="true" />
						</div>
					</div>
			</div>
			<div class="panel-footer">
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-save">&nbsp;<fmt:message
							key="common.enregistrer" /></i>
				</button>
				<a href="<c:url value="/constructeur/"/>" class="btn btn-danger"><i
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
