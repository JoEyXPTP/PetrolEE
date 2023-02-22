<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="layout/header.jsp"></c:import>
</head>
<body>
	<!-- Responsive Nav -->
	<c:import url="layout/nav.jsp"></c:import>
	<div class="row my-3">
		<div class="col-4"></div>
		<div class="col-4">
			<div class="card text-dark bg-info mb-3" style="max-width: 100%;">
				<div class="card-body">
					<div class="container text-center">
						<form action="petrol" method="post">
							<h2 class="text-center text-light">Invoice</h2>

							<input type="hidden" name="mode" value="LIST">

							<div class="mb-3">
								<label for="petrol_type" class="form-label">Date : </label> <label>${invoice.date}</label>

							</div>

							<div class="mb-3">
								<label for="petrol_type" class="form-label">User Name :
								</label> <label>${invoice.username}</label>
							</div>
							<div class="mb-3">
								<label for="petrol_type" class="form-label">User Email :
								</label> <label>${invoice.email}</label>
							</div>
							<div class="mb-3">
								<label for="petrol_type" class="form-label">Petrol Type
									: </label> <label>${invoice.petrol_type}</label>

							</div>
							<div class="mb-3">
								<label for="petrol_type" class="form-label">Quantity : </label>
								<label>${invoice.amount}</label>

							</div>
							<div class="mb-3">
								<label for="petrol_type" class="form-label">Total Amount
									: </label> <label>${invoice.total_price}</label>
							</div>
							<button type="submit" class="btn btn-primary">OK</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-4"></div>
	</div>




	<!-- footer section -->
	<c:import url="layout/footer.jsp"></c:import>
</body>
</html>