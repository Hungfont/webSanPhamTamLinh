<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">		
				<form:form action="${pageContext.request.contextPath }/register/save" method = "POST" modelAttribute="user">
                        	<div class="form-group">
						       <label  class="col-md-3 control-label">Tên đăng nhập:</label>
						       <div class="col-md-9">
						        	<form:input path="userName" class="form-control" value="${user.userName}" autocomplete="off"/>
						        	<form:errors path="userName" Class="error" style = "color:red"/>
						       </div>
						     </div>
						     <br>
						     <br>
						     <br>
							<div class="form-group">
						       <label  class="col-md-3 control-label">Mật khẩu:</label>
						       <div class="col-md-9">
						        	<form:input path="password" class="form-control" value="${user.password}" autocomplete="off"/>
						        	<form:errors path="password" Class="error" style = "color:red"/>
						       </div>	      
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
						       <label  class="col-md-3 control-label">Họ và tên:</label>
						       <div class="col-md-9">
						        	<form:input path="fullName" class="form-control" value="${user.fullName}" autocomplete="off"/>
						        	<form:errors path="fullName" Class="error" style = "color:red"/>
						       </div>
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
						       <label  class="col-md-3 control-label">Email:</label>
						       <div class="col-md-9">
						      	 <form:input path="email" class="form-control" value="${user.email}" autocomplete="off"/>	
						      	 <form:errors path="email" Class="error" style = "color:red"/>	
						       </div>
						     </div>
						     <br>
						     <br>	   
							<div class="form-group">
								<form:button class="btn btn-primary" type="submit" style="margin-left:310px"> Đăng ký</form:button>
							</div>		    				 
                        </form:form>
			</div>
		</div>
	</div>
</body>
</html>