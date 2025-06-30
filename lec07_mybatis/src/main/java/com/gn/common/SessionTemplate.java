package com.gn.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		
		try {
			// 1. SQL Session Factory Builder
			// mybatis-config.xml의 설정 정보를 통해 객체 생성
			String path = "./mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(path);
			
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			
			// 2. SQL Session Factory 객체 생성
			// SqlSessionFactoryBuilder의 build() 메서드 활용
			// 매개변수로 mybatis-config.xml 파일 정보 전달
			SqlSessionFactory factory = sfb.build(inputStream);
			
			// 3. SQL Session 객체 생성
			// SqlSessionFactory의 openSession() 메서드 활용
			// true: autoCommit 켜기 -> 데이터 변경을 자동 반영
			// false: autoCommit 끄기 (명시적 commit 호출) -> 수동 반영
			session = factory.openSession(autoCommit);
			
		} catch (IOException e) { e.printStackTrace(); }
		
		return session;
	}
}
