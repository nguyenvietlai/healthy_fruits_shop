<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/commons/user-css.jsp"%>
</head>
<body>
<!--   <!-- Preloader --> 
<!--     <div id="biof-loading"> -->
<!--         <div class="biof-loading-center"> -->
<!--             <div class="biof-loading-center-absolute"> -->
<!--                 <div class="dot dot-one"></div> -->
<!--                 <div class="dot dot-two"></div> -->
<!--                 <div class="dot dot-three"></div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->

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
                <li class="nav-item"><span class="current-page">Order History</span></li>
            </ul>
        </nav>
    </div>
     <div class="page-contain shopping-cart">

        <!-- Main content -->
        <div id="main-content" class="main-content">
            <div class="container">

              
                
                <!--Cart Table-->
                <div class="shopping-cart-container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <h3 class="box-title">Lịch Sử đơn hàng</h3>
                                <table class="shop_table cart-form">
                                    <thead>
                                    <tr>
                                        <th class="product-subtotal">Mã đơn hàng (id order)</th>
                                        <th class="product-price">Thời gian đặt hàng (date order)</th>
                                        <th class="product-name">Địa chỉ</th>
                                        <th class="product-subtotal">Sô lượng</th>
                                        <th class="product-quantity">Tổng tiền</th>
                                        <th class="product-subtotal">Trạng thái </th>
                                        
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${data != null}">
                                    <c:forEach var="e" items="${data}" >
                                    
                                    <tr class="cart_item">
                                       <td class="product-thumbnail" data-title="Product Name">
<a class="prd-name" href="#">${e.id}</a>
                                            
                                        </td>
                                        <td class="product-thumbnail" data-title="Product Name">
                                            <div class="price price-contain">
                                                <ins><span class="price-amount">${e.createdate}</span></ins>
                                               
                                            </div>
                                        </td>
                                        <td class="product-thumbnail" data-title="Product Name">
                                            <div class="price price-contain">
                                                <ins><span class="price-amount">${e.address}</span></ins>
                                               
                                            </div>
                                        </td>
                                       
                                        <td class="product-subtotal" data-title="Total">
                                            <div class="price price-contain">
                                                 <ins><span class="price-amount">${e.orderdetails.size() }</span></ins>
                                                
                                            </div>
                                        </td>
                                        <td class="product-subtotal" data-title="Total">
                                            <div class="price price-contain">
                                                 <ins><span class="price-amount">${e.orderdetails[0].price *  e.orderdetails[0].quantity  }</span></ins>
                                                
                                            </div>
                                        </td>
                                        <td class="product-thumbnail" data-title="Product Name">
                                            <div class="price price-contain">
                                                <ins><span class="price-amount">Đang xác nhận đơn hàng</span></ins>
                                               
                                            </div>
                                        </td>
                                    </tr>
                                    
                                    </c:forEach>
                                    </c:if>
                                      
                                    <tr >
                                        <td class="wrap-btn-control" colspan="4">
                                            <a href="/products.php" class="btn back-to-shop">Back to Shop</a>

                                           <!--  <button class="btn btn-clear" type="submit">clear all</button> -->
                                        </td>
                                    </tr>
</tbody>
                                </table>
                        </div>
                      
                    </div>
                </div>
                
                
                
                
                
                

                <!--Related Product-->
                

            </div>
        </div>
    </div>
<br>
     
     <%@include file="/views/user/footer.jsp"%>
    <!-- Scroll Top Button -->
    <a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>

<%@include file="/commons/user-script.jsp"%>



</script>
</body>
</html>