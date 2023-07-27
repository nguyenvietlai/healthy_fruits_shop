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
                <li class="nav-item"><span class="current-page">RersetPassword</span></li>
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
                            <form action="/rersetpass/update" name="frm-login" method="post">
                             <input type="hidden"  name="email" value="${email}" class="txt-input">
                                <p class="form-row">
                                    <label for="fid-name">New Password:<span class="requite">*</span></label>
                                    <input type="text" id="fid-name" name="password" value="" class="txt-input">
                                </p>
                                <p class="form-row">
                                    <label for="fid-name">Confirm  New Password:<span class="requite">*</span></label>
                                    <input type="text" id="fid-name" name="confirmpass" value="" class="txt-input">
                                </p>
                                   <p class="form-row">
                                    <label for="fid-name">${mess}</label>
                                </p>
                                <p class="form-row wrap-btn">
                                    <button formaction="/rersetpass/update" class="btn btn-submit btn-bold" type="submit">Update</button>
                                    <a href="/login.php" class="link-to-help">Back to Login</a>
                                </p>
                            </form>
                        </div>
                    </div>

                    <!--Go to Register form-->
<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="register-in-container">
                           <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                class="img-fluid" alt="Sample image">
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



</body>
</html>