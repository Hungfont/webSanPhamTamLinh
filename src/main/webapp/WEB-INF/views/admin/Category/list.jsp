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
									<form action="" method="post">		
										<input class="col-md-4 w90" name = "keyword"/>
										<button class="col-md-2 h25	" type ="submit" style="background-color:#438eb9; margin-left:4px">Search</button>
									</form>
								</div>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value='/admin/category/create' />'>
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
										<div id="message" style="display:none;" class="alert alert-danger"></div>
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th>STT</th>
														<th>Tên thể loại </th>		
														<th style = "width:44px">Sửa</th>
														<th style = "width:44px">Xoá</th>
													</tr>
												</thead>
												<tbody>
														<c:forEach var="u" items="${category.content}" varStatus="loop">
															<tr>
																<td>${loop.index+1}</td>
																<td>${u.name }</td>
															
																<td>																
																	<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																	   title="Cập nhật bài viết" href='<c:url value='/admin/category/edit/${u.id}' />'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																	</a>
																</td>
																<td>
																	<a id="btnDelete" href = "<c:url value='/admin/category/delete/${u.id}' />"
																		class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																		<span>
																			<i class="fa fa-trash-o bigger-110 pink"></i>
																		</span>
																	</a>
																</td>
															</tr>
														</c:forEach>
											
												</tbody>
											</table>
										<nav aria-label="Page navigation example">
											<ul class="pagination" >
												
													<c:if test="${category.number!=0 }">
														<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=0">First</a></li>
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=${category.number - 1}">Previous</a></li>
													</c:if>
																
											<%-- 	<c:if test="${model.number < model.totalPages }">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?page=0">${model.number+1}</a></li>
												</c:if>	 --%>	
												
												<c:if test="${category.number < category.totalPages -1 }">
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=${category.number + 1}">Next</a></li>
													<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/category/list?page=${category.totalPages - 1}">Last</a></li>
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