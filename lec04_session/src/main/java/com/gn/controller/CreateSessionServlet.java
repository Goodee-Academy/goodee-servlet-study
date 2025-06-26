package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/createSession")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public CreateSessionServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션 객체 생성
		// -> 매개변수 default = true : 세션이 없을 때 만드는 것에 동의
		HttpSession session = request.getSession();
		
		// 2. 세션 속성값 지정
		// (1) 새로운 세션인지 확인
		if (session.isNew()) {}
		
		// (2) 기존에 특정 key에 대한 value가 있는지 확인
		if (session.getAttribute("member_Id") == null) {}
		
		// 세션에 key와 value 지정
		session.setAttribute("member_Id", "user01");
		session.setMaxInactiveInterval(60 * 30); // 보통 30분을 많이 씀
		
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
