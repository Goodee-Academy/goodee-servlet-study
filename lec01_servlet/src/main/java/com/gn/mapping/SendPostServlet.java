package com.gn.mapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginMember")
public class SendPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public SendPostServlet() {
      super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST -> body에 ISO-8891-1로 인코딩되어 들어옴 -> UTF-8로 변경하는 작업 필요
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		// printWriter.printf("""
		// 		<html>
				
		// 			<head>
		// 				<meta charset='UTF-8'>
		// 				<meta name='viewport' content='width=device-width, initial-scale=1.0'>
		// 				<title>로그인 결과화면</title>
		// 			</head>
					
		// 			<body>
		// 				<h1>반가워요 %s님</h1>
		// 				<h2>비밀번호가 %s이시네요~</h2>
		// 				<a href="/">홈페이지로 돌아가기</a>
		// 			</body>
					
		// 		</html>
		// 		""", id, pw);
		
		// printWriter.flush();
		
		RequestDispatcher view = request.getRequestDispatcher("./views/logInSuccess.jsp");
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		view.forward(request, response);
	}

}
