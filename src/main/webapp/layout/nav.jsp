<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div class="header_section">
	<div class="container-fluid">
		<nav
			class="row d-flex justify-content-between navbar navbar-expand-lg navbar-light bg-light">
			<div class="col-5 text">
				<a href="petrol?mode=LIST">JOEY</a>
			</div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="col-6 collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ">
					<c:if test="${user.role == 'user' }">
						<li><a class="nav-link active" href="petrol?mode=LIST">Home</a></li>
						<li><a class="nav-link" href="petrol?mode=SHOP">Petrol</a></li>
					</c:if>

					<c:if test="${user.role == 'admin' }">
						<li><a class="nav-link" href="petrol?mode=LIST">Home</a></li>
						<li><a class="nav-link" href="petrol?mode=LOADALL">Petrol List</a></li>
						<li><a class="nav-link" href="petrol?mode=PAGE">Add Petrol</a></li>
						<li><a class="nav-link" href="invoice?mode=LIST">Sale List</a></li>
					</c:if>
					
					<li><a class="nav-link" href="logout">Logout</a>

				</ul>
			</div>
		</nav>
	</div>
</div>