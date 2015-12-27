<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>School managment system</title>
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
		rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css"
		rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/signin.css"
		rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js" /></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js" /></script>
</head>
<body>
	<h1>${headerMessage}</h1>
	<div class="container">
		<c:url value="/j_spring_security_check" var="loginUrl" />
		<form class="form-signin" action="${loginUrl}" method='POST'>
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" class="form-control" placeholder="Username" required=""
					autofocus="" name="username"> 
			<input type="password" id="inputPassword" class="form-control" placeholder="Password"
					required="" name="password">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">Remember me</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>