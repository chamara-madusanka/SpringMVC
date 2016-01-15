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
	<link href="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.structure.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.theme.min.css" rel="stylesheet">

	<!-- JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/userManagement.js"></script>
	<script src="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.min.js"></script>
</head>
<body>
	<!-- navigation bar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse">
				<ul class="nav nav-pills">
					<li class="active navbar-right"><a href="<%=request.getContextPath()%>/user">Back</a></li>
				</ul>
			</div>
		<!-- /.navbar-collapse -->
		</div>
	<!-- /.container-fluid --> 
	</nav>
	
	<!-- Form for adding user -->
	<div class="addUser">
		<div class="headerAddUser">
			<span>ADD USER</span>
		</div>
		<div class="userForm">
			<c:url value="/user/adduser" var="addUser" />
			<form:form class="form-horizontal custom-form-horizontal" role="form" id="searchForm" action="adduser" method="POST">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">User Name</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="username" placeholder="Username" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-5">
						<input type="password" class="form-control form-control-edited" id="password" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="role">Role</label>
					<div class="col-sm-5">
						<select id="userrole" class="form-control form-control-edited">
							<option disabled="disabled" selected="selected">Select an option</option>
							<option>ROLE_ADMIN</option>
							<option>ROLE_STUDENT</option>
							<option>ROLE_TEACHER</option>
						</select> 
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="role">Enabled</label>
					<div class="col-sm-5">
						<select id="enabled" class="form-control form-control-edited" name="enabled">
							<option disabled="disabled" selected="selected">Select an option</option>
							<option>true</option>
							<option>false</option>
						</select> 
					</div>
				</div>
				<button type="submit" class="btn btn-default col-md-2" id="addUser">Submit</button>
			</form:form>
			<button class="btn btn-default col-md-2" id="cancelAddUser"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>Cancel</button>
		</div>
	</div>

	<div id="dialog" title="Confirmation Required" hidden>
	  User is successfully added. Do you want to add another?
	</div>
	<div id="dialogError" title="Error!" hidden>
		User creation error! Check again.
	</div>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>