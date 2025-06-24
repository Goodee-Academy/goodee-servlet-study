package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public BookReserveEndServlet() {
      super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user_name");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		String book = request.getParameter("book_name");
		String period = request.getParameter("borrow_period");
		
		Map<String, String> bookNameMap = new HashMap<String, String>();
		bookNameMap.put("1", "자바 프로그래밍 입문");
		bookNameMap.put("2", "웹 개발의 기초");
		bookNameMap.put("3", "데이터베이스 시스템");
		
		Map<String, Integer> bookPriceMap = new HashMap<String, Integer>();
		bookPriceMap.put("1", 1500);
		bookPriceMap.put("2", 1800);
		bookPriceMap.put("3", 2000);
		
		int price = bookPriceMap.get(book) + (500 * (Integer.parseInt(period) - 1));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/book/confirm.jsp");
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("book", bookNameMap.get(book));
		request.setAttribute("period", period);
		request.setAttribute("price", String.valueOf(price));
		
		dispatcher.forward(request, response);
	}

}
