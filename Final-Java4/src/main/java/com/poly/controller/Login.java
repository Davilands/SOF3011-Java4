package com.poly.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.dao.UserDAO;
import com.poly.dao.UserLogDAO;
import com.poly.model.User;
import com.poly.model.UserLog;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User currentUser = (User) session.getAttribute("currentUser");
		if(currentUser == null) {
			System.out.println("Chưa dang nhap");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else {
			System.out.println(currentUser.getUsername());
			request.getRequestDispatcher("/views/home.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Boolean remember = request.getParameter("remember") != null;
		
		UserDAO udao = new UserDAO();
		User user = udao.login(email, password);
		if(user == null) {
			request.setAttribute("error", true);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			System.out.println("That bai");
		} else {
			System.out.println("Thanh cong");
			UserLogDAO logDao = new UserLogDAO();
			HttpSession session = request.getSession();
			
			// thêm vào lịch sử đăng nhập
			UserLog ulog = new UserLog();
			ulog.setUser(user);
			ulog.setLogin_time(new Date());
			logDao.insert(ulog);
			
			List<UserLog> userLogs = logDao.findAll();
			session.setAttribute("logs", userLogs);
			
			if(remember) {
				session.setAttribute("currentUser", user);
			}
			
			session.setAttribute("username",user.getUsername() );
			request.getRequestDispatcher("/views/home.jsp").forward(request, response);
		}
	}

}
