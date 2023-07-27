<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
				<li class="nav-item"><span class="current-page">Login</span></li>
			</ul>
		</nav>
	</div>

	<div class="page-contain login-page">

		<!-- Main content -->
		<div id="main-content" class="main-content">
			<div class="container">

				<div class="row">

					<!--Form Sign In-->
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="signin-container">
							<form action="login.php" name="frm-login" method="post">
								<p class="form-row">
									<label for="fid-name">Username:<span class="requite">*</span></label>
									<input type="text" id="fid-name" name="name" value=""
										class="txt-input">
								</p>
								<p class="form-row">
									<label for="fid-pass">Password:<span class="requite">*</span></label>
									<input type="password" id="fid-pass" name="pass" value=""
										class="txt-input">
								</p>
								<p class="form-row wrap-btn">
									<button class="btn btn-submit btn-bold" type="submit">sign
										in</button>
									<a href="forgot.php" class="link-to-help">Forgot your
										password</a>
								</p>
							</form>
						</div>
					</div>

					<!--Go to Register form-->
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="register-in-container">
							<div class="intro">
								<h4 class="box-title">New Customer?</h4>
								<p class="sub-title">Create an account with us and you’ll be
									able to:</p>
								<ul class="lis">
									<li>Check out faster</li>
									<li>Save multiple shipping anddesses</li>
									<li>Access your order history</li>
									<li>Track new orders</li>
									<li>Save items to your Wishlist</li>
								</ul>
								<a href="register.php" class="btn btn-bold">Create an
									account</a>
							</div>
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>





	<%@include file="/views/user/footer.jsp"%>

	<a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>
	<%@include file="/commons/user-script.jsp"%>

	<c:if test="${param.error != null }">
		<script type="text/javascript">
			alertMessage("${param.error}");
		</script>
	</c:if>

</body>
</html>