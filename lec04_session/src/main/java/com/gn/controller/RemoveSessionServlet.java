package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/removeSession")
public class RemoveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public RemoveSessionServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션 객체화
		HttpSession session = request.getSession(false); // 기존 세션을 가져옴
		
		if (session != null) {
			// (1) 특정 key에 대한 value만 삭제
			session.removeAttribute("member_Id");
			
			// (2) 세션 자체를 종료 (사용에 주의)
			session.invalidate();
		}
		
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
