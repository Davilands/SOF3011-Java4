package com.controller;

import com.model.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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
import com.dao.HistoryDAO;
import com.dao.VideoDAO;

/**
 * Servlet implementation class VideoController
 */
@WebServlet(urlPatterns = { "/video", "/share-video"})
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    HistoryDAO his = new HistoryDAO();
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		
		switch(actionParam) {
			case "watch":
				doGetWatch(session,id, request, response);
				break;
			case "like":
				System.out.println("call get like");
				doGetLike(session,id, request, response);
				break;
			case "share":
				//System.out.println("call get like");
				doGetShare(session,id, request, response);
				break;
		}
	}
	
	protected void doGetWatch(HttpSession session,String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoDAO videoDao = new VideoDAO();
		System.out.println("id param = "+id);
		Video vid = videoDao.findById(Long.valueOf(id));
		request.setAttribute("video", vid);
		

		Account currentUser = (Account) session.getAttribute(SessionAttribute.CURRENT_USER);
		if(currentUser != null) {
			boolean insert = his.insert(currentUser, vid);
			System.out.println("Insert history, is liked: "+insert);
			request.setAttribute("flagLike",insert);
		}
		
		System.out.println("hello"+vid.getHref());
		List<Video> top4 =  videoDao.top4Video();
		request.setAttribute("topvid", top4);
		request.getRequestDispatcher("pages/videodetail.jsp").forward(request, response);
	}
	
	
	
	protected void doGetLike(HttpSession session,String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("like action");
		response.setContentType("application/json");
		Account currentUser = (Account) session.getAttribute(SessionAttribute.CURRENT_USER);
		boolean result = his.updateStatusIsLiked(currentUser, id);
		if (result == true) {
    		response.setStatus(204);
    	} else {
    		response.setStatus(400);
    	}
	}
	
	protected void doGetShare(HttpSession session,String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("share action");
		response.setContentType("application/json");
		Account currentUser = (Account) session.getAttribute(SessionAttribute.CURRENT_USER);
		request.setAttribute("url", "http://localhost:8080/RainbowFlix/video?action=watch&id="+id);
		request.setAttribute("user", currentUser);
		
		request.getRequestDispatcher("pages/share-video.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public static boolean sendmail(String to, String subjecta, String from, String bodya, String link) {
		// Đọc thông tin email từ form
		String subject = "Bạn có lời mời xem video từ: "+from;
		String body = "Nội dung: "+bodya;
		body += "\nLink video :"+link;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String to = request.getParameter("email");
		String from = request.getParameter("shareby");
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");
		String url = request.getParameter("url");
		String id = url.substring(url.lastIndexOf("=")+1);
		boolean send = sendmail(to,subject,from,body,url);
		if(send) {
			response.sendRedirect("/RainbowFlix/video?action=watch&id="+id);
		}
	}

}
