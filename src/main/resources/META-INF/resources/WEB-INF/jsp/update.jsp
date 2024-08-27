<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Update Room</title>
</head>
<body>
<%@include file="header.jspf" %>
<div class="container mt-5">
					<div class="mt-4">
                        <button id="show-form-button" onclick="toggleForm()" class="btn btn-primary btn-sm">Create Room</button>
                        <a href="<c:url value='/room/join' />" class="btn btn-success btn-sm">Join Room</a>
                    </div>
                    
                    <div id="form-container" style="display: none;" class="mt-4">
		        <form:form id="my-form" method="post" action="/room/create" class="mt-4" modelAttribute="room">
		            <div class="mb-3">
		                <label for="roomName" class="form-label">Room Name:</label>
		                <form:input id="name" path="roomName" class="form-control" placeholder="Enter your room name" />
		            </div>
		            <button type="submit" class="btn btn-primary">Submit</button>
		        </form:form>
	    </div>
</div>
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
 <script>
        function toggleForm() {
            var formContainer = document.getElementById('form-container');
            if (formContainer.style.display === 'none') {
                formContainer.style.display = 'block';
                document.getElementById('show-form-button').textContent = 'Hide Form';
            } else {
                formContainer.style.display = 'none';
                document.getElementById('show-form-button').textContent = 'Show Form';
            }
        }
    </script>
</body>
</html>