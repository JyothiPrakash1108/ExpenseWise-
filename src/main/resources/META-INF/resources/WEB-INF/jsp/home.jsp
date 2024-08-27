<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
	<%@ include file="header.jspf" %>
<div class="container mt-5">
		<a href="<c:url value='/addExpense' />" class="btn btn-success btn-sm">Add Expense</a>
        <c:choose>
            <c:when test="${not empty roomExpenses}">
                <h3 class="mt-4">Room Expenses</h3>
                
                <table class="table table-bordered table-striped mt-3">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Amount</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>User</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="expense" items="${roomExpenses}">
                            <tr>
                                <td>${expense.id}</td>
                                <td>${expense.amount}</td>
                                <td>${expense.description}</td>
                                <td>${expense.date}</td>
                                <td>${expense.user.gmail}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="text-center mt-5">
                    <h4>No room expenses available.</h4>
                </div>
            </c:otherwise>
        </c:choose>	
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
  
</body>
</html>