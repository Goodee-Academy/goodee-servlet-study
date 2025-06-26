package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gradeCalculator")
public class GradeCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public GradeCalculatorServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int korPoint = Integer.parseInt(request.getParameter("korPoint"));
		int engPoint = Integer.parseInt(request.getParameter("engPoint"));
		int mathPoint = Integer.parseInt(request.getParameter("mathPoint"));
		
		int resultSum = (korPoint + engPoint + mathPoint);
		double resultAvg = (double) resultSum / 3;
		String resultStr = "";
		
		if (korPoint >= 40 && engPoint >= 40 && mathPoint >= 40 && resultAvg >= 60.0) {
			resultStr = "합격입니다!";
		} else {
			resultStr = "불합격입니다...";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("<p>▶ 총점: %d</p><p>▶ 평균: %.2f</p><p>%s</p>\n", resultSum, resultAvg, resultStr);
	}

}
