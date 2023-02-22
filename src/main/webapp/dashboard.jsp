<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="layout/header.jsp"></c:import>
</head>
<body>
	<!-- Responsive Nav Bar -->
	<c:import url="layout/nav.jsp"></c:import>

	<!-- Petrol Instock List -->
	<div class="row my-2">
		<div class="col-1"></div>
		<div class="col-10">

			<table id="petrolTable" name="petrolTable"
				class="table table-striped" style="width: 100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Petrol_Type</th>
						<th>Quantity</th>
						<th>Unit_Price</th>
						<th>Instock</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="petrol" items="${petrolList }">

						<c:url var="editLink" value="petrol">
							<c:param name="mode" value="LOAD"></c:param>
							<c:param name="id" value="${petrol.id }"></c:param>
						</c:url>

						<c:url var="deleteLink" value="petrol">
							<c:param name="mode" value="DELETE"></c:param>
							<c:param name="id" value="${petrol.id }"></c:param>
						</c:url>
						<tr>
							<td>${petrol.id }</td>
							<td>${petrol.petrol_type }</td>
							<td>${petrol.quantity }</td>
							<td>${petrol.unit_price }</td>
							<td><c:choose>
									<c:when test="${petrol.instock }">
                            						*Instock
                            					</c:when>
								</c:choose></td>

							<td><a href="${editLink }" class="btn btn-primary">Edit</a>
								<a href="${deleteLink }" class="btn btn-danger"
								onclick="return confirm('Are you sure to delete?');">Delete</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
				<tfoot>
					<tr>
						<th>ID</th>
						<th>Petrol_Type</th>
						<th>Quantity</th>
						<th>Unit_Price</th>
						<th>Instock</th>
						<th>Actions</th>
					</tr>
				</tfoot>
			</table>


			<script type="text/javascript" src="~/Scripts/jquery.js"></script>
			<script type="text/javascript"
				src="~/Scripts/data-table/jquery.dataTables.js"></script>

			<script>
				$(document).ready(function() {
					$.noConflict();
					var table = $('#petrolTable').DataTable();
				});
			</script>

		</div>

		<div class="col-1"></div>
	</div>
	<!-- footer section -->
	<c:import url="layout/footer.jsp"></c:import>

</body>
</html>