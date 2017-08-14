package com.fulllearn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Dashboard extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		welcomeUser(req, resp);

	}

	private void welcomeUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		try{
			if (session!=null && session.getAttribute("user")!= null) {
		
		
			req.getRequestDispatcher("/jsp/dashboard.jsp").forward(req, resp);
			
		} else {
			
			req.getRequestDispatcher("WEB-INF/html/login.html").forward(req, resp);
		}
		}catch(Exception e){
			resp.getWriter().println("Try again!.");
			
		}
	}

}
