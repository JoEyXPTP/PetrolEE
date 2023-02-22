<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
<c:import url="layout/header.jsp"></c:import>
</head>
<body>
	<!-- Responsive Nav Bar -->
	<c:import url="layout/nav.jsp"></c:import>

	<!-- Sale List -->
	<div class="row my-2">
		<div class="col-1"></div>
		<div class="col-10">
			<div class="container">
				<table id="invoiceTable" class="table table-striped"
					style="width: 100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>Username</th>
							<th>Email</th>
							<th>Petrol_Type</th>
							<th>Amount</th>
							<th>Total Price</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="invoice" items="${invoiceList }">

							<tr>
								<td>${invoice.id }</td>
								<td>${invoice.username }</td>
								<td>${invoice.email }</td>
								<td>${invoice.petrol_type }</td>
								<td>${invoice.amount }</td>
								<td>${invoice.total_price }</td>
								<td>${invoice.date }</td>
							</tr>
						</c:forEach>

					</tbody>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Username</th>
							<th>Email</th>
							<th>Petrol_Type</th>
							<th>Amount</th>
							<th>Total Price</th>
							<th>Date</th>
						</tr>
					</tfoot>
				</table>

				<script type="text/javascript" src="~/Scripts/jquery.js"></script>
				<script type="text/javascript"
					src="~/Scripts/data-table/jquery.dataTables.js"></script>

				<script>$(document).ready(function () {
						    $.noConflict();
						    var table = $('#invoiceTable').DataTable();
						});</script>
			</div>
		</div>
		<div class="col-1"></div>
	</div>

	<!-- footer section -->
	<c:import url="layout/footer.jsp"></c:import>

</body>
</html>