<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <h3 class="text-center mt-5">Login</h3>
                <form:form action="login" method="post" modelAttribute="user">
                    <div class="mb-3">
                        <form:label path="gmail" cssClass="form-label">gmail</form:label>
                        <form:input path="gmail" cssClass="form-control" required="true"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="password" cssClass="form-label">Password</form:label>
                        <form:password path="password" cssClass="form-control" required="true"/>
                        <form:errors path="password" cssClass="text-warning"/>
                        <form:errors cssClass="alert alert-danger" element="div"/>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Login</button>
                </form:form>
                <p><a href="/register">Register user</a></p>
            </div>
            
        </div>
</div>
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>