<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact</title>

</head>
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

	<!-- /////////////////////////////////////////////////  -->

	<div class="container">
		<h1>Edit Profile</h1>


		<hr>

		<div class="row">
			<form:form action="/profile/update" method="POST"
				modelAttribute="account" class="form-horizontal" enctype="multipart/form-data">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">
						<img
							src="${pageContext.request.contextPath}/templates/assets/images/${username.photo}"
							class="avatar img-circle" alt="avatar">
				${username.photo}
						<h6>Upload a different photo...</h6>
						<input type="file" required="required" class="form-control"
							name="image" />
					</div>
				</div>

				<!-- edit form column -->
				<div class="col-md-9 personal-info">
					<h3>Personal info</h3>
					<h2>User: ${username.fullname } </h2>

					<div class="form-group">
						<form:input type="hidden" required="required" class="form-control"
							path="id" value="${username.id}" />
							
						<form:input type="hidden" required="required" value="1"
							class="form-control" path="activated" />
							
						<form:input type="hidden" required="required" value="0"
							class="form-control" path="admin" />
						<form:input path="username" class="form-control" type="hidden"
								value="${username.username}"/>
								
						<form:input path="password" class="form-control" type="hidden" />
								
						<label class="col-lg-3 control-label">Full name:</label>
						<div class="col-lg-8">
							<form:input type="text" required="required" class="form-control"
								path="fullname" value="${username.fullname}"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-3 control-label">Email:</label>
						<div class="col-lg-8">
							<form:input path="email" class="form-control" type="text" value="${username.email}"/>
						</div>
					</div>

					
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<button class="btn btn-success" type="submit">Update</button>
							<a class="btn btn-success" type="button" href="/home.php" >Cancel</a>
							<h3>${mess}</h3>
						</div>
					</div>
				</div>
			</form:form>

		</div>
	</div>

	<hr>

	<!-- /////////////////////////////////////////////////  -->
	<%@include file="/views/user/footer.jsp"%>
<!-- Scroll Top Button -->
	<a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>

	<%@include file="/commons/user-script.jsp"%>
</body>
</html>