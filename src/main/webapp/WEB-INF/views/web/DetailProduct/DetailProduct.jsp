<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/addtoCart/detailProduct/"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Chi tiết sản phẩm</title>
	</head>

	<body>
		    <section class="shop-single-page">
        <div class="container">
            <div class="heading-sub">
                <h3 class="pull-left">shop single</h3>
                <ul class="other-link-sub pull-right">
                    <li><a href="#home">Home</a></li>
                    <li><a href="#shop">Shop</a></li>
                    <li><a class="active" href="#detail">Detail</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="widget-shop-single">
                <div class="row">
                    <div class="col-md-5">
                        <div class="shop-single-item-img">
                            <div class="main-img">
                                <div class="main-img-item">
                                    <a href="#"><img src="<c:url value='/images/${detailProduct.thumbnail}'/>" alt="images" class="img-responsive"></a>
                                </div>
                            </div>
                          	 <ul class="multiple-img-list">
                          	 	<c:forEach var = "u" items="${detailProduct.images}">
	                                <li>
	                                    <div class="product-col">
	                                        <div class="img">
	                                            <img src="<c:url value='/images/${u.name}'/>" alt="images" class="img-responsive" style="width: 86px; height: 86px;">
	                                        </div>
	                                    </div>
	                                </li>                            	
                          	 	</c:forEach>
                 
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="shop-sing-item-detail">
                            <h3>${ detailProduct.title}</h3>
                            <div class="brandname">Mã sản phẩm <strong>${ detailProduct.sku}</strong></div>
                             <div class="ratingstar">
                                <a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
                                <span class="number">(12)</span>
                                <a class="review">Add your review</a>
                            </div> 
                            <div class="prod-price">
                              		<%-- <c:if test="${ detailProduct.discount eq 0}">
                              			<span class="price old">${detailProduct.price}</span>
                              			<span class="price"><fmt:formatNumber type="currency"  value="${detailProduct.price}" /></span> 
                                		<span class="tax">(including tax)</span> 
                              		</c:if> --%>
                                	<c:choose>
								         <c:when test="${ detailProduct.discount eq 0}">
								            <span class="price"><fmt:formatNumber type="currency"  value="${detailProduct.price}" /></span> 
                                		<span class="tax">(including tax)</span> 
								         </c:when>							        
								         <c:otherwise>
								 			<span class="price old"><fmt:formatNumber type="currency"  value="${detailProduct.price}" /></span>
                              				<span class="price"><fmt:formatNumber type="currency"  value="${detailProduct.price *(1 - detailProduct.discount)}" /></span> 
                                			<span class="tax">(including tax)</span> 
								         </c:otherwise>
								      </c:choose>
                          
            				
                            </div>
                            <div class="description">
                                ${detailProduct.summary}
                            </div>
                            <c:if test="${maxItem != 0 }">  
	                            <div class="group-button">
	                                <form action="#" class="cart">
	                                    <div class="quantity">
	                                        <button type="button" class="quantity-left-minus btn btn-number" data-type="minus" data-field="" id="decrease">
	                                            <span class="minus-icon"></span>
	                                        </button>
	                                        <input  type="number" value="1" id="quantity" min="1" max="10"/>
	                                        <button type="button" class="quantity-right-plus btn btn-number" data-type="plus" data-field="" id="increase" data-quantity="${maxItem}">
	                                            <span class="plus-icon" ></span>
	                                        </button>
	                                    </div>	
	                                    
	                                </form>
	                                	 <div class="button-ver2">
	                                   		<button class="link-ver1 addcart-ver2 add-Cart" data-id ="${detailProduct.id }"><span class="icon"></span>ADD TO CART</button>                          
	                                	</div>          
	                            </div>
                            </c:if>
                            <c:if test="${maxItem == 0}">
                            	<p style="font-size: 14px; font-weight: 300; color:red;">Toàn bộ sản phẩm đã trong giỏ hàng</p>
                            </c:if>
                            <div class="product-feature">
                                <ul class="product-feature-1">
                                    <li><strong>Instock:</strong> Yes</li>
                                    <li><strong>Nation:</strong> VietNam</li>
                                </ul>
                                <ul class="product-feature-2">	
                                    <li><strong>Category:</strong>${detailProduct.category.name}</li>
                                </ul>
                            </div> 
                        </div>
                    </div>
                </div>
                <div class="product-detail-bottom">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#desc">Description</a></li>
                    </ul>
                    <div class="tab-content padding-lr" style="width:1175px; height:200px;">
                        <div id="desc" class="tab-pane fade in active">
                          	<br>
                          	<br>
                             ${detailProduct.summary}
                        </div>
                      
                    </div>
                </div>
            </div>
            <div class="related-product-page">
                <div class="heading-shop">
                    <h3>UPSELL PRODUCT</h3>
                </div>
                <div class="widget-product-related">
                    <div class="owl-carousel owl-theme js-owl-product">
                        <c:forEach var ="u" items="${listProduct}">
                        	<div class="product-item">
                            <div class="product-item-img-related prod-item-img">
                                <a href="#"><img src="<c:url value='/images/${ u.thumbnail}'/>" alt="images" class="img-responsive"></a>
                                <div class="button">
                                    <a href='<c:url value ="/addToCart/${u.id}"/>' class="addcart">ADD TO CART</a>
                                </div>
                                <div class="label label-2 pink label-top-20">Sale</div>
                            </div>
                            <div class="product-item-info-related">
                                <h3><a href="<c:url value='/product/${u.id}'/>">${ u.metatitle}</a></h3>
                  
                                <div class="prod-price">
                                    <span class="price black">${ u.price}</span>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <script type="text/javascript">   
	    $(".main-img-item").click(function(){
	        // Change src attribute of image
	        $(this).attr("src", "images/card-front.jpg");
	    });  
	    $(".quantity-right-plus").on("click",function(){
	    	document.getElementById("decrease").style.display = "block";
	    	var number = $(this).data("quantity");
	    	var sl = $("#quantity").val();
	    	if(sl == number - 1){
	    		document.getElementById("increase").style.display = "none";
	    	}		

		});	
	    $(".quantity-left-minus").on("click",function(){
	    		if($("#quantity").val() == 2){
	    			document.getElementById("decrease").style.display = "none";
	    		}
	    		document.getElementById("increase").style.display = "block";	
		});	
    	$(".add-Cart").on("click",function(){
    		var id = $(this).data("id");
    		var quantity = $("#quantity").val();	
    		window.location ="${pageContext.request.contextPath }/addtoCart/detailProduct/"+id+"/"+quantity;
    	});
    	
    	
    </script>
	</body>

</html>