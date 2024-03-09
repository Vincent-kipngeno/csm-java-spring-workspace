<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Insurance Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Insurance Form</h2>

    <form:form action="submitForm" method="post">
        <div class="form-group">
            <label for="season">Season:</label>
            <form:select path="crop.season" id="season" class="form-control">
                <form:options items="${seasons}" />
            </form:select>
        </div>

        <div class="form-group">
            <label for="cropName">Crop Name:</label>
            <form:select path="crop.cropId" id="cropName" class="form-control">
                <form:options items="${cropNames}" itemValue="cropId" itemLabel="name" />
            </form:select>
        </div>

        <div class="form-group">
            <label for="farmerName">Farmer Name:</label>
            <form:input path="farmerName" id="farmerName" class="form-control" maxlength="50" pattern="[A-Za-z ]+" />
        </div>

        <div class="form-group">
            <label for="aadhaarNo">Aadhaar No:</label>
            <form:input path="aadhaarNo" id="aadhaarNo" class="form-control" maxlength="12" pattern="[0-9]+" />
        </div>

        <div class="form-group">
            <label for="fatherName">Father Name:</label>
            <form:input path="fatherName" id="fatherName" class="form-control" maxlength="12" pattern="[A-Za-z0-9 ]+" />
        </div>

        <div class="form-group">
            <label for="completeAddress">Complete Address:</label>
            <form:input path="completeAddress" id="completeAddress" class="form-control" maxlength="250" />
        </div>

        <div class="form-group">
            <label for="farmerCategory">Farmer Category:</label>
            <form:checkboxes path="farmerCategory" items="${farmerCategories}" element="div class='form-check'" />
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success mr-3">Submit</button>
            <button type="reset" class="btn btn-warning">Clear</button>
        </div>
    </form:form>
</div>

</body>
</html>