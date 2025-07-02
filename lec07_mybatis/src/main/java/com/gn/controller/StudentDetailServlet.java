package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
  public StudentDetailServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 학생의 학번을 파라미터로 전달받음
		int studentNo = Integer.parseInt(request.getParameter("no"));
		
		// 2. 해당 학생의 정보 조회(DB)
		Student student = service.getStudentDetail(studentNo);
		
		// 3. 상세 화면으로 전달
		request.setAttribute("student", student);
		request.getRequestDispatcher("/views/studentDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
