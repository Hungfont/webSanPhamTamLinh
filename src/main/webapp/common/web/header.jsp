<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">SEARCH HERE</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <form method="get" class="searchform" action="/search" role="search">
                            <input type="hidden" name="type" value="product">
                            <input type="text" name="q" class="form-control control-search">
                            <span class="input-group-btn">
                              <button class="btn btn-default button_search" type="button"><i data-toggle="dropdown" class="ion-ios-search"></i></button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <header>
        <div class="topbar-mobile hidden-lg hidden-md">
            <div class="active-mobile">
                <div class="language-popup dropdown">
                    <a id="label" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                <span class="icon"><i class="ion-ios-world-outline" aria-hidden="true"></i></span>
                  <span>English</span>
                  <span class="ion-chevron-down"></span>
                </a>
                    <ul class="dropdown-menu" aria-labelledby="label">
                        <li><a href="#">English</a></li>
                        <li><a href="#">Vietnamese</a></li>
                    </ul>
                </div>
            </div>
            <div class="right-nav">
                <div class="active-mobile">
                    <div class="header_user_info popup-over e-scale hidden-lg hidden-md dropdown">
                        <div data-toggle="dropdown" class="popup-title dropdown-toggle" title="Account">
                            <i class="ion-android-person"></i><span> Account</span>
                        </div>
                        <ul class="links dropdown-menu list-unstyled">
                            <li>
                                <a id="customer_login_link" href="#" title="Sign in"><i class="ion-log-in"></i> Login</a>
                            </li>
                            <li>
                                <a id="customer_register_link" href="#" title="Register"><i class="ion-ios-personadd"></i> Register</a>
                            </li>
                            <li>
                                <a class="account" rel="nofollow" href="#" title="My account"><i class="ion-ios-person"></i> My account</a>
                            </li>
                            <li>
                                <a id="wishlist-total" title="Wishlist" href="#"><i class="ion-ios-heart"></i> Wishlist</a>
                            </li>
                            <li>
                                <a href="#" title="Check out"><i class="ion-ios-cart"></i> Check out</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="active-mobile search-popup pull-right">
                    <div class="search-popup dropdown" data-toggle="modal" data-target="#myModal">
                        <i class="ion-search fa-3a"></i>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="top-nav v2 hidden-xs hidden-sm">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-5">
                        <div class="left-nav">
                            <div class="location dropdown">
                                <a id="label1" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="icon"><i class="ion-ios-location" aria-hidden="true"></i></span>
                                  <span>Our Store</span>
                                 <span class="ion-chevron-down"></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="label1">
                                    <li><a href="#">New York</a></li>
                                    <li><a href="#">California</a></li>
                                </ul>
                            </div>
                            <div class="language dropdown">
                                <a id="label2" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="icon"><i class="ion-ios-world-outline" aria-hidden="true"></i></span>
                                  <span>English</span>
                                 <span class="ion-chevron-down"></span>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="label2">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">Vietnamese</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-7 col-sm-7">
                        <div class="right-nav">
                           <ul>
                               <security:authorize access = "isAnonymous()">
									<li><a href="<c:url value='/dang-ky' />"><i class="ion-ios-personadd fa-1a" aria-hidden="true"></i>create account</a></li>
                               		<li><a href="<c:url value='/dang-nhap' />"><i class="ion-log-in fa-1a" aria-hidden="true"></i>login</a></li>
								</security:authorize>
								<security:authorize access = "isAuthenticated()">
									<li><a href="<c:url value='/dang-ky' />"><i class="ion-ios-personadd fa-1a" aria-hidden="true"></i>create account</a></li>
									<li class="nav-item"><div class="dropdown show">
										<a class="nav-link dropdown-toggle" href="#"
											role="button"  data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"><%=SecurityUtils.getPrincipal().getFullName()%></a>
										<div class="dropdown-menu" aria-labelledby="dropdownMenuLink" style="margin:6px 0px 8px -2px;">
											<a class="dropdown-item" href='<c:url value = "/user/information" />' style="margin-top:15px;">Thông tin tài khoản</a> 
											<br>
											<a class="dropdown-item" href='<c:url value = "/Cart" />' style="margin-top:15px;">Giỏ hàng</a> 
											<br>
											<a class="dropdown-item" href='<c:url value = "/list/order" />' style="margin-top:15px;">Thông tin đơn hàng</a> 
											<br>
											<a class="dropdown-item" href='<c:url value = "/password/forget" />' style="margin-top:15px;">Đổi mật khẩu</a>
											<br>
											<security:authorize access="hasRole('ADMIN')">
												<a class="dropdown-item" href='<c:url value = "/admin/home" />' style="margin-top:15px;">Về Trang Quản Trị</a>
											</security:authorize>
										</div>
									</div>
								</li>
								<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
								</security:authorize>
                            </ul>
                            <div class="nav-search">
                                <form action="<c:url value= '/search' />" class="search-form v3">
                                     <input type="text" name="search" class="form-control" placeholder="Nhập tên sản phẩm">
                                    <button type="submit" class="search-icon v3 fa-3"></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-8 col-xs-8  logo">
                        <a href="<c:url value="/trang-chu"/>"><img src="<c:url value="/images/logo.png"/>" alt="images" class="img-reponsive"></a>
                    </div>
                    <div class="col-md-9 col-sm-4 col-xs-4  nextlogo">
                        <div class="block block-2 v3">
                            <div class="cart">
                                <a href="#" title="" id="cart" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="photo photo-cart">
                                        <img src="<c:url value="/template/web/img/cart.png"/>" alt="images" class="img-reponsive">
                                        <span class="lbl">${cnt }</span>
                                    </div>
                                    <p class="inform inform-cart">
                                        <span class="strong">CART<br></span>
                                        <span class="price-cart"><fmt:formatNumber type="currency"  value="${total}" /></span>
                                    </p>
                                </a>
                                <div class="dropdown-menu dropdown-cart" aria-labelledby="label2">
                                    <ul>
                                     	<c:forEach var="u" items="${cart }">
                                     		
	                                        <li>
	                                            <div class="item-order">
	                                                <div class="item-photo">
	                                                    <a href="<c:url value='/product/${u.product.id }' />"><img src="<c:url value='/images/${u.product.thumbnail}' />" class="img-responsive" style="width: 70px; height:70px; margin-top:12px;"></a>
	                                                </div>
	                                                <div class="item-content">
	                                                    <h3><a href="<c:url value='/product/${u.product.id }' />" title="">${u.product.metatitle }</a></h3>
	                                                    <p class="price black"><fmt:formatNumber type="currency"  value="${u.product.price*u.quantity*(1-u.product.discount)}" /></p>
	                                                    <p class="quantity">x${u.quantity}</p>
	                                                </div>
	                                            </div>
	                                            <div class="btn-delete"><a href="<c:url value='/delete/CartItem/${u.id }' />" title="" class="btndel">x</a></div>
	                                        </li>
                                     	</c:forEach>
                                    </ul>
                                    <div class="content-1">
                                        <span class="total">Total: <strong class="price black"><fmt:formatNumber type="currency"  value="${total}" /></strong></span>
                                        <span class="quantity"><strong class="number">${cnt }</strong> products</span>
                                    </div>
                                    <div class="content-2">
                                        <a href="<c:url value='/CheckOut' />" class="addcart">CHECKOUT</a>
                                        <a href="<c:url value='/Cart' />" class="viewcart">View Cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="block block-option">
                            <ul>
                                <li><a href="#"><i class="ion-ios-heart fa-1a" aria-hidden="true"></i>Wishlist</a></li>
                                <li><a href="#"><i class="ion-arrow-swap fa-1a" aria-hidden="true"></i>Compare</a></li>
                            </ul>
                        </div>                 
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="menu v3">
            <div class="container-fluid"> 
                <div class="row row-no-padding">
                    <div class="col-md-3 col-sm-4 col-xs-6 column-left v3">
                        <aside id="column-left">
                            <nav class="navbar-default">
                                <div class="menu-heading v3 js-nav-menu ">ALL CATEGORIES</div>
                                <div class="vertical-wrapper v3 js-dropdown-menu">
                                    <ul class="level0">
                                        <c:forEach var="u" items="${category }">
                                        	<li><a href="<c:url value='/category/${u.id}'/>">${u.name}</a></li>
                                        </c:forEach>
                                       
                                    </ul>
                                </div>
                            </nav>
                        </aside>
                    </div>
                    <div class="col-md-9 col-sm-8 col-xs-6 column-right v3">
                        <button type="button" class="navbar-toggle v3" data-toggle="collapse" data-target="#myNavbar">
                            <span class="menu-title">MENU</span>
                        </button>
                        <div class="collapse navbar-collapse v3" id="myNavbar">
                            <ul class="menubar v3 js-menubar">
                                <li class=" menu-homepage menu-item-has-child dropdown">
                                    <a href="<c:url value='/trang-chu'/>" title="Home"><i class="fa fa-home"></i>home</a>
                                    <span class="plus js-plus-icon"></span>
                                    
                                </li>
                                <li class="menu-collection-page menu-item-has-child dropdown">
                                    <a href="#" title="Marketplace">marketplace</a>
                                    <span class="plus js-plus-icon"></span>
                                    
                                </li>
                                <li class=" menu-demo-page menu-item-has-child dropdown">
                                    <a href="#" title="Sellerdemo">SELLER DEMO</a>
                                    <span class="plus js-plus-icon"></span>             
                                </li>
                                <li class="dropdown menu-contact-page menu-item-has-child">
                                    <a href="#" title="ContactUs">CONTACT US</a>
                                    <span class="plus js-plus-icon"></span>                                   
                                </li>
                                <li class="dropdown menu-blog-page menu-item-has-child">
                                    <a href="#" title="Blog">blog</a>
                                    <span class="plus js-plus-icon"></span>                       
                                </li>
                                <li class="dropdown menu-others-page menu-item-has-child"><a href="#" title="Others">others</a>
                                    <span class="plus js-plus-icon"></span>                    
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>