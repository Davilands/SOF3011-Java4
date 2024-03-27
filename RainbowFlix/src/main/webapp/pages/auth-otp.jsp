<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Rainbow Flix - Đăng ký</title>
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

	<div class="content">
		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100">
					<div class="login100-pic js-tilt" data-tilt>
						<img src="assets/login/images/logo-3d.png" alt="IMG">
					</div>

					<form class="login100-form validate-form" action="/RainbowFlix/auth" method="post">
						<span class="login100-form-title"> NHẬP MÃ XÁC NHẬN ĐƯỢC
							GỬI QUA EMAIL </span>

						<div class="wrap-input100 validate-input">
							<input class="input100" type="text" name="username"
								placeholder="Tên đăng nhập" value="${username}" readonly>
								
								<input style="display: none" class="input100" type="text" name="fullname"
								placeholder="Tên đăng nhập" value="${fullname}" readonly> 
								<input style="display: none" class="input100" type="text" name="password"
								placeholder="Tên đăng nhập" value="${password}" readonly> 
								
								<span
								class="focus-input100"></span> <span class="symbol-input100">
								<!-- <i class="fa fa-lock" aria-hidden="true"></i> --> <i
								class='bx bxs-user' aria-hidden="true"></i>
							</span>
						</div>
						<div class="wrap-input100 validate-input">
							<input class="input100" type="text" name="email"
								placeholder="Email" value="${email }" readonly> <span
								class="focus-input100"></span> <span class="symbol-input100">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</span>
						</div>
						<div class="wrap-input100 validate-input">
							<input class="input100" type="text" name="otp"
								placeholder="Mã xác nhận"> <span class="focus-input100"></span>
							<span class="symbol-input100"> <i class='bx bx-code-alt'></i>
							</span>
						</div>

						<div class="container-login100-form-btn">
							<button class="login100-form-btn">Xác nhận</button>
						</div>
						<div class="text-center p-t-136">
							<a class="txt2" href="#"> Bạn đã có tài khoản? Đăng nhập <i
								class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
							</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- <div class="content">
		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100">
					

					<form class="validate-form">
						<div class="left">
							<span class="login100-form-title">
								ĐĂNG KÝ
							</span>

							<div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
								<input class="input100" type="text" name="email" placeholder="Email">
								<span class="focus-input100"></span>
								<span class="symbol-input100">
									<i class="fa fa-envelope" aria-hidden="true"></i>
								</span>
							</div>

							<div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
								<input class="input100" type="text" name="email" placeholder="Ngày sinh">
								<span class="focus-input100"></span>
								<span class="symbol-input100">
									<i class='bx bxs-calendar-heart' aria-hidden="true"></i>
								</span>
							</div>


						</div>

						<div class="right">
							<span style="opacity: 0;" class="login100-form-title">
								ĐĂNG NHẬP
							</span>

							<div class="wrap-input100 validate-input" data-validate="Password is required">
								<input class="input100" type="password" name="pass" placeholder="Tên đăng nhập">
								<span class="focus-input100"></span>
								<span class="symbol-input100">
									<i class='bx bxs-user' aria-hidden="true"></i>
								</span>
							</div>

							<div class="wrap-input100 validate-input" data-validate="Password is required">
								<input class="input100" type="password" name="pass" placeholder="Mật khẩu">
								<span class="focus-input100"></span>
								<span class="symbol-input100">
									<i class="fa fa-lock" aria-hidden="true"></i>
								</span>
							</div>

							<div class="container-login100-form-btn">
								<button class="login100-form-btn">
									Đăng ký
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div> -->

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