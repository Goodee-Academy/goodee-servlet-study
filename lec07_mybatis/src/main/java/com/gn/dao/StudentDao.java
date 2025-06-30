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
}
