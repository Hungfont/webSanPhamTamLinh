<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách sản phẩm</title>
	</head>

	<body>
		<div class="main-content">
		<form action="#" id="formSubmit" method="get">
			
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang chủ > Quản lý sản phẩm</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">				
								<div class="widget-box table-filter">
									<div class="table-btn-controls">						
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										${message}
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th>STT</th>
														<th>Tên sản phẩm</th>	
														<th>Hình ảnh</th>
														<th>Số lượng</th>
														<th>Giá</th>			
													</tr>
												</thead>
												<tbody>
														<c:forEach var="u" items="${orderItem}" varStatus="loop">
															<tr>
																<td>${loop.index+1}</td>
																<td>${u.product.metatitle }</a></td>
																<td><img src = "<c:url value='/images/${u.product.thumbnail }' />"  style= "width:100px; height:50px;"/></a></td>
																<td>${u.quantity }</a></td>
																<td><fmt:formatNumber type="currency"  value="${u.product.price *(1-u.product.discount)*u.quantity}" /></td>																								
															</tr>
														</c:forEach>
															
												</tbody>
											</table>
											<ul style="list-style:none; font-size:18px; font-weight:500; color:red;"> 
												<li>Họ và Tên: ${order.firstName} ${order.lastName }</li>
												<li>Địa chỉ  : ${order.address}</li>
												<li>SDT		 : ${order.phone }</li>
												<li>Tổng tiền: <fmt:formatNumber type="currency"  value="${order.total}" /></li>
											</ul>												
									</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		</div>
		<!-- /.main-content -->
		<script>
		
		</script>
	</body>

	</html>