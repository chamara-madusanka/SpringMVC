<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<title>School management system</title>

	<!-- CSS -->
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/bootstrap/css/font-awesome.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet">

	<!-- JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/userManagement.js"></script>
</head>
<body>
	<!-- navigation bar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse">
				<ul class="nav nav-pills">
					<li class="active"><a href="<%=request.getContextPath()%>/user/adduser">
						Add user<span class="sr-only">(current)</span></a>
					</li>
					<li class="active navbar-right"><a href="<%=request.getContextPath()%>/home">Home</a></li>
				</ul>
			</div>
		<!-- /.navbar-collapse -->
		</div>
	<!-- /.container-fluid --> 
	</nav>	
	
	<!-- Form for adding user -->
	<div class="addUser">
		<h3>Add user</h3>
		<div>
			<c:url value="/user/adduser" var="addUser" />
			<form:form class="form-horizontal custom-form-horizontal" role="form" id="searchForm">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">User Name</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="name" name="name" placeholder="Username" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="password" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<label for="enabled" class="col-sm-2 control-label">Enabled</label>
					<div class="col-sm-2">
						<label>Yes<input type="checkbox" id="enabled"></label>
					</div>
					<div class="col-sm-2">
						<label>No<input type="checkbox" id="enabled"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="role">Role</label>
					<div class="col-sm-3">
						<select id="role" class="form-control">
							<option>ROLE_ADMIN</option>
							<option>ROLE_USER</option>
							<option>ROLE_TEACHER</option>
						</select> 
					</div>
				</div>
				<button type="submit" class="btn btn-default col-md-1">Submit</button>
			</form:form>
		</div>
	</div>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>