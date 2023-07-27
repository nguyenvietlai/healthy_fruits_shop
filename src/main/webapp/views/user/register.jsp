<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@include file="/commons/user-css.jsp"%>
</head>
<body>
	<!-- Preloader -->
	<div id="biof-loading">
		<div class="biof-loading-center">
			<div class="biof-loading-center-absolute">
				<div class="dot dot-one"></div>
				<div class="dot dot-two"></div>
				<div class="dot dot-three"></div>
			</div>
		</div>
	</div>

	<%@include file="/views/user/header.jsp"%>


	<!--Hero Section-->
	<div class="hero-section hero-background">
		<h1 class="page-title">Organic Fruits</h1>
	</div>

	<!--Navigation section-->
	<div class="container">
		<nav class="biolife-nav">
			<ul>
				<li class="nav-item"><a href="home.php" class="permal-link">Home</a></li>
				<li class="nav-item"><span class="current-page">Register</span></li>
			</ul>
		</nav>
	</div>

	<div class="page-contain login-page">

		<!-- Main content -->
		<div id="main-content" class="main-content">
			<div class="container">

				<div class="row">



					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="signin-container">
							 <form:form action="/register.php" name="frm-login" method="post" modelAttribute = "register">

								<p class="form-row">
									<label for="fid-name">Username:<span class="requite">*</span></label>
									<form:input type="text" id="fid-name" path="username" value=""
										class="txt-input"></form:input>
										<form:errors path="username" cssClass="text-danger"></form:errors>
								</p>
								
								 <p class="form-row">
									<label for="fid-name">FullName:<span class="requite">*</span></label>
									<form:input  type="text" id="fid-name" path="fullname" value=""
										class="txt-input"></form:input>
										<form:errors path="fullname" cssClass="text-danger"></form:errors>
								</p>
								
								<p class="form-row">
									<label for="fid-pass">Password:<span class="requite">*</span></label>
									<form:input type="password" id="fid-pass" path="password" value=""
										class="txt-input"></form:input>
										<form:errors path="password" cssClass="text-danger"></form:errors>
								</p>
								
								<p class="form-row">
									<label for="fid-pass">Confirm Password:<span
										class="requite">*</span></label> 
										<input type="password" id="fid-pass"
										name="comfirm_password" value="" class="txt-input">
										
								</p>
								
								<p class="form-row">
									<label for="fid-name">Email Address:<span
										class="requite">*</span></label> <form:input type="email" id="fid-name"
										path="email" value="" class="txt-input"></form:input>
										<form:errors path="email" cssClass="text-danger"></form:errors>
								</p> 
							
						
								
								<p class="form-row wrap-btn">
									<form:button class="btn btn-submit btn-bold" type="submit">Register</form:button>
									<a href="forgot.php" class="link-to-help">Forgot your
										password</a>
								</p>



							</form:form>
						</div>
					</div>


					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="register-in-container">
							<img
								src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
								class="img-fluid" alt="Sample image">
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>







	<%@include file="/views/user/footer.jsp"%>

	<a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>
	<%@include file="/commons/user-script.jsp"%>

<c:if test="${success != null }">
<script type="text/javascript">

alertMessage("Please check your email !");
</script>
</c:if>

</body>
</html>