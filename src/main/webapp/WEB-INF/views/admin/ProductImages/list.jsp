<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách hình ảnh</title>
	</head>

	<body>
		<div class="main-content">
		<form action="#" id="formSubmit" method="get">
			
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#"></a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-left tableTools-container">
											<input placeholder="xin chào mọi người"/>
										</div>
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value='/admin/product/addImg' />'>
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
										${message}
										<div class="table-responsive">
											<table class="table table-bordered">
												<thead>
													<tr>
														<th width="30px">STT</th>
														<th width="400px;" style="text-align:center">Hình ảnh</th>
														<th>Caption</th>	
														<th style = "width:44px">Sửa</th>
														<th style = "width:44px">Xoá</th>
													</tr>
												</thead>
												<tbody>
														<c:forEach var="u" items="${productImages }" varStatus="loop">
															<tr>
																<td>${loop.index + 1}</td>
																<td><img src = "<c:url value='/images/${u.name }' />"  style= "width:100px; height:50px;text-align:center"/></td>
																<td> ${u.caption} </td>
																<td>																
																	<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																	   title="Cập nhật bài viết" href='<c:url value='/admin/category/edit/${u.id}' />'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																	</a>
																</td>
																<td>
																	<a id="btnDelete" href = "<c:url value='/admin/productImage/delete/${u.id}' />"
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