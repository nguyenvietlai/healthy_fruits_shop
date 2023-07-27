<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        	
        	
        	   <!-- Main content -->
    <div class="page-contain page-404">

        <div id="main-content" class="main-content">
            <div class="container">

                <div class="row">

                    <div class="content-404">
                        <h1 class="heading">404</h1>
                        <h2 class="title">Oops! That page can't be found.</h2>
                        <p>Sorry, but the page you are looking for is not found. Please, make sure you have typed the current URL.</p>
                        <a class="button" href="index-2.html">Go to Home</a>
                    </div>

                </div>

            </div>

        </div>

    </div>
        	
        	
        	<%@include file="/views/user/footer.jsp"%>
    <!-- Scroll Top Button -->
    <a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>

<%@include file="/commons/user-script.jsp"%>
</body>
</html>