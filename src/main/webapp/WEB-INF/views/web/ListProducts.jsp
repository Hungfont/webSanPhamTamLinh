<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<section class="shop-list-v3-page">
        <div class="container">
            <div class="widget-product-list">
                <div class="row">
                    <div class="col-md-3">
                        <div class="filter-block">
                            <div class="filter-block-shop filter-price">
                               <img alt="" src="<c:url value='/images/quang-cao1.png'/>">
                               <br>
                               <br>
                               <img alt="" src="<c:url value='/images/Mozilla-372x600.png'/>">
                            </div>
                            
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="filter-block bd">
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="box box-view">
                                        <%-- <span>Showing 6 of ${cnt } results</span> --%>
                                        <div class="button-view">
                                            <span class="col"><i class="ion-ios-keypad fa-3a"></i></span>
                                            <span class="list"><i class="icon-grid-4"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7 margin-top3">                
                                    <div class="box sort pull-right">
                                        <span>Sort by:</span>
                                        <button class="dropdown-toggle" type="button" data-toggle="dropdown" id="menu2">
                                            <span class="dropdown-label">Giá</span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu" aria-labelledby="menu2">
                                            <li><a href="<c:url value='/category/${id}?price=1&page=0'/>" title="">Giá: tăng dần</a></li>
                                            <li><a href="<c:url value='/category/${id}?price=2&page=0'/>" title="">Giá: giảm dần</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <div class="product-list">
                            <div class="product-list grid_full grid_sidebar grid-uniform">
                    <!-- List Product -->
             
                              	 <c:forEach var="u" items="${product.content}">
	                              	 <c:if test="${u.quantity != 0 }">
										<div class="product-list-item" >
											<div class="product-item-img" >
												<a href="<c:url value='/product/${u.id }' />"><img
													src="<c:url value='/images/${u.thumbnail }' />"
													alt="images" class="img-responsive"></a>
											</div>
											<div class="product-item-info">
												<h3>
													<a href="<c:url value='/product/${u.id}' />">${u.metatitle}</a>
												</h3>
												
												<div class="mt-4">
													<div class="prod-price">
														<span class="price black"><fmt:formatNumber
																type="currency" value="${u.price*(1-u.discount)}" /></span>
													</div>
												</div>
												<div class="button-ver2">
													<a href="<c:url  value="/addToCart/${u.id}" />"
														class="addcart-ver2" title="Add to cart"><span
														class="icon"></span>ADD TO CART</a>
												</div>
											</div>
										</div>
									</c:if>
									<c:if test="${u.quantity == 0 }">
										<div class="product-list-item" >
											<div class="product-item-img" >
												<img
													src="<c:url value='/images/${u.thumbnail }' />"
													alt="images" class="img-responsive">
											</div>
											<div class="product-item-info">
												<h3>
													<span style="font-size:13px; font-weight:400">${u.metatitle}</span>
												</h3>
												<span class="mt-3" style="color: red; font-size: 16px;">HẾT
													HÀNG</span>
												<div class="mt-4">
													<div class="prod-price">
														<span class="price black"><fmt:formatNumber
																type="currency" value="${u.price*(1-u.discount)}" /></span>
													</div>
												</div>
												
											</div>
										</div>
									</c:if>
                              	 </c:forEach>
         						<%-- <div class="product-list-item">
                                    <div class="product-item-img">
                                        <a href="#"><img src="<c:url value='' />" alt="images" class="img-responsive"></a>
                                        <div class="label label-2 red label-top-20">Hot</div>
                                    </div>
                                    <div class="product-item-info">
                                        <h3><a>${product.metatitle }</a></h3>
                                        <div class="prod-price">
                                            <span class="price black">${product.price}</span>
                                        </div>
                                        
                                        <div class="button-ver2">
                                            <a href="#" class="addcart-ver2" title="Add to cart"><span class="icon"></span>ADD TO CART</a>
                                        </div>
                                    </div>
                                </div> --%>
                            </div>
                            
                        </div>
						<%-- <nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${product.number!=0 }">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath }/admin/category/list?page=0">First</a></li>
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath }/admin/category/list?page=${product.number - 1}">Previous</a></li>
								</c:if>

									<c:if test="${model.number < model.totalPages }">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?page=0">${model.number+1}</a></li>
												</c:if>	

								<c:if test="${product.number < product.totalPages -1 }">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath }/admin/category/list?page=${product.number + 1}">Next</a></li>
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath }/admin/category/list?page=${product.totalPages - 1}">Last</a></li>
								</c:if>
							</ul>
						</nav> --%>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${product.number!=0 }">
									<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/category/${id}?price=${price}&page=${product.number - 1}">Prev</a></li>
							 	</c:if>
								<c:if test="${product.number < product.totalPages -1 }">
									<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/category/${id}?price=${price}&page=${product.number + 1}" style="float:left;">Next</a></li>
								</c:if>
							</ul>
							
						</nav>
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
                            <img src="img/gift.png" alt="images" class="img-reponsive">
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