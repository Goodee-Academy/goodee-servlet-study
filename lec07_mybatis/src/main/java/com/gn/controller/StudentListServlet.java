package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.gn.dto.Student;
import com.gn.service.StudentService;

@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
  public StudentListServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. Service에 정보 전달
		List<Student> studentList = service.getStudentList();
		
		// 6. /views/studentList.jsp로 보내기
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/studentList.jsp");
		request.setAttribute("studentList", studentList);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
