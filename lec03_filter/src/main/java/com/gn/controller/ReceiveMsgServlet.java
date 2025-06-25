package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receive/msg")
public class ReceiveMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public ReceiveMsgServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== 요청 확인 ====");
		String msg = request.getParameter("msg");
		System.out.println(msg);
		
		// 화면단 경로는 반드시 /로 시작
		// / 없이 화면 설정 -> /receive/views/msgShow.jsp를 찾게 됨
		// RequestDispatcher dispatcher = request.getRequestDispatcher("/views/msgShow.jsp"); 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/msgShow.jsp"); // 시작부분을 명확하게
		request.setAttribute("msg", msg);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
