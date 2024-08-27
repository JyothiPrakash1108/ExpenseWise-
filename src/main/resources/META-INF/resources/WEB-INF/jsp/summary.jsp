<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>summary</title>
</head>
	<%@include file="header.jspf" %>
<body>
	<div class="container mt-5">
					<c:forEach var="user" items="${users}">
			    <h3>User: ${user.gmail}</h3>
			    <table class="table table-bordered table-striped">
			        <thead>
			            <tr>
			                <th>Expense Description</th>
			                <th>Amount</th>
			            </tr>
			        </thead>
			        <tbody>
			        	<c:set var="totalSpending" value="0" />
			            <c:forEach var="expense" items="${expenses}">
			                <c:if test="${expense.user.id == user.id}">
			                    <tr>
			                        <td>${expense.description}</td>
			                        <td>${expense.amount}</td>
			                    </tr>
			                    <c:set var="totalSpending" value="${totalSpending + expense.amount}" />
			                </c:if>
			            </c:forEach>
			        </tbody>
			    </table>
			    <h5 class="text-primary text-end">Total Spendings: ${totalSpending}</h5>
			</c:forEach>
		

	</div>
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>