<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


   <!--Hero Section-->
    <div class="hero-section hero-background">
        <h1 class="page-title">Organic Fruits</h1>
    </div>

    <!--Navigation section-->
    <div class="container">
        <nav class="biolife-nav">
            <ul>
                <li class="nav-item"><a href="index-2.html" class="permal-link">Home</a></li>
                <li class="nav-item"><span class="current-page">ShoppingCart</span></li>
            </ul>
        </nav>
    </div>

    <div class="page-contain checkout">

        <!-- Main content -->
        <div id="main-content" class="main-content">
            <div class="container sm-margin-top-37px">
                <div class="row">

                    <!--checkout progress box-->
                    <div class="col-lg-7 col-md-7 col-sm-6 col-xs-12">
                        <div class="checkout-progress-wrap">
                            <ul class="steps">
                                <li class="step 1st">
                                    <div class="checkout-act active">
                                        <h3 class="title-box"><span class="number">.</span>Check Out</h3>
                                        <div class="box-content">
                                          
                                            <div class="login-on-checkout">
                                                <form action="/checkout/add" name="frm-login" method="post">
                                               
                                                    
                                                    <p class="form-row">
                                                        <label for="input_email">Phone</label>
                                                        <input type="text" name="phone" id="input_email" value="" placeholder="Phone ?">
                                                    </p>
                                                    <p class="form-row">
                                                        <label for="input_email">Address ?</label>
                                                        <input type="text" name="address" id="input_email" value="" placeholder="Address ?">
                                                    </p>
<br>
                                                     <p class="form-row">
                                                       
                                                        <button type="submit" name="btn-sbmt" class="btn">Payment</button>
                                                    </p>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                              
                            </ul>
                        </div>
                    </div>

                    <!--Order Summary-->
                    <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12 sm-padding-top-48px sm-margin-bottom-0 xs-margin-bottom-15px">
                        <div class="order-summary sm-margin-bottom-80px">
                            <div class="title-block">
                                <h3 class="title">Order Summary</h3>
                                <a href="#" class="link-forward">Edit cart</a>
                            </div>
                            <div class="cart-list-box short-type">
                                <span class="number"> <strong>Tổng : ${SumItem} sản phẩm</strong></span>
                                <ul class="cart-list">
                                
                                
                                <c:forEach var = "e" items="${data}">
                                    <li class="cart-elem">
                                        <div class="cart-item">
                                            <div class="product-thumb">
                                                <a class="prd-thumb" href="#">
                                                    <figure><img src="${pageContext.request.contextPath}/templates/assets/images/products/${e.product.image}" width="113" height="113" alt="shop-cart" ></figure>
                                                </a>
                                            </div>
                                            <div class="info">
                                                <span class="txt-quantity" class="sumSP"  name="qty" >x ${e.quantity}</span> 
                                                <a href="#" class="pr-name">${e.product.name}</a>
                                            </div>
                                            <div class="price price-contain">
                                                 <ins><span class="price-amount"><span class="currencySymbol">£</span>${(e.price * e.quantity)}</span></ins>
<%--                                                 <del><span class="price-amount"><span class="currencySymbol">£</span>${e.price}</span></del> --%>
                                            </div>
                                        </div>
                                    </li>
</c:forEach>
                                </ul>
                                <ul class="subtotal">
                                    <li>
                                        <div class="subtotal-line">
                                            <b class="stt-name">Subtotal</b>
                                            <span class="stt-price">£170.00</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="subtotal-line">
                                            <b class="stt-name">Shipping</b>
                                            <span class="stt-price">£20.00</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="subtotal-line">
                                            <b class="stt-name">Tax</b>
                                            <span class="stt-price">£0.00</span>
                                        </div>
                                    </li>
                                    
                                    <li>
                                        <div class="subtotal-line">
                                            <b class="stt-name">total:</b>
                                            <span class="stt-price">£ ${SumPrice}</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
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