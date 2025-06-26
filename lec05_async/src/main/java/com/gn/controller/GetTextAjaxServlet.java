package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getTextAjax")
public class GetTextAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public GetTextAjaxServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		// 1. HTML 형태로 응답 (default)
		// (1) 어떤 형식으로 정보를 보내줄 것인지 지정
		// response.setContentType("text/html; charset=UTF-8");
		
		// (2) 연결 통로(Stream) 생성
		// PrintWriter out = response.getWriter();
		
		// (3) 통로로 정보 내보내기
		// out.printf("<p>아이디: %s (%d글자)</p>\n", userId, userId.length());
		
		// 2. (순수) 문자 형태로 응답
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("순수 문자 아이디: %s (%d글자)\n", userId, userId.length());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
