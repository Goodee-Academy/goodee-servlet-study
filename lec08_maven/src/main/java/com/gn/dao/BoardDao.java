package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardDao {
	public List<Board> selectBoardList(Board board) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		List<Board> resultList = session.selectList("com.gn.mapper.BoardMapper.selectBoardList", board);
		session.close();
		
		return resultList;
	}
	
	public int selectBoardCount(Board board) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		int result = session.selectOne("com.gn.mapper.BoardMapper.selectBoardCount", board);
		session.close();
		
		return result;
	}
	
	public Board selectBoardOne(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Board board = session.selectOne("com.gn.mapper.BoardMapper.selectBoardOne", boardNo);
		session.close();
		
		return board;
	}
	
	public Attach selectAttachByBoardNo(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Attach attach = session.selectOne("com.gn.mapper.BoardMapper.selectAttachByBoardNo", boardNo);
		session.close();
		
		return attach;
	}
	
	public Attach selectAttachByAttachNo(int attachNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Attach attach = session.selectOne("com.gn.mapper.BoardMapper.selectAttachByAttachNo", attachNo);
		session.close();
		
		return attach;
	}

	public int insertBoard(SqlSession session, Board board) {
		int result = session.insert("com.gn.mapper.BoardMapper.insertBoard", board);
		
		return result;
	}

	public int insertAttach(SqlSession session, Attach attach) {
		int result = session.insert("com.gn.mapper.BoardMapper.insertAttach", attach);
		
		return result;
	}

	

	

	



	

}
