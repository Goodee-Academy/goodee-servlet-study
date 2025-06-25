package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public ChangePageServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie myCookie = new Cookie("visit_count", "1");
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if ("visit_count".equals(cookie.getName())) {
					myCookie = new Cookie("visit_count", String.valueOf(Integer.parseInt(cookie.getValue()) + 1));
				}
			}
		}
		
		myCookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(myCookie);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/countPage.jsp");
		request.setAttribute("visitCount", myCookie.getValue());
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
