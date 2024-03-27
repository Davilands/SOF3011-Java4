<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
	<title>Rainbow Flix - Trang chủ</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="../images/unicorn.png" type="image/x-icon">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<!-- icon -->
	<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/index.css">
	<link rel="stylesheet" href="../css/button/btn.css">
	<link rel="stylesheet" href="../assets/css/responsive.css">
	<link rel="stylesheet" href="../css/footer.css">
	<link rel="stylesheet" href="../css/list.css">
</head>
<style>

</style>
</head>

<body>

	<div class="top-container">
		<h1>Rainbow Flix</h1>
		<p>Chúng tôi yêu phim, như yêu vợ bạn!</p>
	</div>

		
<%@ include file="../common/header.jsp"%>

	<div class="content">

		<div class="hot">
			<h1 style="z-index: -999;">Danh sách phim</h1>
			<div class="list-video">
				<div class="row">
					<div class="item">
						<img src="../images/thumnail/boku-no-pico.jpg" alt="">
						<div class="name">
							<p>Boku no Piko | My Pico | ぼ く の</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
							<div class="status">
								<p class="like">
									<i class='bx bxs-like'></i> 245
								</p>
								<p class="dislike">
									<i class='bx bxs-dislike'></i> 23
								</p>
							</div>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/my-hero-academia.jpg" alt="">
						<div class="name">
							<p>My Hero Accademia - Học viện anh hùng</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/dr-stone.jpg" alt="">
						<div class="name">
							<p>Dr Stone - Tiến sĩ đá</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="item">
						<img src="../images/thumnail/nang-dau-hallowee.jpg" alt="">
						<div class="name">
							<p>Nàng dâu halloween - Conan thám tử lừng danh</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/conan-kid.jpg" alt="">
						<div class="name">
							<p>Sherlock Holmes tái sinh - Conan thám tử lừng danh</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/captain-america-civil-war.jpg" alt="">
						<div class="name">
							<p>Captain America Civil War Full 4K</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/spiderman-no-way-home.jpg" alt="">
						<div class="name">
							<p>Spider-Man No Way Home - Full 4K</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/mugen-train.jpg" alt="">
						<div class="name">
							<p>Demon Slayer Mugen Train</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/yugioh-the-dark-side-of-dimensions.jpg" alt="">
						<div class="name">
							<p>Yugioh The Dark Side Of Dimensions</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/naruto-shippuden.jpg" alt="">
						<div class="name">
							<p>Naruto Shippuden</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/your-name.jpg" alt="">
						<div class="name">
							<p>Your Name</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>
					<div class="item">
						<img src="../images/thumnail/mo-dom-dom.jpg" alt="">
						<div class="name">
							<p>Mộ Đom Đóm</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>

					<div class="item">
						<img src="../images/thumnail/5cm-s.jpg" alt="">
						<div class="name">
							<p>5cm/s - Shinkai Makoto</p>
						</div>
						<div class="views">
							<p><i class='bx bx-show-alt'></i> 345.678.677 lượt xem</p>
						</div>
						<div class="status">
							<p class="like">
								<i class='bx bxs-like'></i> 245
							</p>
							<p class="dislike">
								<i class='bx bxs-dislike'></i> 23
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

		
<%@ include file="../common/footer.jsp"%>

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
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/main.js"></script>

</body>

</html>