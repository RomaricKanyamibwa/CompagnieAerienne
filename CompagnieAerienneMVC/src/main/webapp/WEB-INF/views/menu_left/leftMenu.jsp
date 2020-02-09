
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-plane-departure"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Compagnie Aerienne</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->

	<li class="nav-item"><a class="nav-link" href=""> <i
			class="fas fa-chart-line"></i> <fmt:message key="common.dashboard" /></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Interface</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Components</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Components:</h6>
				<a class="collapse-item" href="buttons.html">Buttons</a> <a
					class="collapse-item" href="cards.html">Cards</a>
			</div>
		</div></li>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Custom Utilities:</h6>
				<a class="collapse-item" href="utilities-color.html">Colors</a> <a
					class="collapse-item" href="utilities-border.html">Borders</a> <a
					class="collapse-item" href="utilities-animation.html">Animations</a>
				<a class="collapse-item" href="utilities-other.html">Other</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Entités</div>
	<div>
		<!--  <a class="collapse-item" href="../salarie">Salarié</a> -->
<!-- 		<c:url value="/salarie/" var="salarie" /> -->
<%-- 		<li class="nav-item"><a class="nav-link" href="${salarie }"><i --%>
<!-- 				class="fas fa-coins"></i> <fmt:message key="common.salarie" /> </a></li> -->
		<c:url value="/pilote/" var="pilote" />
		<li class="nav-item"><a class="nav-link" href="${pilote}"><i
				class="fas fa-user-shield"></i> <fmt:message key="common.pilote" />
		</a></li>
		<c:url value="/aeroport/" var="aeroport" />
		<li class="nav-item"><a class="nav-link" href="${aeroport}"><i
				class="fas fa-plane-arrival"></i> <fmt:message key="common.aeroport" />
		</a></li>
		<c:url value="/constructeur/" var="constructeur" />
		<li class="nav-item"><a class="nav-link" href="${constructeur}">
		<i class="fas fa-tools"></i>
		<fmt:message key="common.constructeur" />
		</a></li>
		<c:url value="/type/" var="type" />
		<li class="nav-item"><a class="nav-link" href="${type}">
		<i class="fas fa-plane"></i>
		<fmt:message key="common.type" />
		</a></li>
	</div>
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item active"><a class="nav-link" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>Pages</span>
	</a>
		<div id="collapsePages" class="collapse hide"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Login Screens:</h6>
				<a class="collapse-item" href="login.html">Login</a> <a
					class="collapse-item" href="register.html">Register</a> <a
					class="collapse-item" href="forgot-password.html">Forgot
					Password</a>
			</div>
		</div></li>

	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href="charts.html"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
	</a></li>

	<!-- Nav Item - Tables -->
	<li class="nav-item"><a class="nav-link" href="tables.html"> <i
			class="fas fa-fw fa-table"></i> <span>Tables</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>
</ul>
<!-- End of Sidebar -->