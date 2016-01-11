<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="true" %>
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
	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<!-- csrf for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

	<!-- navigation bar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="collapse navbar-collapse">
				<ul class="nav nav-pills">
					<li class="active"><a href="<%=request.getContextPath()%>/student">Student management<span class="sr-only">(current)</span></a></li>
					<li class="dropdown active"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Staff management</a>
						<ul class="dropdown-menu">
							<li><a href="#">Academic staff</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Non-Academic staff</a></li>
						</ul>
					</li>
					<li class="active"><a href="#">Events management</a></li>
					<li class="active"><a href="#">Grade Management</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li class="active"><a href="<%=request.getContextPath()%>/user">User Management<span class="sr-only">(current)</span></a></li>
					</sec:authorize>
					<li class="dropdown active navbar-right"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
						${pageContext.request.userPrincipal.name}</a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="glyphicon glyphicon-cog"></i> Settings</a></li>
							<li role="separator" class="divider"></li>
							<li>
				            	<c:if test="${pageContext.request.userPrincipal.name != null}">
									<a href="javascript:formSubmit()"><span class="glyphicon glyphicon-log-out"></span>
									Logout</a>
								</c:if>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		<!-- /.navbar-collapse -->
		</div>
	<!-- /.container-fluid --> 
	</nav>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>