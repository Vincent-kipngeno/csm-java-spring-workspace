<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>

</head>


<body>



	<div class="container mt-5">
		<div class="h2 text-center text-danger">Village Regd. Form</div>
		<div class="card">
			<div class="card-header bg-light h3 text-primary">Village Form</div>

			<div class="card-body">
				<div class="container">
					<form action="./saveVlg" method="post" enctype="multipart/form-data">
						<input type="hidden" name="vId" value="${v.villageId}">
						<div class="row">
							<div class="col-4">
								<label for="vnameId" class="font-weight-bold">Village
									Name</label> <input type="text" class="form-control" name="vName"
									id="vnameId" value="${v.name}">
							</div>
							<div class="col-2">
								<label for="popId" class="font-weight-bold">Population</label> <input
									type="text" class="form-control" name="vPop" id="popId"
									value="${v.population}">
							</div>


							<div class="col-4">
								<label for="blockNameId" class="font-weight-bold">Block</label>
								<select name="blockId" id="blockNameId" class="form-control" onchange="getPanchayatByBlockId(this.value)">
									<option value="0">-select-</option>
									<c:forEach items="${blockList}" var="block">
										<option value="${block.blockId}">${block.name}</option>
									</c:forEach>
								</select>
							</div>


							<div class="col-4">
								<label for="pNameId" class="font-weight-bold">Panchayat</label>
								<select name="panchayatId" id="pNameId" class="form-control">
									<option value="0">-select-</option>

								</select>
							</div>
							<div class="col-4">
								<label for="popId" class="font-weight-bold">Upload Auth Doc</label> <input
									type="file" class="form-control" name="adoc" id="adocId"
									>
							</div>
						</div>
						<div class="mt-2 text-center">

							<input type="submit" 
								class="btn btn-success"> <input type="reset"
								class="btn btn-warning">
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="mt-2">
			<div class="h3">All Village Data</div>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Sl.#</th>
						<th>Village Id</th>
						<th>Village Name</th>
						<th>Population</th>
						<th>Panchayat Name</th>
						<th>Block Name</th>
						<th>Doc. Path</th>						
					</tr>

				</thead>

				<tbody>
					<c:forEach items="${villageList}" var="vlg" varStatus="counter">
						<tr>
							<td>${counter.count}</td>
							<td>${vlg.villageId}</td>
							<td>${vlg.name}</td>
							<td>${vlg.population}</td>
							<td>${vlg.panchayat.name}</td>
							<td>${vlg.panchayat.block.name}</td>
							<td><a href="#">${vlg.authDoc}</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>



		</div>




	</div>
	<script type="text/javascript">
		function getPanchayatByBlockId(bId) {
			console.log("Bloc id is: "+bId);
			
			$.ajax({
				type : 'GET',
				url : 'getPachayatByBlockId',
				data : {
					blockId : bId
				},
				success : function(resp) {
					
					 $('#pNameId').html(resp); 
				}
			});
			
			
			
		}
	</script>
</body>

</html>