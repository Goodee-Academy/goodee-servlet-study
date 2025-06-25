package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveNick")
public class SaveNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public SaveNicknameServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");
		
		Cookie cookie = new Cookie("nickname", nickname);
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
		
		response.sendRedirect("/practiceCookie");
	}

}
