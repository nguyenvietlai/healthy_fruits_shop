<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<div class="hero-section hero-background">
		<h1 class="page-title">Organic Fruits</h1>
	</div>

	<!--Navigation section-->
	<div class="container">
		<nav class="biolife-nav">
			<ul>
				<li class="nav-item"><a href="home.php" class="permal-link">Home</a></li>
				<li class="nav-item"><span class="current-page">Product</span></li>
			</ul>
		</nav>
	</div>



	<div class="page-contain category-page right-sidebar ">
		<div class="container">
			<div class="row">
				<!-- Main content -->
				<div id="main-content"
					class="main-content col-lg-9 col-md-8 col-sm-12 col-xs-12">

					<div class="block-item recently-products-cat md-margin-bottom-39">
						<ul
							class="products-list biolife-carousel nav-center-02 nav-none-on-mobile"
							data-slick='{"rows":1,"arrows":true,"dots":false,"infinite":false,"speed":400,"slidesMargin":0,"slidesToShow":5, "responsive":[{"breakpoint":1200, "settings":{ "slidesToShow": 3}},{"breakpoint":992, "settings":{ "slidesToShow": 3, "slidesMargin": 10}},{"breakpoint":768, "settings":{ "slidesToShow": 2, "slidesMargin":10 }}]}'>

							<c:forEach var="data" items="${products}">
								<li class="product-item">
									<div class="contain-product layout-02">
										<div class="product-thumb">
											<a href="#" class="link-to-product"> <img
												src="${pageContext.request.contextPath}/templates/assets/images/${data.image}"
												alt="dd" width="270" height="270" class="product-thumnail">
											</a>
										</div>
										<div class="info">
											<b class="categories"></b>
											<h4 class="product-title">
												<a href="#" class="pr-name">${data.name}</a>
											</h4>
											<div class="price">
												<ins>
													<span class="price-amount"><span
														class="currencySymbol">£</span> <fmt:formatNumber
															pattern="#,##0"
															value="${data.price-(data.price*data.discount) }" /></span>
												</ins>
												<c:if test="${data.discount != 0 }">
													<del>
														<span class="price-amount"><span
															class="currencySymbol">£</span>${data.price}</span>
													</del>
												</c:if>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>

					<div class="product-category list-style">

						<div id="top-functions-area" class="top-functions-area">
							<div class="flt-item to-left group-on-mobile">
								<span class="flt-title"></span> <a href="#"
									class="icon-for-mobile"> <span></span> <span></span> <span></span>
								</a>
								<div class="wrap-selectors">
									<form action="/show-products-discount" name="frm-refine"
										method="get">
										<span class="title-for-mobile">Refine Products By</span>
										<div data-title="Price:" class="selector-item">
											<select name="status" class="selector"
												onchange="this.form.submit()"  >
												<option ${tenz == null ? 'selected="selected"':'' }   value="all">Tất cả sản phẩm</option>
												<option ${tenz == null ? '': 'selected="selected"' }  value="ten">Top 10 hàng giảm giá</option>
											</select>
										</div>
										<p class="btn-for-mobile">
											<button type="submit" class="btn-submit">Go</button>
										</p>
									</form>
								</div>
								
										<div class="wrap-selectors">
									<form action="/show-products-by-cate" name="frm-refine"
										method="get">
										<span class="title-for-mobile">Refine Products By</span>
										<div data-title="Price:" class="selector-item">
											<select name="category" class="selector"
												onchange="this.form.submit()"  >
												<option ${cate == null ? 'selected="selected"':'' }   value="-1">Tất cả loại hàng</option>
												<c:forEach var="e" items="${categories }">
												<option  ${cate == e.id ? 'selected="selected"':'' }   value="${e.id }">${e.name }</option>
												</c:forEach>
												
											</select>
										</div>
										<p class="btn-for-mobile">
											<button type="submit" class="btn-submit">Go</button>
										</p>
									</form>
								</div>
								
								
							</div>
							<div class="flt-item to-right">
								<span class="flt-title">Sort</span>
								<div class="wrap-selectors">
									<div class="selector-item orderby-selector">
										<select name="orderby" class="orderby" aria-label="Shop order"
											onchange="sort_price(this)">
											<option value="default" selected="selected">Default
												sorting</option>
											<option value="ascending">price: low to high</option>
											<option value="decending">price: high to low</option>
										</select>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<ul id="product" class="products-list">

								<c:forEach var="data" items="${products}">
									<li
										class="product-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="contain-product pr-detail-layout">
											<div class="product-thumb">
												<a href="#" class="link-to-product"> <img
													src="${pageContext.request.contextPath}/templates/assets/images/${data.image}"
													alt="dd" width="270" height="270" class="product-thumnail">
												</a>
											</div>
											<div class="info">
												<b class="categories">Fresh Fruit</b>
												<h4 class="product-title">
													<a href="/product/detailProduct/${data.id }" class="pr-name">${data.name}</a>
												</h4>
												<p class="excerpt">${data.description}.</p>
												<div class="price">
													<ins>
														<span class="price-amount"><span
															class="currencySymbol">£</span> <fmt:formatNumber
																pattern="#,##0"
																value="${data.price-(data.price*data.discount) }" /></span>
													</ins>
													<c:if test="${data.discount != 0 }">
														<del>
															<span class="price-amount"><span
																class="currencySymbol">£</span>${data.price}</span>
														</del>
													</c:if>
												</div>
												<div class="buttons">
													<a href="#" class="btn wishlist-btn"><i
														class="fa fa-heart" aria-hidden="true"></i></a> <a
														onclick="addToCart('${data.id}')" class="btn add-to-cart-btn">add
														to cart</a> <a href="#" class="btn compare-btn"><i
														class="fa fa-random" aria-hidden="true"></i></a>
												</div>
											</div>
											<div class="advance-info">

												<div class="shipping-info">
													<p class="shipping-day">${data.description == null ? 'vip product':data.description }</p>
												</div>
											</div>
										</div>
									</li>

								</c:forEach>
							


								<%-- <li class="product-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="contain-product pr-detail-layout">
                                        <div class="product-thumb">
                                            <a href="#" class="link-to-product">
                                                <img src="${pageContext.request.contextPath}/templates/assets/images/products/p-13.jpg" alt="dd" width="270" height="270" class="product-thumnail">
                                            </a>
                                        </div>
                                        <div class="info">
                                            <b class="categories">Fresh Fruit</b>
                                            <h4 class="product-title"><a href="#" class="pr-name">Organic 10 Assorted Flavors Jelly Beans, 5.5 Oz</a></h4>
                                            <p class="excerpt">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel maximus lacus. Duis ut mauris eget justo dictum tempus sed vel tellus.</p>
                                            <div class="price">
                                                <ins><span class="price-amount"><span class="currencySymbol">£</span>85.00</span></ins>
                                                <del><span class="price-amount"><span class="currencySymbol">£</span>95.00</span></del>
                                            </div>
                                            <div class="buttons">
                                                <a href="#" class="btn wishlist-btn"><i class="fa fa-heart" aria-hidden="true"></i></a>
                                                <a href="#" class="btn add-to-cart-btn">add to cart</a>
                                                <a href="#" class="btn compare-btn"><i class="fa fa-random" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="advance-info">
                                            <ul class="list">
                                                <li>100% real fruit ingredients</li>
                                                <li>All Sugar comes naturally</li>
                                                <li>Non-GMO Project Verified</li>
                                            </ul>
                                            <div class="shipping-info">
                                                <p class="shipping-day">3-Day Shipping</p>
                                                <p class="for-today">Pree Pickup Today</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="product-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="contain-product pr-detail-layout">
                                        <div class="product-thumb">
                                            <a href="#" class="link-to-product">
                                                <img src="${pageContext.request.contextPath}/templates/assets/images/products/p-14.jpg" alt="dd" width="270" height="270" class="product-thumnail">
                                            </a>
                                        </div>
                                        <div class="info">
                                            <b class="categories">Fresh Fruit</b>
                                            <h4 class="product-title"><a href="#" class="pr-name">Organic 10 Assorted Flavors Jelly Beans, 5.5 Oz</a></h4>
                                            <p class="excerpt">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel maximus lacus. Duis ut mauris eget justo dictum tempus sed vel tellus.</p>
                                            <div class="price">
                                                <ins><span class="price-amount"><span class="currencySymbol">£</span>85.00</span></ins>
                                                <del><span class="price-amount"><span class="currencySymbol">£</span>95.00</span></del>
                                            </div>
                                            <div class="buttons">
                                                <a href="#" class="btn wishlist-btn"><i class="fa fa-heart" aria-hidden="true"></i></a>
                                                <a href="#" class="btn add-to-cart-btn">add to cart</a>
                                                <a href="#" class="btn compare-btn"><i class="fa fa-random" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="advance-info">
                                            <ul class="list">
                                                <li>100% real fruit ingredients</li>
                                                <li>All Sugar comes naturally</li>
                                                <li>Non-GMO Project Verified</li>
                                            </ul>
                                            <div class="shipping-info">
                                                <p class="shipping-day">3-Day Shipping</p>
                                                <p class="for-today">Pree Pickup Today</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="product-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="contain-product pr-detail-layout">
                                        <div class="product-thumb">
                                            <a href="#" class="link-to-product">
                                                <img src="${pageContext.request.contextPath}/templates/assets/images/products/p-17.jpg" alt="dd" width="270" height="270" class="product-thumnail">
                                            </a>
                                        </div>
                                        <div class="info">
                                            <b class="categories">Fresh Fruit</b>
                                            <h4 class="product-title"><a href="#" class="pr-name">Organic 10 Assorted Flavors Jelly Beans, 5.5 Oz</a></h4>
                                            <p class="excerpt">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel maximus lacus. Duis ut mauris eget justo dictum tempus sed vel tellus.</p>
                                            <div class="price">
                                                <ins><span class="price-amount"><span class="currencySymbol">£</span>85.00</span></ins>
                                                <del><span class="price-amount"><span class="currencySymbol">£</span>95.00</span></del>
                                            </div>
                                            <div class="buttons">
                                                <a href="#" class="btn wishlist-btn"><i class="fa fa-heart" aria-hidden="true"></i></a>
                                                <a href="#" class="btn add-to-cart-btn">add to cart</a>
                                                <a href="#" class="btn compare-btn"><i class="fa fa-random" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="advance-info">
                                            <ul class="list">
                                                <li>100% real fruit ingredients</li>
                                                <li>All Sugar comes naturally</li>
                                                <li>Non-GMO Project Verified</li>
                                            </ul>
                                            <div class="shipping-info">
                                                <p class="shipping-day">3-Day Shipping</p>
                                                <p class="for-today">Pree Pickup Today</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="product-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="contain-product pr-detail-layout">
                                        <div class="product-thumb">
                                            <a href="#" class="link-to-product">
                                                <img src="${pageContext.request.contextPath}/templates/assets/images/products/p-08.jpg" alt="dd" width="270" height="270" class="product-thumnail">
                                            </a>
                                        </div>
                                        <div class="info">
                                            <b class="categories">Fresh Fruit</b>
                                            <h4 class="product-title"><a href="#" class="pr-name">Organic 10 Assorted Flavors Jelly Beans, 5.5 Oz</a></h4>
                                            <p class="excerpt">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel maximus lacus. Duis ut mauris eget justo dictum tempus sed vel tellus.</p>
                                            <div class="price">
                                                <ins><span class="price-amount"><span class="currencySymbol">£</span>85.00</span></ins>
                                                <del><span class="price-amount"><span class="currencySymbol">£</span>95.00</span></del>
                                            </div>
                                            <div class="buttons">
                                                <a href="#" class="btn wishlist-btn"><i class="fa fa-heart" aria-hidden="true"></i></a>
                                                <a href="#" class="btn add-to-cart-btn">add to cart</a>
                                                <a href="#" class="btn compare-btn"><i class="fa fa-random" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="advance-info">
                                            <ul class="list">
                                                <li>100% real fruit ingredients</li>
                                                <li>All Sugar comes naturally</li>
                                                <li>Non-GMO Project Verified</li>
                                            </ul>
                                            <div class="shipping-info">
                                                <p class="shipping-day">3-Day Shipping</p>
                                                <p class="for-today">Pree Pickup Today</p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="product-item col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="contain-product pr-detail-layout">
                                        <div class="product-thumb">
                                            <a href="#" class="link-to-product">
                                                <img src="${pageContext.request.contextPath}/templates/assets/images/products/p-10.jpg" alt="dd" width="270" height="270" class="product-thumnail">
                                            </a>
                                        </div>
                                        <div class="info">
                                            <b class="categories">Fresh Fruit</b>
                                            <h4 class="product-title"><a href="#" class="pr-name">Organic 10 Assorted Flavors Jelly Beans, 5.5 Oz</a></h4>
                                            <p class="excerpt">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vel maximus lacus. Duis ut mauris eget justo dictum tempus sed vel tellus.</p>
                                            <div class="price">
                                                <ins><span class="price-amount"><span class="currencySymbol">£</span>85.00</span></ins>
                                                <del><span class="price-amount"><span class="currencySymbol">£</span>95.00</span></del>
                                            </div>
                                            <div class="buttons">
                                                <a href="#" class="btn wishlist-btn"><i class="fa fa-heart" aria-hidden="true"></i></a>
                                                <a href="#" class="btn add-to-cart-btn">add to cart</a>
                                                <a href="#" class="btn compare-btn"><i class="fa fa-random" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                        <div class="advance-info">
                                            <ul class="list">
                                                <li>100% real fruit ingredients</li>
                                                <li>All Sugar comes naturally</li>
                                                <li>Non-GMO Project Verified</li>
                                            </ul>
                                            <div class="shipping-info">
                                                <p class="shipping-day">3-Day Shipping</p>
                                                <p class="for-today">Pree Pickup Today</p>
                                            </div>
                                        </div>
                                    </div>
                                </li> --%>

							</ul>
						</div>

						<div class="biolife-panigations-block">
							<ul class="panigation-contain">
								<li><span class="current-page">1</span></li>
								<li><a href="#" class="link-page">2</a></li>
								<li><a href="#" class="link-page">3</a></li>
								<li><span class="sep">....</span></li>
								<li><a href="#" class="link-page">20</a></li>
								<li><a href="#" class="link-page next"><i
										class="fa fa-angle-right" aria-hidden="true"></i></a></li>
							</ul>
						</div>

					</div>

				</div>
				<!-- Sidebar -->
				<aside id="sidebar"
					class="sidebar col-lg-3 col-md-4 col-sm-12 col-xs-12">
					<div class="biolife-mobile-panels">
						<span class="biolife-current-panel-title">Sidebar</span> <a
							class="biolife-close-btn" href="#"
							data-object="open-mobile-filter">&times;</a>
					</div>
					<div class="sidebar-contain">
						<div class="widget biolife-filter">
							<h4 class="wgt-title">Departements</h4>
							<div class="wgt-content">
								<ul class="cat-list">
									<li class="cat-list-item"><a href="#" class="cat-link">Organic
											Food</a></li>
									<li class="cat-list-item"><a href="#" class="cat-link">Fresh
											Fruit</a></li>
									<li class="cat-list-item"><a href="#" class="cat-link">Dried
											Fruits</a></li>
								</ul>
							</div>
						</div>

						<div class="widget biolife-filter">
							<h4 class="wgt-title">Shipping & Pickup</h4>
							<div class="wgt-content">
								<ul class="cat-list">
									<li class="cat-list-item"><a href="#" class="cat-link">Show
											all</a></li>
									<li class="cat-list-item"><a href="#" class="cat-link">2-
											Day shipping</a></li>
									<li class="cat-list-item"><a href="#" class="cat-link">Shop
											to Home</a></li>
									<li class="cat-list-item"><a href="#" class="cat-link">Free
											Pickup</a></li>
								</ul>
							</div>
						</div>

						<div class="widget price-filter biolife-filter">
							<h4 class="wgt-title">Price</h4>
							<div class="wgt-content">
								<div class="frm-contain">
									<form action="/show-products-by-price" name="price-filter" id="price-filter"
										method="get">
										<p class="f-item">
											<label for="pr-from">$</label> <input class="input-number"
												type="number" id="pr-from" value="${min }" name="min">
										</p>
										<p class="f-item">
											<label for="pr-to">to $</label> <input class="input-number"
												type="number" id="pr-to" value="${max }" name="max">
										</p>
										<p class="f-item">
											<button class="btn-submit" type="submit">go</button>
										</p>
									</form>
								</div>
								<ul class="check-list bold single">
									<li class="check-list-item"><a href="#" class="check-link">$0
											- $5</a></li>
									<li class="check-list-item"><a href="#" class="check-link">$5
											- $10</a></li>
									<li class="check-list-item"><a href="#" class="check-link">$15
											- $20</a></li>
								</ul>
							</div>
						</div>

					

			

			

			

				

					
					</div>

				</aside>
			</div>
		</div>
	</div>

	<%@include file="/views/user/footer.jsp"%>

	<a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>
	<%@include file="/commons/user-script.jsp"%>


	<script type="text/javascript">
function addToCart(id){

	$.get("/cart/add/"+id, function(data, status){location.reload();});
	
}
</script>
</body>
</html>