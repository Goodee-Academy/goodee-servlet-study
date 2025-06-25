package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/makeCookie")
public class MakeCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public MakeCookieServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 쿠키 객체 생성
		// (주의) key가 중복되면 value를 덮어씀 => 타인의 쿠키 key 값을 미리 확인하는 것이 좋음
		Cookie cookie = new Cookie("user_id", "user01");
		
		// 2. 쿠키 유지시간 설정(초 단위)
		cookie.setMaxAge(60 * 60 * 24); // 1일 유지
		
		// 3. 응답에 쿠키를 넣고 브라우저에 전달
		response.addCookie(cookie);
		
		// 4. 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
