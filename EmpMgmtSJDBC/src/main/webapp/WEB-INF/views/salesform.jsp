<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Form</title>
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
	
		<c:if test="${msg ne null}">
			<div class="alert alert-success" id="alId">${msg}</div>
		
		</c:if>
		
		<div class="h2 text-center text-danger">Employee Form</div>
        <div class="card">
            <div class="card-header bg-light h3 text-primary">Employee Form</div>

            <div class="card-body">
                <div class="container">
                    <form action="./" method="post">
                        <input type="hidden" name="empId" value="${existingEmployee.empId}"> <div class="row">
                            <div class="col-4">
                                <label for="name" class="font-weight-bold">Employee Name</label>
                                <input type="text" name="name" id="name" class="form-control" value="${existingEmployee.name}">
                            </div>
                            <div class="col-4">
                                <label for="hireDate" class="font-weight-bold">Hire Date</label>
                                <input type="date" name="hireDate" id="hireDate" class="form-control" value="${existingEmployee.hireDate}">
                            </div>
                            <div class="col-4">
                                <label for="salary" class="font-weight-bold">Salary</label>
                                <input type="number" step="0.01" name="salary" id="salary" class="form-control" value="${existingEmployee.salary}">
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col-6">
                                <label for="employmentType" class="font-weight-bold">Employment Type</label>
                                <select name="employmentType" id="employmentType" class="form-control">
                                    <option value="">-select-</option>
                                    <option value="FULL_TIME" ${existingEmployee.employmentType == 'FULL_TIME' ? 'selected' : ''}>Full-time</option>
                                    <option value="PART_TIME" ${existingEmployee.employmentType == 'PART_TIME' ? 'selected' : ''}>Part-time</option>
                                    </select>
                            </div>
                            <div class="col-6">
                                <label for="deptId" class="font-weight-bold">Department ID</label>
                                <input type="number" name="deptId" id="deptId" class="form-control" value="${existingEmployee.deptId}">
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col-12">
                                <input type="checkbox" name="isDeleted" id="isDeleted" ${existingEmployee.isDeleted ? 'checked' : ''}>
                                <label for="isDeleted">Deleted</label>
                            </div>
                        </div>

                        <div class="mt-2 text-center">
                            <input type="submit" class="btn btn-success">
                            <input type="reset" class="btn btn-warning">
                        </div>
                    </form>
                </div>
            </div>
        </div>

		<div class="mt-2">
			<div class="h3">All Sales Dtls</div>
			
			<table class="table table-bordered table-striped mt-2">
				<thead>
					<tr>
						<th>Sl.#</th>
						<th>Customer Name</th>
						<th>Product Name</th>
						<th>Sales Date</th>
						<th>Qnty</th>
						<th>Unit Price</th>
						<th>Total Price</th>	
						<th>Action</th>					
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${salesList}" var="sales" varStatus="counter">
						<tr>
							<td>${counter.count}</td>
							<td>${sales.customer.customerName}</td>
							<td>${sales.product.productName}</td>
							<td>${sales.salesDate}</td>
							<td>${sales.salesQnty}</td>	
							<td>${sales.product.unitPrice}</td>
							<td>${sales.salesQnty*sales.product.unitPrice} </td>
							<td><a class='btn btn-danger' href="./delSales?sId=${sales.salesId}">Del</a>&nbsp;
							<a class='btn btn-info' href="./upSales?sId=${sales.salesId}">Update</a></td>						
						</tr>
					</c:forEach>

				</tbody>

			</table>
			
		</div>




	</div>
	<script type="text/javascript">
	
	$(document).ready(function(){
		setTimeout(function(){
			document.getElementById("alId").style.display = 'none';
			}, 2000);
	});
	
	
	function validateForm(){
		var cId=$('#customerId').val();
		var pId=$('#productId').val();
		var sQnty=$('#salesQntyId').val();
		
		
		var status=true;
		if(cId==0){
			alert("Plz select a customer name!!");
			status=false;
		}
		if(pId==0){
			alert("Plz select a product!!");
			status=false;
		}
		if(sQnty==""){
			alert("plz provide some qnty");
			status=false;
		}else{
			
			var aQnty=Number($('#qnId').val());
			var sqn=Number(sQnty);
			if(sqn>aQnty){
				alert("Sales qnty must be same or less than available qnty!!");
				status=false;
				
			}
		}
		return status;
	}
	
	function getProductQntyByProductId(pId) {
			
		$.ajax({
				type : 'GET',
				url : 'getProductQntyByProductId',
				data : {
					productId : pId
					
				},
				success : function(resp) {
					
					$('#qnId').val(resp);
				}
			});

		}
	
	
		
	</script>
</body>

</html>