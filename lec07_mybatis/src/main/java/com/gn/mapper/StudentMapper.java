package com.gn.mapper;

import java.util.List;

import com.gn.dto.Student;

public interface StudentMapper {
	List<Student> selectAll();
	List<Student> searchStudent(String keyName);
	Student selectOne(int studentNo);
	int insert(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studentNo);
}
