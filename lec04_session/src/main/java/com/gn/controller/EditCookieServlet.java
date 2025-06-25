package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editCookie")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public EditCookieServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// user_id 라는 key를 가진 쿠키의 value를 admin으로 수정
		// 기존과 동일한 유지시간 설정
		// => index.jsp 화면에서 <쿠키 수정> 클릭 후 새로고침
		Cookie cookie = new Cookie("user_id", "user02");
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
		
		// 쿠키 수정 후 홈으로 이동
		// sendRedirect(): 브라우저가 새로운 요청을 다시 보내게 하는 메서드
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
