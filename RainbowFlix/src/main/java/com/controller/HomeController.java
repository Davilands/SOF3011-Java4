package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.constant.SessionAttribute;
import com.dao.AccountDAO;
import com.dao.HistoryDAO;
import com.dao.VideoDAO;
import com.model.Account;
import com.model.History;
import com.model.Video;

/**
 * Servlet implementation class Home
 */
@WebServlet(urlPatterns = { "/index", "/favorites", "/history" ,"/qna", "/listusers", "/contact", "/about", "/share"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private HistoryDAO historyDao = new HistoryDAO();
    private VideoDAO videoDao = new VideoDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
			case "/index":
				doGetIndex(request, response);
				break;
			case "/favorites":
				doGetFavorites(session, request, response);
				break;
			case "/history":
				doGetHistory(session, request, response);
				break;
			case "/qna":
				doGetQna(request, response);
				break;
			case "/contact":
				doGetContact(request, response);
				break;
			case "/about":
				doGetAbout(request, response);
				break;
			case "/listusers":
				doGetListUsers(session, request, response);
				break;
			case "/share":
				doGetShare(session, request, response);
				break;
		}
	}
	
	protected void doGetQna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pages/qna.jsp").forward(request, response);
	}
	
	protected void doGetContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pages/contact.jsp").forward(request, response);
	}
	
	protected void doGetAbout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pages/about.jsp").forward(request, response);
	}
	
	protected void doGetListUsers(HttpSession sesson, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account account = (Account) sesson.getAttribute(SessionAttribute.CURRENT_USER);
		
		if(account==null || !account.getRole()) {
			request.setAttribute("loginyet", true);
			request.getRequestDispatcher("/pages/list-user.jsp").forward(request, response);
		} else {
			AccountDAO accDao = new AccountDAO();
			List<Account> acc = accDao.findUser();
			request.setAttribute("loginyet", false);
			request.setAttribute("account", acc);
			request.getRequestDispatcher("/pages/list-user.jsp").forward(request, response);
		}
		
	}
	
	protected void doGetIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		try {
			if((Boolean)session.getAttribute(SessionAttribute.STATUS_LOGOUT) == true) {
				request.setAttribute("logoutStatus", 1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		System.out.println((Boolean)session.getAttribute(SessionAttribute.STATUS_LOGOUT));
		
		VideoDAO vidDao = new VideoDAO();
		List<Video> videos = vidDao.findAll();
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doGetHistory(HttpSession sesson, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = (Account) sesson.getAttribute(SessionAttribute.CURRENT_USER);
		if(account==null) {
			request.setAttribute("loginyet", true);
			request.getRequestDispatcher("/pages/history.jsp").forward(request, response);
		}
		System.out.println("get history with user "+account.getUsername());
		List<History> histories = historyDao.findHistoryByUser(account.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/pages/history.jsp").forward(request, response);
	}
	
	protected void doGetFavorites(HttpSession sesson, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = (Account) sesson.getAttribute(SessionAttribute.CURRENT_USER);
		if(account==null) {
			request.setAttribute("loginyet", true);
			request.getRequestDispatcher("/pages/favorites.jsp").forward(request, response);
		}
		List<History> histories = historyDao.findHistoryByUserAndIsLiked(account.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/pages/favorites.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Tro toi trang index");
		doGet(request, response);
	}
	
	protected void doGetShare(HttpSession sesson, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account account = (Account) sesson.getAttribute(SessionAttribute.CURRENT_USER);
		
		request.getRequestDispatcher("/pages/share-video.jsp").forward(request, response);
		
	}

}
