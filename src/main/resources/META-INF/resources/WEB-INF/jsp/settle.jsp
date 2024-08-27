<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Settle Accounts</title>
</head>
<body>
<%@include file="header.jspf"%>
<div class="container mt-5">
    <h3>Debt Settlement</h3>

    <h4>Who Owes You:</h4>
    <c:choose>
        <c:when test="${not empty userGets}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Amount (INR)</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${userGets}">
                        <tr>
                            <td><strong>${entry.key.gmail}</strong></td>
                            <td><span style="color: blue;">${entry.value}</span></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/settleDebt" method="post">
                                    <input type="hidden" name="debtorId" value="${entry.key.id}">
                                    <button type="submit" class="btn btn-primary btn-sm">Settle Debt</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="text-success">Nobody owes you anything.</p>
        </c:otherwise>
    </c:choose>

    <h4>You Owe:</h4>
    <c:choose>
        <c:when test="${not empty userOwes}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Amount (INR)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="entry" items="${userOwes}">
                        <tr>
                            <td><strong>${entry.key.gmail}</strong></td>
                            <td><span style="color: red;">${entry.value}</span></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="text-success">You do not owe anyone anything.</p>
        </c:otherwise>
    </c:choose>
</div>

<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>