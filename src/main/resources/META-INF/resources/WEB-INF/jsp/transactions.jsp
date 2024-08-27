<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>transactions</title>
</head>
<body>
<%@ include file="header.jspf" %>
	<div class="container mt-5">
		<c:choose>
			<c:when test="${not empty transactions }">
			<h3 class="mt-4">your transactions</h3>
				<table class="table table-bordered table-striped mt-3">
					<thead>
						<tr>
							<th>ID</th>
                            <th>Amount</th>
                            <th>Description</th>
                            <th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${transactions }">
							<tr>
								<td>${a.id}</td>
								<td>${a.amount}</td>
								<td>${a.description}</td>
								<td>${a.date}</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</c:when>
			<c:otherwise>
				<div class="text-center mt-5">
					<h4>You dont have any transactions</h4>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>