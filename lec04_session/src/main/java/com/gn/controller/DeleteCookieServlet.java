package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public DeleteCookieServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 삭제하고 싶은 쿠키와 같은 key로 썩은 쿠키 생성
		Cookie cookie = new Cookie("user_id", "");
		
		// 2. 유효시간 0으로 설정 (즉시 삭제)
		cookie.setMaxAge(0);
		
		// 3. 응답에 썩은 쿠키 추가
		response.addCookie(cookie);
		
		// 4. 새 요청 발생 ("/"로 이동)
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
