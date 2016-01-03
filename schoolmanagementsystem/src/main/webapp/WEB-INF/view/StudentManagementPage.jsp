<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
			<form class="form-horizontal custom-form-horizontal" role="form">
				<div class="row">
					<div class="form-group col-md-4 ">
					  <input class="form-control" type="text" placeholder="First name">
					</div>
					<div class="form-group col-md-4 box">
					  <input class="form-control" type="text" placeholder="Last name">
					</div>
					<div class="form-group col-md-4 box">
					  <input class="form-control" type="text" placeholder="Mid name">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
					  <input class="form-control" type="text" placeholder="Student ID">
					</div>
					<div class="form-group col-md-4">
					  <input class="form-control" type="text" placeholder="Grade">
					</div>
					<div class="form-group col-md-4">
					  <input class="form-control" type="text" placeholder="Class">
					</div>
				</div>
       			<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>Search</button>
       			<button class="btn btn-primary"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>Cancel</button>
			</form>
		</div>
		<h3>Students List</h3>
		<c:if test="${!empty studentList}">
			<div class="table-responsive">
			    <table class="table table-bordered">
				    <tr>
				        <th width="80">Student ID</th>
				        <th width="120">First Name</th>
						<th width="120">Mid Name</th>
						<th width="120">Last Name</th>
				        <th width="120">Birthdate</th>
						<th width="120">Address</th>
				        <th width="60">Grade</th>
				        <th width="60">Class</th>
				    </tr>
				    <c:forEach items="${studentList}" var="student">
				        <tr>
				            <td>${student.studentID}</td>
				            <td>${student.firstName}</td>
				            <td>${student.midName}</td>
							<td>${student.lastName}</td>
				            <td>${student.birthdate}</td>
				            <td>${student.address}</td>
							<td>${student.grade}</td>
				            <td>${student.gradeClass}</td>
				            <td><a href="<c:url value='#' />" >Edit</a></td>
				            <td><a href="<c:url value='#' />" >Delete</a></td>
				        </tr>
				    </c:forEach>
			    </table>
			</div>
		</c:if>
	</div>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>