<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách bài viết</title>
	</head>

	<body>
		<div class="main-content">
		<form action="#" id="formSubmit" method="get">
			
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang chủ</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
							<div class ="col-md-6" style ="margin-top:8px;">
									<form>
										<input class="col-md-4 w90" name = "keyword"/>
										<button class="col-md-2 h25 search" type ="submit" style="background-color:#primary; margin-left:4px">Search</button> 
									</form>
								</div>
							<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-left tableTools-container"></div>
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value ="/admin/user/create"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th>Tên đăng nhập</th>
														<th>Mật khẩu</th>
														<th>Họ và tên</th>
														<th>Email</th>
														<th>Trạng thái</th>
														 <th style = "width:44px">Sửa</th> 
														
													</tr>
												</thead>
												<tbody>
													<c:forEach varStatus="loop" var="u" items="${user.content}">
														<tr>
															<td>${u.userName}</td>
															<td>${u.password}</td>
															<td>${u.fullName}</td>
															<td>${u.email}</td>
															<c:if test="${u.status == 1 }">
																<td>Hoạt động</td>
															</c:if>
															<c:if test="${u.status == 0 }">
																<td>Ngừng Hoạt động</td>
															</c:if>
															 <td>																
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Cập nhật bài viết" href="${pageContext.request.contextPath }/admin/user/edit/${u.id}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																</a>
															</td>														
														</tr>
													</c:forEach>
											
												</tbody>
											</table>
											<nav aria-label="Page navigation example">
											<ul class="pagination" >
												<c:if test="${user.number!= 0 }">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/user/list?page=0">First</a></li>
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/user/list?page=${user.number - 1}">Previous</a></li>
												</c:if>					
											<%-- 	<c:if test="${model.number < model.totalPages }">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?page=0">${model.number+1}</a></li>
												</c:if>	 --%>	
												<c:if test="${user.number < user.totalPages-1}">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/user/list?page=${user.number + 1}">Next</a></li>
												<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/user/list?page=${user.totalPages - 1}">Last</a></li>
												</c:if>
												
												
											</ul> 
										</nav>														
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