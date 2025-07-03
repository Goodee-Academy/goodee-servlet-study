package com.gn.dao;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dto.Member;

public class MemberDao {
	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.MemberMapper.insertMember", member);
		session.close();
		
		return result;
	}

	public Member selectMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Member result = session.selectOne("com.gn.mapper.MemberMapper.selectMember", member);
		session.close();
		
		return result;
	}
}
