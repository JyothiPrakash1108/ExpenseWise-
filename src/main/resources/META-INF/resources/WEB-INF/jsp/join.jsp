<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Join Room</title>
</head>
<body>
<%@include file="header.jspf" %>
	<div class="container mt-5">
		<div class="mt-4">
        <input id="searchInput" class="form-control me-2" type="search" placeholder="Search by Room ID" aria-label="Search">
    </div>
		<!-- List of rooms -->
		<c:choose>
			<c:when test="${not empty rooms }">
				<table class="table table-bordered table-striped mt-3">
					<thead>
						<tr>
							<td>Room Id</td>
							<td>Room Name</td>
							<td></td>
						</tr>
					</thead>
					<tbody id="roomTableBody">
						<c:forEach var="room" items="${rooms}">
						<tr>
							<td class="roomId">${room.id}</td>
							<td>${room.roomName}</td>
							<td>
								<a href="<c:url value='join-room?id=${room.id}' />" class="btn btn-success btn-sm">Join</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="text-center mt-5">
					<h4>No Rooms available	</h4>
				</div>
			</c:otherwise>
		</c:choose>
		
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

<script>
$(document).ready(function() {
    $("#searchInput").on("keyup", function() {
        var searchValue = $(this).val().toLowerCase();
        console.log("Search Value: ", searchValue);
        
        $("#roomTableBody tr").each(function() {
            var roomIdText = $(this).find(".roomId").text().toLowerCase();
            console.log("Checking Room ID: ", roomIdText);
            $(this).toggle(roomIdText.indexOf(searchValue) > -1);
        });
    });
});

</script>
</body>
</html>