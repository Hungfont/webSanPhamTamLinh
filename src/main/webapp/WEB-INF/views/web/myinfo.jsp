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

				<div class="form-group">
					<label class="col-md-3 control-label">Tên đăng nhập:</label>
					<div class="col-md-9">
						<input name="userName" class="form-control"
							value="${user.userName}"  disabled="disabled"/>
				
					</div>
				</div>
				<br> <br> <br>
				<div class="form-group">
					<label class="col-md-3 control-label">Mật khẩu:</label>
					<div class="col-md-9">
						<input name="password" class="form-control"
							value="${user.password}" disabled="disabled" />
					</div>
				</div>
				<br> <br>
				<div class="form-group">
					<label class="col-md-3 control-label">Họ và tên:</label>
					<div class="col-md-9">
						<input name="fullName" class="form-control"
							value="${user.fullName}"disabled="disabled"/>
						
					</div>
				</div>
				<br> <br>
				<div class="form-group">
					<label class="col-md-3 control-label">Email:</label>
					<div class="col-md-9">
						<input name="email" class="form-control"
							value="${user.email}" disabled="disabled"/>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>