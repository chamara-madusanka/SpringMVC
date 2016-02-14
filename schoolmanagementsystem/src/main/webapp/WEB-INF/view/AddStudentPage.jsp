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
	<script src="<%=request.getContextPath()%>/resources/jqueryui/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/studentManagement.js"></script>
</head>
<body>
	<!-- navigation bar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse">
				<ul class="nav nav-pills">
					<li class="active navbar-right"><a href="<%=request.getContextPath()%>/student">Back</a></li>
				</ul>
			</div>
		<!-- /.navbar-collapse -->
		</div>
	<!-- /.container-fluid --> 
	</nav>
	
	<!-- Form for adding user -->
	<div class="addUser">
		<div class="headerAddUser">
			<span>ADD STUDENT</span>
		</div>
		<div class="studentForm">
			<c:url value="/student/addstudent" var="addstudent" />
			<form:form class="form-horizontal custom-form-horizontal" role="form" id="addStudentForm" action="addstudent" method="POST">
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">First Name</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="firstname" placeholder="First Name" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="midname" class="col-sm-2 control-label">Mid Name</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="midname" placeholder="Mid Name" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">Last Name</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="lastname" placeholder="Last Name" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="birthdate" class="col-sm-2 control-label">Birth date</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="birthDate" placeholder="Birth date" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="address" class="col-sm-2 control-label">Address</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="address" placeholder="Address" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="grade" class="col-sm-2 control-label">Grade</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="grade" placeholder="Grade" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="class" class="col-sm-2 control-label">Class</label>
					<div class="col-sm-5">
						<input type="text" class="form-control form-control-edited" id="class" placeholder="Class" value="">
					</div>
				</div>
				<button type="submit" class="btn btn-default col-md-2" id="addStudent">Submit</button>
			</form:form>
			<button class="btn btn-default col-md-2" id="cancelAddStudent"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>Cancel</button>
		</div>
	</div>

	<div id="dialog" title="Confirmation Required" hidden>
	  Student is successfully added. Do you want to add another?
	</div>
	<div id="dialogError" title="Error!" hidden>
		Student creation error! Check again.
	</div>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>