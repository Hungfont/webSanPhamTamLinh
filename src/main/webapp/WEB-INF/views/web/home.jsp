<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>

<body>
	<div class="slide v3" style="margin-top:15px;"> 
        <div class="single-item js-banner">
            <div class="slide-img">
                <img src="<c:url value="/images/slider_item_1_image.jpg"/>" alt="images" class="img-reponsive">               
            </div>
        </div>
    </div>
    <section class="best-seller top-sales">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-xs-12 pull-left right45">
                    <div class="product-item ver2 v2 v3">
                        <div class="prod-item-img v2 v3 text-center">
                            <a href="<c:url value='/product/${top1.id }' />"><img src="<c:url value='/images/${top1.thumbnail }' />" alt="images" class="img-responsive"></a>
                            <div class="ribbon">
                                <span class="strong">#1</span>
                                <br>SELLER
                            </div>
                        </div>
                        <div class="prod-choose v2 text-center">
                            <div class="prod-color v2">
                                <span class="dot v2 blackc"></span>
                                <span class="dot v2 greensd"></span>
                                <span class="dot v2"></span>
                            </div>
                        </div>
                        <div class="prod-info v2 v3">
                            <h3><a href="<c:url value='/product/${top1.id }' />">${top1.metatitle }</a></h3>           
                            <div class="prod-price v3">
								<c:choose>
									<c:when test="${top1.discount != 0 }">
										<span class="price old"><fmt:formatNumber
												type="currency" value="${top1.price}" /></span>
										<span class="price"><fmt:formatNumber type="currency"
												value="${top1.price*(1-top1*discount)}" /></span>
									</c:when>
									<c:otherwise>
										<span class="price"><fmt:formatNumber type="currency"
												value="${top1.price}" /></span>
									</c:otherwise>
								</c:choose>
							</div>
                            <p>${top1.summary } </p>
                            <div class="button v3">                             
                                <a href="<c:url value='/product/${top1.id }' />" class="view v3">View Accessories</a>
                            </div>
                        </div>
                        <div class="countdown v2 v3" data-countdown="countdownver2" data-date="08-31-2018-00-00-00">
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-xs-12">
                    <div class="heading-v1 v2 top60">
                        <h3 class="title v2 v3 pull-left">Top Sales</h3>       
                        <div class="clearfix"></div>
                    </div>
                    <div class="tab-content">
                        <div id="day" class="tab-pane fade in active">
                            <div class="row top30">
                                <c:forEach var = "u" items="${week }">
                                	<div class="col-md-6 col-sm-6 col-xs-6">
                                    <div class="product-item ver5 v3 pd20">
                                        <div class="prod-item-img text-center">
                                            <a href="<c:url value='/product/${u.id }' />"><img src="<c:url value='/images/${u.thumbnail }' />" alt="images" class="img-responsive"></a>
                                            <div class="label label-2 blue v2">NEW</div>                          
                                        </div>
                                        <div class="prod-info ver3 top20">
                                            <h3><a href="<c:url value='/product/${u.id }' />">${u.metatitle }</a></h3>                                    
                                            <div class="prod-price">
                                               <c:choose>
                                               	<c:when test="${u.discount != 0 }">
                                               		<span class="price old"><fmt:formatNumber type="currency"  value="${u.price}" /></span>
                                              	 	<span class="price"><fmt:formatNumber type="currency"  value="${u.price*(1-u*discount)}" /></span>
                                               	</c:when>
                                               	<c:otherwise>
                                               		<span class="price"><fmt:formatNumber type="currency"  value="${u.price}" /></span>
                                               	</c:otherwise>
                                               </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                              </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="subbanner">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="sub-banner">
                        <a href="#"><img src="<c:url value='images/sub-banner.png' />" alt="images" class="img-reponsive"></a>                     
                        <div class="sub-banner-btn">
                          
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="sub-banner">
                        <a href="#"><img src="<c:url value='images/sub-banner1.jpg' />" alt="images" class="img-reponsive" style="height:142px; width: 540px"></a>
                        <div class="sub-banner-btn">
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="brand-corner">
        <div class="container">
            <div class="heading-v1 v2 top30">
                <h3 class="title v2 v3 pull-left">Best Sellers</h3>
                <div class="clearfix"></div>
            </div>
            <div class=" row brand-list-v1 top-row">
                <c:forEach var="u" items="${best }"> 
                	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 ">
                    <div class="product-item ver1 ">
                        <div class="prod-item-img set--width50">
                            <a href="<c:url value='/product/${u.id }' />"><img src="<c:url value='/images/${u.thumbnail }' />" alt="images" class="img-responsive" style="width: 200px; height: 200px;"></a>
                        </div>
                        <div class="prod-info set--width50">
                            <div style="margin-top:-30px;padding-left:20px;">
	                            <h3><a href="<c:url value='/product/${u.id }' />" style="font-size: 14px;">${u.metatitle }</a></h3>             
	                            <div class="p-price">
	                                <span class="price black"><fmt:formatNumber type="currency"  value="${u.price*(1-u.discount)}" /></span>
	                            </div>
                            </div>
                        </div>
                    </div>
                </div> 
                </c:forEach>                  
            </div>
        </div>
    </section>
    <div class="banner_1">
        <div class="container">
            <a href=""><img src="<c:url value='/images/banner_product_3.jpg' />" alt="images" class="img-responsive"></a>
        </div>
    </div>
</body>

</html>