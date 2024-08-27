<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Expense</title>
</head>
<body>
<%@include file="header.jspf" %>
	<div class="container mt-5">
		<div id="form-container"  class="mt-4">
			        <form:form id="my-form" method="post" action="/addExpense" class="mt-4" modelAttribute="expense">
			            <div class="mb-3">
			                <label for="description" class="form-label">Description</label>
			                <form:input id="description" path="description" class="form-control" placeholder="Description of the expense" />
			            </div>
			            <div class="mb-3">
			                <label for="amount" class="form-label">Amount</label>
			                <form:input id="amount" path="amount" class="form-control" placeholder="Enter amount" />
			            </div>
			            <div class="mb-3">
			                <label for="date" class="form-label">Transaction Date</label>
			                <form:input id="date" path="date" type="date" class="form-control" />
			            </div>
			            <button type="submit" class="btn btn-primary">add</button>
			        </form:form>
		 </div>
	</div>
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>