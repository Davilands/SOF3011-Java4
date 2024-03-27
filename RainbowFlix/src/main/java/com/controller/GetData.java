package com.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.dao.*;
import com.model.*;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountDAO dao = new AccountDAO();
		dao.delete("teonv");
//		System.out.println("findall");
//		List<Account> list = dao.findAll();
//
//		System.out.println("get data success");	
//		for(Account acc:list) {
//			System.out.println(acc.getFullname());
//		}
		
		VideoDAO vidDao = new VideoDAO();
		
		//System.out.println(vidDao.findByHref("https://www.youtube.com/embed/oh-gBJMg0kE").getDescription());
		
		HistoryDAO hisDao = new HistoryDAO();
		//System.out.println(hisDao.findHistoryByUserAndIsLiked("dangth").get(0).getClass());
//		
//		for(History h:hisDao.findAll()) {
//			System.out.println(h.getViewsDate());
//		}
//		
//		ShareVideoDAO sharevidDAO = new ShareVideoDAO();
//		for(ShareVideo sv: sharevidDAO.findAll()) {
//			System.out.println(sv.getEmail());
//		}
//		
		
		//System.out.println(hisDao.updateStatusIsLiked(dao.findById("annv"), "2"));
		ShareVideoDAO sd = new ShareVideoDAO();
		List<ShareVideo> shv = sd.findByUsername("teonv");
		for(ShareVideo sv : shv) {
			System.out.println(sv.getEmail());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
