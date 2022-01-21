<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">		
				<div id="message" style="display:none;" class="alert alert-danger"></div>
                 <form action='<c:url value = "/reset-password"/>' method = "post">
					<div class="form-group">
						<br>
						<br>
						<label class="col-md-3 control-label">Email:</label>
						<div class="col-md-5">
							<input name="email" class="form-control" value="" />
						</div>
						<br> <br> 
					</div>
					<div class="form-group">
						<button class="btn btn-primary" type="submit"
							style="margin-left: 310px">Xác nhận</button>
					</div>
				</form>	    				 
			</div>
		</div>
	</div>
	<script type="text/javascript">
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