package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.gn.dto.Student;
import com.gn.service.StudentService;

@WebServlet("/student/search")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
  public StudentSearchServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyName = request.getParameter("student_name");
		
		List<Student> resultList = service.getSearchList(keyName);
		request.setAttribute("resultList", resultList);
		request.getRequestDispatcher("/views/studentSearch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
