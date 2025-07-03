package com.gn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dao.BoardDao;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public List<Board> selectBoardList() {
		return boardDao.selectBoardList();
	}

	public int createBoardWithAttach(Board board, Attach attach) {
		// 게시글과 파일 트랜잭션 처리
		SqlSession session = SqlSessionTemplate.getSqlSession(false);
		int result = 0;
		
		try {
			// 1. 게시글 등록
			result = boardDao.insertBoard(session, board);
			
			// 2. 파일 정보 등록
			if (attach != null && result > 0) {
				attach.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttach(session, attach);
			}
			
			// 3. commit 또는 rollback
			if (result > 0) {
				session.commit();
			} else {
				session.rollback(); // 이번 세션에서 진행한 프로세스를 취소함
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return result;
	}
}
