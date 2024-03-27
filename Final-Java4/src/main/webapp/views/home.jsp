<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to My Website</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
	integrity="sha384-p8+Wfdi32ZsNFoZbAxLthvsXarQ//FZY7V0aztR0a7voE8Wwwq3hVGRa0rRsFcON"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 10px">
			<h1>Welcome to My Website</h1>
			<a type="submit"
				href="<c:url value='/Logout?id=${logs.get(logs.size()-1).getLog_id()}'/>" 
				style="margin-left: 20px; width: 80px; height: 50px;"
				class="btn btn-primary">Logout</a>
		</div>
		<p>Hello, ${username }</p>
		<h2>Log Records</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Log ID</th>
					<th>User Name</th>
					<th>Logged In Time</th>
					<th>Logged Out Time</th>
				</tr>
			</thead>
			<tbody>
				<%-- <tr>
            <td>${ log.logid} </td>
            <td>${ log.username} </td>
            <td>${log.loggedintime }</td>
            <td>${ log.loggedouttime} </td>
          </tr> --%>

				<c:forEach items="${logs}" var="log">
					<tr>
						<td>${ log.log_id}</td>
						<td>${ log.user.username}</td>
						<td>${log.login_time }</td>
						<td>${ log.logout_time}</td>
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
