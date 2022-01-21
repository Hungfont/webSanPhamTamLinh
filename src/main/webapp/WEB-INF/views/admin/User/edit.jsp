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
                        <form:form action="${pageContext.request.contextPath }/admin/user/save" method = "POST" modelAttribute="user">
                        	<form:hidden path="id"/>
                        	<div class="form-group">
						       <label  class="col-md-3 control-label">UserName:</label>
						       <div class="col-md-9">
						        	<form:input path="userName" class="form-control" value="${user.userName}"/>
						        	<form:errors path="userName" Class="error" style = "color:red"/>
						       </div>
						     </div>
						     <br>
						     <br>
						     <br>
							<div class="form-group">
						       <label  class="col-md-3 control-label">Password:</label>
						       <div class="col-md-9">
						        	<form:input path="password" class="form-control" value="${user.password}"/>
						        	<form:errors path="password" Class="error" style = "color:red"/>
						       </div>
						      
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
						       <label  class="col-md-3 control-label">Họ và tên:</label>
						       <div class="col-md-9">
						        	<form:input path="fullName" class="form-control" value="${user.fullName}"/>
						        	<form:errors path="fullName" Class="error" style = "color:red"/>
						       </div>
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
						       <label  class="col-md-3 control-label">Email:</label>
						       <div class="col-md-9">
						      	 <form:input path="email" class="form-control" value="${user.email}"/>	
						      	 <form:errors path="email" Class="error" style = "color:red"/>	
						       </div>
						     </div>
						     <br>
						     <br>	
	
						     <div class="form-group">
							    <label class="col-md-3">Vai trò</label>
							    <div class= "col-md-9">
							    	<form:select class="form-control" path="roleCode">
							      	<form:option value="" label="-- Chọn thể loại --" />
							      	<form:options items="${roles}" itemValue="code" itemLabel="name" />
							    </form:select>
							    </div>
						 	 </div>
						 	 <br>
						 	 <br>
						     <c:if test="${empty user.id}">
									<div class="form-group">
											<form:button class="btn btn-primary" type="submit" style="margin-left:275px"> Thêm tài khoản</form:button>
									</div>
							</c:if>	
							  <c:if test="${not empty user.id}">
									<div class="form-group">
											<form:button class="btn btn-primary" type="submit" style="margin-left:275px"> Sửa tài khoản</form:button>
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
