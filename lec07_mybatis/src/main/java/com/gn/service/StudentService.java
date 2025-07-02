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
	
	public Student getStudentDetail(int studentNo) {
		return dao.selectOne(studentNo);
	}
	
	public List<Student> getSearchList(String keyName) {
		return dao.searchStudent(keyName);
	}
	
	public int insertStudent(String name, int age) {
		// 1. Map => DTO에 없는 필드가 있는 경우 또는 3개 이하인 경우 
		// 2. DTO(Student)
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentAge(age);
		
		return dao.insert(student);
	}
	
	public int updateStudent(int no, String name, int age) {
		Student student = new Student(no, name, age);
		return dao.updateStudent(student);
	}
	
	public int deleteStudent(int no) {
		return dao.deleteStudent(no);
	}
}
