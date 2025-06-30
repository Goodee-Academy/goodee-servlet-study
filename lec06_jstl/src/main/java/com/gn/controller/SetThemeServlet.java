package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setTheme")
public class SetThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public SetThemeServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String myTheme = request.getParameter("theme");
		System.out.println(myTheme);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/sample.jsp");
		request.setAttribute("theme", myTheme);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
