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
</head>
<body>
	<!-- navigation bar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse">
				<ul class="nav nav-pills">
					<li class="active"><a href="#">Add student<span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="#">Student marks</a></li>
					<li class="active navbar-right"><a href="<%=request.getContextPath()%>/home">Home</a></li>
				</ul>
			</div>
		<!-- /.navbar-collapse -->
		</div>
	<!-- /.container-fluid --> 
	</nav>
	
	<div class="student-search">
		<h3>Search Students</h3>
		<div>
			<c:url value="/searchstudent" var="searchstudent" />
			<form:form class="form-horizontal custom-form-horizontal" role="form" id="searchForm">
				<div class="row">
					<div class="form-group col-md-4 ">
					  <input class="form-control" type="text" placeholder="First name" id="firstName">
					</div>
					<div class="form-group col-md-4 box">
					  <input class="form-control" type="text" placeholder="Last name" id="lastName">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
					  <input class="form-control" type="text" placeholder="Grade" id="grade">
					</div>
					<div class="form-group col-md-4">
					  <input class="form-control" type="text" placeholder="Class" id="gradeClass">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
					  <input class="form-control" type="text" placeholder="Student ID" id="studentID">
					</div>
				</div>
       			<button type="submit" class="btn btn-primary" id="searchButton"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>Search</button>
			</form:form>
			<button class="btn btn-primary" id="clearAllButton"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>clear All</button>
		</div>
		<h3>Students List</h3>
		<div class="table-responsive">
		    <table class="table table-bordered hidden" id="searchTable"></table>
		</div>
	</div>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>