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
                    	<c:if test="${not empty message}">
                            <div class="alert alert-${alert}">
                                    ${message}
                            </div>
                        </c:if> 
                        <form:form action="${pageContext.request.contextPath }/admin/product/saveImg" 
                        method = "POST" enctype="multipart/form-data" modelAttribute="image">           
                        	 <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Caption:</label>
                                <div class="col-sm-9">
                                    <form:input  class="form-control"  path="caption"/>   
                                    <form:errors path="caption" Class="error" style = "color:red"/>         
                                </div>
                            </div>
                        	<hr>
                        	<hr>
                        	<div class="form-group">
						       <label class= "col-md-3">Hình ảnh: </label>
						       <div class="col-md-9">
						        <input type="file" name="image" accept="image/png, image/jpeg" />
						       </div>
						     </div>
						     <hr>
						     <hr>
						     <div class = "form-group">
						     	<button class ="btn btn-primary" type = "submit"> Thêm hình ảnh</button>
						     </div>
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
