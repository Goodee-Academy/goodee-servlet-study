package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {
	public List<Student> selectAll() {
		// DB에 접근 (MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
		
		// 5. Mapper에 있는 쿼리 실행
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
	
		return list;
	}
	
	public Student selectOne(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
		session.close();
		
		return student;
	}
	
	public List<Student> searchStudent(String keyName) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.searchStudent", keyName);
		session.close();
		
		return list;
	}
	
	public int insert(Student student) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", student);
		session.close();
		
		return result;
	}
	
	public int updateStudent(Student student) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.update("com.gn.mapper.StudentMapper.updateStudent", student);
		session.close();
		
		return result;
	}
	
	public int deleteStudent(int no) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.delete("com.gn.mapper.StudentMapper.deleteStudent", no);
		session.close();
		
		return result;
	}
}
