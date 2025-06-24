package com.gn.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pageView")
public class PageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public PageViewServlet() {
      super();
  }

  // a 태그를 통한 서블릿 요청 시 기본적으로 Get으로 들어옴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 전환 (webapp/views/page_element.jsp)
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/page_element.jsp");
		dispatcher.forward(request, response); // 따로 전달할 값은 없음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
