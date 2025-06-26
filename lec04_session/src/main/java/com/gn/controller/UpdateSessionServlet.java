package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/updateSession")
public class UpdateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public UpdateSessionServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 기존 세션 사용
		HttpSession session = request.getSession(false); // false로 설정하면 새 세션을 생성하지 않고 기존 세션이 존재할 경우 그것을 가져옴
		
		// 2. 기존 value 덮어쓰기
		if (session != null) {
			session.setAttribute("member_Id", "admin");
		}
		
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
