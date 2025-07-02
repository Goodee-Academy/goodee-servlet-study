package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.service.StudentService;

@WebServlet("/student/insert")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
  public StudentInsertServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 등록 화면으로 전환
		request.getRequestDispatcher("/views/studentInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// DB에 학생 정보 등록
		String name = request.getParameter("studentName");
		int age = Integer.parseInt(request.getParameter("studentAge"));
		
		int result = service.insertStudent(name, age);
		if (result > 0) {
			response.sendRedirect("/student/list");
		} else {
			response.sendRedirect("/student/insert");
		}
	}

}
