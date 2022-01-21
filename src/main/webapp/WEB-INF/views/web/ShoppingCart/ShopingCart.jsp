<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
<div class="alert alert-primary" role="alert"></div>
 <section class="checkout-page">
        <div class="container">
            <div class="heading-sub">
                <h3 class="pull-left">shop cart</h3>
                <ul class="other-link-sub pull-right">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#shop">Shop</a></li>
                    <li><a class="active" href="#cart">Cart</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <ul class="breadcrumb">
                <li>
                    <a href="<c:url value='/Cart' />" class="active">01. Shopping Cart</a>
                </li>
                <li>
                    <a href="<c:url value='/CheckOut' />">02. Check Out</a>
                </li>
                <li>
                    <a href="<c:url value='/Complete' />" title="">03. Order Complete</a>
                </li>
            </ul>
            <div class="checkout-cart-form">
					<c:if test="${not empty annouce }">
					<div class="alert alert-warning alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Thông báo!</strong> Sản phẩm ${annouce } đã hết
					</div>
				</c:if>	
				<div class="row">
                    <div class="col-md-12 col-sm-12">
                        <table class="table shop_table">
                            <thead>
                                <tr>
                                    <th ><strong>Hình ảnh</strong></th>
                                    <th class="product-name"><strong>Tên sản phẩm</strong></th>
                                    <th class="product-price"><strong>Giá</strong></th>
                                    <th ><strong>Số lượng</strong></th>
                                    <th ><strong>Tổng tiền</strong></th>
                                   	<th style = "width:44px"></th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var ="u" items="${cart}">
                            		<tr class="cart_item">
                                    <td class="product-thumbnail"><a href="#"><img src="<c:url value='/images/${u.product.thumbnail}' />" alt="images" class="img-responsive" style="width:100px;height: 100px;"></a></td>
                                    <td class="product-name">
                                        <a href="<c:url value="/product/${u.product.id}"/>">${u.product.metatitle}</a>
                                    </td>
                                    <td class="product-price">
                                        <p class="price"><fmt:formatNumber type="currency"  value="${u.product.price*(1-u.product.discount)}" /></p>
                                    </td>
                                    <td class="product-quantity">
                                        <div class="quantity">
                                            <input type="text" name="quantity" value="${u.quantity}" disabled>
                                        </div>
                                    </td>
                                    <td class="product-price product-subtotal">
                                        <p class="price"><fmt:formatNumber type="currency"  value="${u.product.price*u.quantity*(1-u.product.discount)}" /></p>
                                    </td>
                                    <td>
                                    	<div class="btn btn-secondary" style="width: 26px; height: 22px; margin-top: 60px; ">
                                    		<a href="<c:url  value = "/delete/CartItem/${u.id}"/>" title="" class="pb-4 pr-4">x</a>
                                    	</div>
                                    </td>
                                    
                                    
                                </tr>
                            	</c:forEach>
                               
                                
                                
                            </tbody>
                        </table>
                    </div>
                   
                </div>
                <div class="row">
                	 <div class="process">
                               <a href ="<c:url value="/CheckOut"/>"><button type="submit" class="btn-checkout" >PROCEED TO CHECKOUT</button></a>
                            </div>
                </div>
           
        </div>
    </section>
    <div class="features">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-12 fea-column-inner">
                    <div class="fea-box">
                        <div class="photo">
                            <img src="<c:url value='/template/web/img/gift.png' />" alt="images" class="img-reponsive">
                        </div>
                        <p class="inform-ver2">
                            <span class="strong">Deal of the day<br></span> check out today's deal
                        </p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12 fea-column-inner">
                    <div class="fea-box">
                        <div class="photo">
                            <img src="<c:url value='/template/web/img/fly.png' />" alt="images" class="img-reponsive">
                        </div>
                        <p class="inform-ver2">
                            <span class="strong">Free Shipping<br></span> on thousands of products
                        </p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12 fea-column-inner">
                    <div class="fea-box">
                        <div class="photo">
                            <img src="<c:url value='/template/web/img/return.png' />" alt="images" class="img-reponsive">
                        </div>
                        <p class="inform-ver2">
                            <span class="strong">Easy Returns<br></span> on all purchases made
                        </p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12 fea-column-inner">
                    <div class="fea-box">
                        <div class="photo">
                            <img src="<c:url value='/template/web/img/secu.png' />" alt="images" class="img-reponsive">
                        </div>
                        <p class="inform-ver2">
                            <span class="strong">Best Services Medal<br></span> we are proud of best service
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>