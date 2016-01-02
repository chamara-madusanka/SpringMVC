<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<form>
		  <div class="form-group row">
		    <label for="inputEmail3" class="col-sm-2 form-control-label">Email</label>
		    <div class="col-sm-10">
		      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="inputPassword3" class="col-sm-2 form-control-label">Password</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label class="col-sm-2">Radios</label>
		    <div class="col-sm-10">
		      <div class="radio">
		        <label>
		          <input type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
		          Option one is this and that&mdash;be sure to include why it's great
		        </label>
		      </div>
		      <div class="radio">
		        <label>
		          <input type="radio" name="gridRadios" id="gridRadios2" value="option2">
		          Option two can be something else and selecting it will deselect option one
		        </label>
		      </div>
		      <div class="radio disabled">
		        <label>
		          <input type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
		          Option three is disabled
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label class="col-sm-2">Checkbox</label>
		    <div class="col-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox"> Check me out
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group row">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-secondary">Sign in</button>
		    </div>
		  </div>
		</form>
	</div>
	
	<!-- Footer -->
	 <div class="footer navbar-fixed-bottom">
	    <div class="footer-content">Developed By Chamara Jayalath</div>
  	</div>
</body>
</html>