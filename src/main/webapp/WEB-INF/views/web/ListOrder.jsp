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
 <section class="checkout-page"  style="background:#fff8e4;">
        <div class="container" style="padding-top: 0px; background:#f7fffe;"> 
            <div class="checkout-cart-form">
				<div class="row">
                    <div class="col-md-12 col-sm-12" >   
                   		<c:forEach var = "i" items="${order.content}">
	                   			<table class="table shop_table">
	                            <thead>
									<div style="display: flex; justify-content:space-between; align-items: center;">
										<div style="font-size: 16px; font-weight: 700px; color: red;">
											<b style="color: #333;">Địa chỉ:</b>&nbsp;${i.address}
										</div>
										<div>
											<c:if test="${i.status == true }">
												<p style="	color:red;
															font-size:15px;
															font-weight:400;">CHƯA XÁC NHẬN</p>
											</c:if>
											<c:forEach var="t" items="${i.transaction }">				
												<c:choose>											
											         <c:when test = "${i.status == false and t.status == true}">
											           	<p style="	color:red;
															font-size:15px;
															font-weight:400;">ĐÃ GIAO</p>
											         </c:when>
											         
											         <c:when test = "${t.status == false}">
											           <p  style="	color:red;
															font-size:15px;
															font-weight:400;">ĐÃ XÁC NHẬN</p>
												       </c:when>									       
											      </c:choose>
											</c:forEach>
										</div>
									</div>
								</thead>
	                            <tbody>
	                            	<c:forEach var ="u" items="${i.orderItem}">
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
	                                </tr>
	                            	</c:forEach>
	                               
	                                
	                                
	                            </tbody>
	                        </table> 
                   		</c:forEach>					
					</div>
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