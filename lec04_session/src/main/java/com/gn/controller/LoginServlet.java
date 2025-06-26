package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.gn.dto.Account;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public LoginServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 하드코딩 데이터
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		
		String inputId = request.getParameter("inputId");
		String inputPw = request.getParameter("inputPw");
		
		if (correctId.equals(inputId) && correctPw.equals(inputPw)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("account", new Account(inputId, name));
			session.setMaxInactiveInterval(60 * 30);
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/");
		}
	}

}
