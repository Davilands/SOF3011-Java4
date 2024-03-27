<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div style="z-index: 999;" class="header" id="myHeader">
	<section class="ftco-section">
		<nav
			class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
			id="ftco-navbar">
			<div class="container">
				<a class="navbar-brand" style="width: 50px;" href="index"><img
					style="width: 100%;" src="images/unicorn.png" alt="" srcset=""></a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#ftco-nav" aria-controls="ftco-nav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="fa fa-bars"></span> Menu
				</button>
				<div class="collapse navbar-collapse" id="ftco-nav">
					<ul class="navbar-nav m-auto">
						<li class="nav-item active"><a href="index" class="nav-link">Trang
								chủ</a></li>
						<!-- <li class="nav-item dropdown">
								<a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Page</a>
								<div class="dropdown-menu" aria-labelledby="dropdown04">
									<a class="dropdown-item" href="">Page 1</a>
									<a class="dropdown-item" href="">Page 2</a>
									<a class="dropdown-item" href="">Page 3</a>
									<a class="dropdown-item" href="">Page 4</a>
								</div>
							</li> -->
						<li class="nav-item"><a href="favorites"
							class="nav-link">Yêu thích</a></li>

						<li class="nav-item"><a href="qna"
							class="nav-link">Hỏi đáp</a></li>
						<li class="nav-item"><a href="contact"
							class="nav-link">Liên hệ</a></li>
						<li class="nav-item"><a href="about"
							class="nav-link">Về chúng tôi</a></li>
					</ul>
					<ul class="navbar-nav">
					<c:choose>
					
						<c:when test="${not empty currentUser}">
							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown04"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">chào, ${currentLastname}</a>
							<div class="dropdown-menu" aria-labelledby="dropdown04">
								<c:if test="${currentUser.getRole() == true}" >
									<a	class="dropdown-item" href="listusers">Quản lí tài khoản</a>
								</c:if>
								<a	class="dropdown-item" href="history">Lịch sử xem</a>
								<a class="dropdown-item" href="logout">Đăng xuất</a> 
								<!-- <a class="dropdown-item" href="">Đăng xuất</a> -->
							</div>
						</li>
						</c:when>
						
						<c:otherwise>
							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown04"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tài khoản</a>
							<div class="dropdown-menu" aria-labelledby="dropdown04">
								<a class="dropdown-item" href="login">Đăng nhập</a> 
								<a class="dropdown-item" href="register">Đăng ký</a>
								<!-- <a class="dropdown-item" href="">Đăng xuất</a> -->
							</div>
						</li>
						</c:otherwise>
					</c:choose>
						
					</ul>
				</div>

			</div>
		</nav>
		<!-- END nav -->
	</section>
</div>
