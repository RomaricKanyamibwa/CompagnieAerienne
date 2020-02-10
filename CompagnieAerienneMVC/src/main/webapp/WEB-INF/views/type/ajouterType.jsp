<%@ include file="/WEB-INF/views/header_footer/header_ajout.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
				<fmt:message key="types.nouveau" />
			</div>
			<div class="panel-body"></div>
			<div class="p-5">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">
						<fmt:message key="types.ajouter" />
					</h1>
				</div>
				<c:url value="/type/enregistrer" var="urlEnregistrer"></c:url>
				<f:form modelAttribute="type" action="${urlEnregistrer }"
					method="post">
					<%--               <f:hidden path="idAeroport"/> --%>
					<div class="form-group">
						<label><fmt:message key="common.type" /></label>
						<f:input type="text" path="typeAvion"
							class="form-control form-control-user"
							placeholder="Type d'Avion e.g. A380" pattern="^[A-Z][A-Z0-9]+"
							title="Le Type d'Avion doit commencer obligatoirement par une lettre"
							required="true" />

					</div>
					<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
							<label><fmt:message key="common.capacite" /></label>
							<f:input type="number" min="50" max="400" path="capacite"
								class="form-control form-control-user"
								placeholder="Capacite d'avion" />
						</div>
						<div class="col-sm-6">
							<label><fmt:message key="common.constructeur" /></label>
							<select name="constructeur.idConstructeur" path="constructeur.idConstructeur"
								class="custom-select">
								<option value="0">(Vide)</option>
								<c:forEach var="item" items="${constructeurs}">
									<option value="${item.idConstructeur}"
									${item.idConstructeur == selectedConstructeur ? 'selected="selected"' : ''}>
										${item.nomConstructeur}</option>
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
				<a href="<c:url value="/type/"/>" class="btn btn-danger"><i
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