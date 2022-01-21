<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>

</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">                  	
                         <form:form action="${pageContext.request.contextPath }/admin/product/save" 
                        method = "POST" modelAttribute="product" enctype="multipart/form-data" >           
                        	<form:hidden path="id"/>
                        	 <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mã sản phẩm</label>
                                <div class="col-sm-9">
                                    <form:input  class="form-control"  path="sku" value="${product.sku}"/>
                              		<form:errors path="sku" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<hr>
                        	<hr>
                        	<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                                <div class="col-sm-9">
                                    <form:input  class="form-control"  path="title" value="${product.title}"/>
                              		<form:errors path="title" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<hr>
                        	<hr>
                        	<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tên hiển thị</label>
                                <div class="col-sm-9">
                                    <form:input  class="form-control"  path="metatitle" value="${product.metatitle}"/>
                              		<form:errors path="metatitle" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<hr>
                        	<hr>
                        	<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tóm tắt</label>
                                <div class="col-sm-9">
                                    <form:textarea rows="5"  class="form-control"  path="summary" value="${product.summary}"/>
                              		<form:errors path="summary" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<hr>
                        	<hr>
                        	<hr>
                        	<hr>
                        	<hr>
                        	<hr>
                        	<div class="form-group">
						       <label class= "col-md-3">Hình ảnh: </label>
						       <div class="col-md-9">
						        <input type="file" name="image" accept="image/png, image/jpeg" value="C:/Users/Admin/eclipse-workspace/spring-mvc/src/main/webapp/images/${product.thumbnail}"/>
						      	<form:errors path="thumbnail" Class="error" style = "color:red"/>
						       </div>
						     </div>
                        	<br>
                        	<br>
                        	<br>
                        	<br>
                        	<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Giá</label>
                                <div class="col-sm-9">
                                    <form:input  type="number" class="form-control"  path="price" value=""/>
                              		<form:errors path="price" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<br>
                        	<br>
                        	<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Số lượng</label>
                                <div class="col-sm-9">
                                    <form:input  type="number" class="form-control"  min="100" path="quantity" value="${product.quantity}"/>
                              		<form:errors path="quantity" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<br>
                        	<br>
                        	<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Giảm giá</label>
                                <div class="col-sm-9">
                                    <form:input  type="number" class="form-control"  path="discount" value="${product.discount}"/>
                              		<form:errors path="discount" Class="error" style = "color:red"/>
                                </div>
                            </div>
                        	<br>
                        	<br>
                        	<div class="form-group">
							    <label class="col-md-3">Thể loại</label>
							    <div class= "col-md-9">
							    	<form:select class="form-control" path="categoryId">
							      	<form:option value="-1" label="-- Chọn thể loại --" />
							      	<form:options items="${categories}" itemValue="id" itemLabel="name" />
							    </form:select>
							    	<form:errors path="categoryId" Class="error" style = "color:red"/>
							    </div>
						 	 </div>
                        		<br>
                        		<br>
                        		<c:if test="${empty product.id}">
									<div class="form-group">
										<form:button class="btn btn-primary" type="submit"> Thêm sản phẩm</form:button>
									</div>
								</c:if>
						    	<c:if test="${not empty product.id}">
									<div class="form-group">
										<form:button class="btn btn-primary" type="submit"> Sửa sản phẩm</form:button>
									</div>
								</c:if>
                        </form:form>
                        
                </div>
            </div>
        </div>
    </div>
</div>
<script>
</script>
</body>
</html>
