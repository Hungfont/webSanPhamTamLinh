<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckOut</title>
</head>
<body>
 <section class="checkout-page">
        <div class="container">
            <div class="heading-sub">
                <h3 class="pull-left">check out</h3>
                <ul class="other-link-sub pull-right">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#shop">Shop</a></li>
                    <li><a class="active" href='<c:url value ="/Cart"/>'>Cart</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <ul class="breadcrumb">
                <li>
                    <a href="<c:url value ="/Cart"/>">01. Shopping Cart</a>
                </li>
                <li>
                    <a href="<c:url value ="/CheckOut"/>" class="active">02. Check Out</a>
                </li>
                <li>
                    <a href="<c:url value ="CheckOut"/>" title="">03. Order Complete</a>
                </li>
            </ul>
            <div class="orders">
                <div class="row">	
                <form action="${pageContext.request.contextPath }/save" method="post">
                	<div class="col-md-7">
                		<div id="message" style="display:none;" class="alert alert-danger"></div>
						<div class="billing-details">
							<div class="billing-details-heading">
								<h2 class="billing-title">THÔNG TIN HOÁ ĐƠN</h2>
							</div>
								<div class="billing-details-content">
									<div class="form-group">
										<div class="row">
											<div class="col-md-6 col-xs-12">
												<strong>Họ đệm</strong> 
												<input  type="text" class="form-control" name ="first_name" value="" placeholder="Vui lòng nhập họ...."/>
											</div>
											<div class="col-md-6 col-xs-12">
												<strong>Tên</strong> <input type="text" name="last_name"
													class="form-control" value="" placeholder="Vui lòng nhập tên...">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-md-6 col-xs-12">
												<strong>Email</strong> <input type="text" name="email"
													class="form-control" value=""  placeholder="Vui lòng nhập email...">
											</div>
											<div class="col-md-6 col-xs-12">
												<strong>Số điện thoại</strong> <input type="text"
													name="phone" class="form-control" value=""  placeholder="Vui lòng nhập số điện thoại...">
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-md-12">
												<strong>Địa chỉ</strong> <input type="text" name="address"
													class="form-control" value=""  placeholder="Vui lòng nhập địa chỉ...">
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-md-12">
												<strong>Ghi chú</strong>
												<textarea name="note" id="note" tabindex="2"
													class="form-control form-textarea"></textarea>
											</div>
										</div>
									</div>
								</div>
						</div>
					</div>
					<div class="col-md-5">
						<div class="aside-order">
							<h2>HOÁ ĐƠN</h2>
							<table class="table table-product">
								<thead>
									<tr>
										<th>SẢN PHẨM</th>
										<th></th>
										<th>THÀNH TIỀN</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="u" items="${product}">
										<tr>
											<td class="product-name">${u.product.metatitle }</td>
											<td class="product-quantity">x${u.quantity }</td>
											<td class="product-total"><fmt:formatNumber
													type="currency"
													value="${u.product.price*u.quantity*(1-u.product.discount)}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<ul class="tabs-first">
								<li><span class="text"
									style="font-size: 17px; font-style: bold">TỔNG:</span><span
									class="cart-number big-total-number"
									style="margin-left: 120px; color: black;"><fmt:formatNumber
											type="currency" value="${total}" /></span></li>
							</ul>
							<a href="<c:url value="/save"/>"><button type="submit" class="btn-order">ĐẶT HÀNG</button></a>
						</div> 
						</div>
					</form>
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
	<script>
		    const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);
			const message = urlParams.get('message')
			if(message){
				 document.getElementById("message").innerHTML = message; 	
				document.getElementById("message").style.display = "block";
				setTimeout(function() {
					$(".alert").fadeOut();
				}, 3000);
			} 

		</script>
</body>
</html>