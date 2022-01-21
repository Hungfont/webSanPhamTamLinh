<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">	
							Tài khoản hoặc mật khẩu không đúng.
					</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">	
							Bạn không có quyền truy cập vào trang này
					</div>
				</c:if>
				${message}
				<form action="j_spring_security_check" id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
					</div>
					<button type="submit" class="btn btn-primary" >Đăng nhập</button>	
				</form>
				<a href="<c:url value="/dang-nhap/email"/>" style="text-decoration:none;color:grey; margin-right:155px; font-size: 13px"><i>Quên mật khẩu?</i></a>
				<br>
				<a>Bạn mới biết đến website?<strong><a href="<c:url value='/dang-ky' />" style="text-decoration:none;color:red;">Đăng ký</a></strong></a>
			</div>
		</div>
	</div>
</body>
</html>