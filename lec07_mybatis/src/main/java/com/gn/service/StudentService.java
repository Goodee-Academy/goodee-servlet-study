package com.gn.service;

import java.util.List;

import com.gn.dao.StudentDao;
import com.gn.dto.Student;

public class StudentService {
	// DAO에게 요청해 DB에서 정보 조회, 등록, 수정, 삭제
	private StudentDao dao = new StudentDao();
	
	public List<Student> getStudentList() {
		// 4. DAO에 DB 연결 요청
		return dao.selectAll();
	}
}
