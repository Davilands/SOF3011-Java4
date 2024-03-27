package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.constant.SessionAttribute;
import com.dao.AccountDAO;
import com.dao.HistoryDAO;
import com.dao.ShareVideoDAO;
import com.model.Account;
import com.model.History;
import com.model.ShareVideo;

/**
 * Servlet implementation class Account
 */
@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/auth", "/account", "/update-account" })
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	String maXacNhan = "";
	
	public static String randomOTP(){
        // create instance of Random class
        Random rand = new Random();
   
        // Generate random integers in range 0 to 999
        int randInt = rand.nextInt(1000000);
   
        // Print random integers
        return randInt+"";
    }

	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean sendmail(String to, String otp) {
		// Đọc thông tin email từ form
		String subject = "Hệ thống gửi email xác nhận";
		String body = "Mã xác nhận của bạn là: "+otp;

		// Thiết lập các thuộc tính của email
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		// Đăng nhập vào tài khoản email gửi
//		        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//		            protected PasswordAuthentication getPasswordAuthentication() {
//		                return new PasswordAuthentication("ryzenV.contact@gmail.com", "ngemudntvdmhwwju");
//		            }
//		        });
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "Contact.RainbowFlix@gmail.com";
				String password = "qdddlgirbcisthfb";
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Tạo message và thiết lập thông tin
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("your.email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			// Gửi email
			System.out.println("Dang gui!");
			Transport.send(message);

			// Chuyển hướng về trang thành công
			System.out.println("Gui thanh cong!");
			return true;
		} catch (MessagingException e) {
			// Chuyển hướng về trang thất bại với thông báo lỗi
			System.out.println("Loi!");
			return false;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(request, response);
			break;
		case "/register":
			doGetRegister(request, response);
			break;
		case "/logout":
			doGetLogout(session, request, response);
			break;
		}
		
		String actionParam = request.getParameter("action");
		System.out.println("Action Param: "+actionParam);
		if(actionParam == null) {
			return;
		}
		if(actionParam.equals("edit")) {
			doGetEdit(session, request, response);
		}
		if(actionParam.equals("delete")) {
			doPostDelete(session, request, response);
		}
		if(actionParam.equals("update")) {
			doPostUpdate(session, request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acctionParam = request.getParameter("action");
		System.out.println("post action param: "+acctionParam);
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		System.out.println("path post method: "+path);
		switch (path) {
			case "/login":
				doPostLogin(session, request, response);
				break;
			case "/register":
				doPostRegister(request, response);
				break;
			case "/logout":
				doGetLogout(session, request, response);
				break;
			case "/auth":
				doPostAuth(session, request, response);
				break;
			case "/edit":
				doPostEdit(session, request, response);
				break;
			case "/delete":
				doPostDelete(session, request, response);
				break;
			case "/update-account":
				doPostUpdate(session, request, response);
				break;
		}
	}

	protected void doGetLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}

	protected void doPostLogin(HttpSession sesson, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDAO accDao = new AccountDAO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String status = accDao.login(username, password);
		/*
		 * return a String upperCase when account is ADMIN return a String lowerCase
		 * when account is user return a String is empty when account do not exits
		 */
		System.out.println(status);
		if (!status.equals("")) {
			System.out.println(status);
			String lastName = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
			Account account = accDao.findById(username);
			sesson.setAttribute(SessionAttribute.CURRENT_USER, account);
			sesson.setAttribute(SessionAttribute.CURRENT_LASTNAME, lastName);

			response.sendRedirect("index");
		} else {
			response.sendRedirect("login");
		}

		// request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}
	
	protected void doPostAuth(HttpSession sesson, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xacThuc = request.getParameter("otp");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		System.out.println(xacThuc+":"+this.maXacNhan);
		if(xacThuc.equals(this.maXacNhan)) {
			AccountDAO accDao = new AccountDAO();
			accDao.insert(username, email, fullname, password);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		request.getRequestDispatcher("pages/register.jsp").forward(request, response);
		
	}

	protected void doGetLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Dang xuat");
		session.removeAttribute(SessionAttribute.CURRENT_USER);
		session.removeAttribute(SessionAttribute.CURRENT_LASTNAME);
		session.setAttribute(SessionAttribute.STATUS_LOGOUT, true);
		response.sendRedirect("index");
	}

	protected void doGetRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("pages/register.jsp").forward(request, response);
	}

	protected void doPostRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		//sendmail(email);

		if (username.length() < 4 || username.length() > 8) {
			response.setStatus(204);
		}
		if (password.length() < 4 || password.length() > 8) {
			response.setStatus(204);
		}
		if (fullname.length() < 4 || fullname.length() > 25) {
			response.setStatus(204);
		}
		if (!isValid(email)) {
			response.setStatus(204);
		}

		AccountDAO accDao = new AccountDAO();
		if (accDao.findById(username) != null) {
			System.out.println("datontai");
			// request.getRequestDispatcher("pages/register.jsp").forward(request,
			// response);
			response.setStatus(204);
		} else {
			String authOtp = randomOTP();
			this.maXacNhan = authOtp;
			sendmail(email, authOtp);
			//accDao.insert(username, email, fullname, password);
			//System.out.println("Them thanh cong");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("fullname", fullname);
			request.setAttribute("email", email);
			request.setAttribute("otp", authOtp);
			
			request.getRequestDispatcher("/pages/auth-otp.jsp").forward(request, response);
		}
	}
	
	protected void doGetEdit(HttpSession sesson, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDAO accDao = new AccountDAO();
		String username = request.getParameter("username");
		Account acc = accDao.findById(username);
		request.setAttribute("account", acc);
		request.getRequestDispatcher("pages/edit-list.jsp").forward(request, response);
	}
	
	protected void doPostDelete(HttpSession sesson, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		
		//Xóa những dữ liệu trong bảng share video
		ShareVideoDAO sd = new ShareVideoDAO();
		List<ShareVideo> shv = sd.findByUsername(username);
		for(ShareVideo sv : shv) {
			//System.out.println(sv.getEmail());
			sd.delete(sv.getId());
		}
		
		//xóa những dữ liệu trong bảng history
		HistoryDAO hisDao = new HistoryDAO();
		List<History> his = hisDao.findHistoryByUser(username);
		for(History hist: his) {
			hisDao.delete(hist.getId());
		}
		
		//xóa dữ liệu bảng account
		AccountDAO accDao = new AccountDAO();
		accDao.delete(username);
		System.out.println("Xóa tài khoản "+username+" thành công");
		response.sendRedirect("/listusers");
	}
	
	protected void doPostUpdate(HttpSession sesson, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDAO accDao = new AccountDAO();
		
		String username = request.getParameter("username");
		System.out.println(username);
		Account acc = accDao.findByUsername(username);
		acc.setEmail(request.getParameter("email"));
		acc.setFullname(request.getParameter("fullname"));
		acc.setPassword(request.getParameter("password"));
		
		accDao.update(acc);
	}
	
	protected void doPostEdit(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
