package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
  public StudentUpdateServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면단에서 전달받은 정보 가져오기
		int studentNo = Integer.parseInt(request.getParameter("no"));
		
		Student student = service.getStudentDetail(studentNo);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/views/studentUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. UTF-8로 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 정보 가져오기
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		String studentName = request.getParameter("studentName");
		int studentAge = Integer.parseInt(request.getParameter("studentAge"));
		
		// 3. service에게 요청 (번호, 이름, 나이 주면서) => 결과는 int로 반환
		int result = service.updateStudent(studentNo, studentName, studentAge);
		
		// 4. 결과가 0보다 크면 => 목록 화면 전환 요청, 0보다 크지 않으면 => 수정 화면 다시 요청
		if (result > 0) {
			response.sendRedirect("/student/list");
		} else {
			response.sendRedirect("/student/update?no=" + studentNo);
		}
	}

}
