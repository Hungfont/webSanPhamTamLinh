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
                        <form:form action="${pageContext.request.contextPath }/admin/category/save" modelAttribute="category" method = "POST">
                        	<form:hidden path="id"/>
                        	<div class="form-group">
						       <label  class="col-md-3 control-label">Tên thể loại</label>
						       <div class="col-md-9">
						        <form:input  class="form-control" path="name" value="${category.name }" Autocomplete="off" />
						      	<form:errors path="name" class="error" style = "color:red"/>
						       </div>
						     </div>
						     <br>
						     <br>
						     <br>
						   	<c:if test="${empty category.id }">
						   		 <div class="form-group">
							     <div class="col-md-offset-3 col-md-9">
							        <form:button Class="btn btn-primary" type = "submit">Thêm thể loại</form:button>
							     </div>
							</div>
						   	</c:if>
						   	<c:if test="${not empty category.id }">
						   		 <div class="form-group">
							     <div class="col-md-offset-3 col-md-9">
							        <form:button Class="btn btn-primary" type = "submit">Sửa thể loại</form:button>
							     </div>
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
