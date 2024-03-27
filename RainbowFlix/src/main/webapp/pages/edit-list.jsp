<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<title>Rainbow Flix - Danh sách tài khoản</title>
<meta property="og:title" content="rainbow-flix">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="images/unicorn.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- icon -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

<!-- <link rel="icon" type="image/png" href="../assets/login/images/icons/favicon.ico" /> -->
<link rel="stylesheet" type="text/css"
	href="assets/login/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/login/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="assets/login/vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/login/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="assets/login/css/util.css">
<link rel="stylesheet" type="text/css" href="assets/login/css/main.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/qna.css">
<link rel="stylesheet" href="css/button/btn.css">
<link rel="stylesheet" href="assets/css/responsive.css">
<link rel="stylesheet" href="css/register.css">
</head>

<body>
	<div class="top-container">
		<h1>Rainbow Flix</h1>
		<p>Chúng tôi yêu phim, như yêu vợ bạn!</p>
	</div>


	<%@ include file="../common/header.jsp"%>

	<style>
.form-control {
	background-color: #343A40 !important;
	color: white !important;
}

/* PC */
@media ( min-width : 64em) {
	form {
		display: flex;
	}
	.col-sm-6 {
		padding: 0px 40px;
	}
}
</style>
	<div class="content">
		<form class="col-sm-12" action="/RainbowFlix/update-account" method="post">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="email">Tên đăng nhập:</label> <input
						style="background-color: #343A40 !important" type="text"
						class="form-control" placeholder="Enter email" name="username"
						readonly value="${account.username}">
				</div>
				<div class="form-group">
					<label for="pwd">Mật khẩu</label> <input type="text"
						class="form-control" placeholder="Enter password" name="password"
						value="${account.password }">
				</div>
			</div>

			<div class="col-sm-6">
				<div class="form-group">
					<label for="email">Họ và tên</label> <input
						style="background-color: #343A40 !important" type="text"
						class="form-control" placeholder="Enter email" name="fullname"
						value="${account.fullname}">
				</div>
				<div class="form-group">
					<label for="pwd">Email</label> <input type="email"
						class="form-control" placeholder="Email" name="email"
						value="${account.email }">
				</div>
				<a style="float: right; margin-top: 20px; margin-left: 20px" type="submit"
					class="btn btn-primary" href="<c:url value='/account?action=delete&username=${account.username}'/>">Xóa</a>
				<button style="float: right; margin-top: 20px;" type="submit"
					class="btn btn-primary">Cập nhật</button>
			</div>
		</form>
	</div>


	<%@ include file="../common/footer.jsp"%>





	<script src="assets/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="assets/login/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/login/vendor/select2/select2.min.js"></script>
	<script src="assets/login/vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>

	<script src="../assets/login/js/main.js"></script>

	<script>
		window.onscroll = function () { myFunction() };

		var header = document.getElementById("myHeader");
		var sticky = header.offsetTop;

		function myFunction() {
			if (window.pageYOffset > sticky) {
				header.classList.add("sticky");
			} else {
				header.classList.remove("sticky");
			}
		}
	</script>

	<script type="text/javascript">
		function isEmail(email) {
			var regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
			return regexp.test(String(email).toLowerCase());
		}
	
		function validate() {
			var username = document.getElementById('username').value;
			var email = document.getElementById('email').value;
			var fullname = document.getElementById('fullname').value;
			//console.log(document.getElementById'password');
			
			var password = document.getElementById('abc').value;
			
		 	if(username.length < 4 || username.length>8){
				alert("Tên đăng nhập phải từ 4 - 8 ký tự ");
				return;
			}
			 if(isEmail(email) == false){
				alert("Email không hợp lệ!");
				return;
			}
			
			if(fullname.length < 4 || fullname.length>25){
				alert("Họ và tên phải từ 4 - 25 ký tự!");
				return;
			}
			if(password.length<4 || password.length>8){
				alert("Mật khẩu phải từ 4 - 8 ký tự!");
				return;
			}
			alert("Đã gửi mã xác nhận đến email: "+email);
			
			
		}
	</script>
	<!-- 
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/main.js"></script> -->
</body>

</html>