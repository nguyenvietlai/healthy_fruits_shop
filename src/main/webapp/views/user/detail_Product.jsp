<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <li class="nav-item"><a href="#" class="permal-link">Natural Organic</a></li>
                <li class="nav-item"><span class="current-page">Fresh Fruit</span></li>
            </ul>
        </nav>
    </div>

    <div class="page-contain single-product">
        <div class="container">

            <!-- Main content -->
            <div id="main-content" class="main-content">
                
                <!-- summary info -->
                <div class="sumary-product single-layout">
                    <div class="media">
                        <ul class="biolife-carousel slider-for" data-slick='{"arrows":false,"dots":false,"slidesMargin":30,"slidesToShow":1,"slidesToScroll":1,"fade":true,"asNavFor":".slider-nav"}'>
                            
                            <c:forEach var="e" items="${product_item.imagesofproducts }">
                           				 <li><img src="${pageContext.request.contextPath}/templates/assets/images/${e.image}" alt="" width="500" height="500"></li>
							</c:forEach>
                        
                        </ul>
                        <ul class="biolife-carousel slider-nav" data-slick='{"arrows":false,"dots":false,"centerMode":false,"focusOnSelect":true,"slidesMargin":10,"slidesToShow":4,"slidesToScroll":1,"asNavFor":".slider-for"}'>
                            
                            <c:forEach var="e" items="${product_item.imagesofproducts }">
                           			 <li><img src="${pageContext.request.contextPath}/templates/assets/images/${e.image}" alt="" width="88" height="88"></li>
                           	</c:forEach>
                       
                        </ul>
                    </div>
                    <div class="product-attribute">
                        <h3 class="title">${product_item.name }</h3>
                        <div class="rating">
                            <p class="star-rating"><span class="width-80percent"></span></p>
                            <span class="review-count">(1005 Reviews)</span>
                            <span class="qa-text">Q&amp;A</span>
                            <b class="category">By: Natural food</b>
                        </div>
                        <span class="sku">Category: ${product_item.category.name }</span>
                        <p class="excerpt">
                        ${product_item.description }
                       </p>
                        <div class="price">
                            <ins><span class="price-amount"><span class="currencySymbol">đ </span>${product_item.price }</span></ins>
                        </div>
                        <div class="shipping-info">
                            <p class="shipping-day">3-Day Shipping</p>
                            <p class="for-today">Pree Pickup Today</p>
                        </div>
                    </div>
                    <div class="action-form">
             
                        <div class="buttons">
                            <a onclick="addToCart('${product_item.id}')" class="btn add-to-cart-btn">add to cart</a>
                            <p class="pull-row">
                                <a href="#" class="btn wishlist-btn">wishlist</a>
                                <a href="#" class="btn compare-btn">compare</a>
                            </p>
                        </div>
                    
                        <div class="social-media">
                            <ul class="social-list">
                                <li><a href="#" class="social-link"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="social-link"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="social-link"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="social-link"><i class="fa fa-share-alt" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="social-link"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    
                    </div>
                </div>

               

                <!-- related products -->
                <div class="product-related-box single-layout">
                    <div class="biolife-title-box lg-margin-bottom-26px-im">
                        <span class="biolife-icon icon-organic"></span>
                        <span class="subtitle">All the best item for You</span>
                        <h3 class="main-title">Related Products</h3>
                    </div>
                    <ul class="products-list biolife-carousel nav-center-02 nav-none-on-mobile" data-slick='{"rows":1,"arrows":true,"dots":false,"infinite":false,"speed":400,"slidesMargin":0,"slidesToShow":5, "responsive":[{"breakpoint":1200, "settings":{ "slidesToShow": 4}},{"breakpoint":992, "settings":{ "slidesToShow": 3, "slidesMargin":20 }},{"breakpoint":768, "settings":{ "slidesToShow": 2, "slidesMargin":10}}]}'>
							<c:forEach var="e" items="${products }">
					                        <li class="product-item">
					                            <div class="contain-product layout-default">
					                                <div class="product-thumb">
					                                    <a href="#" class="link-to-product">
					                                        <img src="${pageContext.request.contextPath}/templates/assets/images/${e.image}" alt="dd" width="270" height="270" class="product-thumnail">
					                                    </a>
					                                </div>
					                                <div class="info">
					                                    <b class="categories">Fresh Fruit</b>
					                                    <h4 class="product-title"><a href="#" class="pr-name">${e.name}</a></h4>
					                                    <div class="price">
					                                        <ins><span class="price-amount"><span class="currencySymbol">£</span>${e.price}</span></ins>
					                                        <del><span class="price-amount"><span class="currencySymbol">£</span>95.00</span></del>
					                                    </div>
					                                    <div class="slide-down-box">
					                                        <p class="message">All products are carefully selected to ensure food safety.</p>
					                                        <div class="buttons">
					                                            <a href="#" class="btn wishlist-btn"><i class="fa fa-heart" aria-hidden="true"></i></a>
					                                            <a onclick="addToCart('${e.id}')" class="btn add-to-cart-btn"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i>add to cart</a>
					                                            <a href="#" class="btn compare-btn"><i class="fa fa-random" aria-hidden="true"></i></a>
					                                        </div>
					                                    </div>
					                                </div>
					                            </div>
					                        </li>
                        			</c:forEach>
                    </ul>
                </div>
                
            </div>
        </div>
    </div>
        	         
        	
        	
        	
        	<%@include file="/views/user/footer.jsp"%>
    <!-- Scroll Top Button -->
    <a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>

<%@include file="/commons/user-script.jsp"%>
<script type="text/javascript">
function addToCart(id){
	alert(id);
	$.get("/cart/add/"+id, function(data, status){location.reload();});
	
}
</script>
</body>
</html>