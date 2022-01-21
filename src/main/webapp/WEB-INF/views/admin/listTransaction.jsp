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
								<div class ="col-md-6" style ="margin-top:8px;">
									<form:form action="" method="post">		
										<input class="col-md-4 w90" name = "search"/>
										<button class="col-md-2 h25	" type ="submit" style="background-color:#438eb9; margin-left:4px">Search</button>
									</form:form>
								</div>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container" style="margin-top:-15px;">
											<br>
											 <div class="dt-buttons btn-overlap btn-group">
												 <a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value='/admin/transaction/list?status=1' />'>
															<span>
																<i class="fa fa-check bigger-110 purple">Đã thanh toán</i>
															</span>
												</a> 
											</div>  
											 <div class="dt-buttons btn-overlap btn-group">
												 <a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value='/admin/transaction/list?status=0' />'>
															<span>
																<i class="fa fa-times bigger-110 purple">Chưa thanh toán</i>
															</span>
												</a> 
											</div>  
										</div>
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
														<th>Mã giao dịch</th>	
														<th>Mã hoá đơn</th>
														<th>Tên tài khoản</th>			
														<th>Trạng thái</th>														
														<th style = "width:44px">Xác nhận</th>
														
														
													</tr>
												</thead>
												<tbody>
														<c:forEach var="u" items="${transaction.content}" varStatus="loop">
															<tr>
																<td>${loop.index+1}</td>
																<td>${u.code}</td>
																<td>${u.order.id }</td>															
																<td>${u.user.userName }</td>	
																<c:if test="${u.status == false }">
																	<td>Chưa thanh toán</td>
																	<td>																
																		<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																			   title="Xác nhận thanh toán" href='<c:url value='/admin/transaction/verify/${u.id}' />'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																		</a>
																	</td>	
																</c:if>		
																<c:if test="${u.status == true }">
																	<td>Đã thanh toán</td>
																	<td>
																		<i class="fa fa-check bigger-110 purple"></i>
																	</td>
																	
																</c:if>	
																																										
															</tr>
														</c:forEach>
											
												</tbody>
											</table>
										<%-- <nav aria-label="Page navigation example">
											<ul class="pagination" >
												<c:if test="${category.number!= 0 }">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=0">First</a></li>
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=${category.number - 1}">Previous</a></li>
												</c:if>	
												<c:if test="${category.number < category.totalPages-1}">
												<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=${category.totalPages - 1}">Last</a></li>
												</c:if>					
												
												
											</ul>
										</nav>			 --%>											
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