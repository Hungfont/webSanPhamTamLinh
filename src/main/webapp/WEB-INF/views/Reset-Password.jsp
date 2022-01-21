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
				<div id="message" style="display:none; margin-top:8px;" class="alert alert-danger"></div>
                 <form:form action="${pageContext.request.contextPath }/password/forget/save" method = "post" modelAttribute="user">   
						     <br>
						     <br>
							<div class="form-group">
						       <label  class="col-md-3 control-label">Nhập mật khẩu mới:</label>
						       <div class="col-md-9">
						        	<form:input id="pass" path="password" type="password" class="form-control" value=""/>
						       </div>	      
						    </div>
						     <br>
						     <br>	  
						      <!-- <div class="form-group">
						       <label  class="col-md-3 control-label">Nhập lại mật khẩu mới:</label>
						       <div class="col-md-9">
						        	<input name="new-password" id="newPass" type="password" class="form-control" value=""/>
						       </div>	      
						    </div>  
						    <br>
						    <br>   -->
							<div class="form-group">
								<form:button class="btn btn-primary" type="submit" style="margin-left:310px">Đổi mật khẩu</form:button>
							</div>	
                 </form:form>	    				 
			</div>
		</div>
	</div>
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