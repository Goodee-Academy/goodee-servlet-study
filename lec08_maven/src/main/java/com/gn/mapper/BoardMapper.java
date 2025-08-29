package com.gn.mapper;

import java.util.List;

import com.gn.dto.Attach;
import com.gn.dto.Board;

public interface BoardMapper {
	List<Board> selectBoardList(Board board);
	int selectBoardCount(Board board);
	Board selectBoardOne(int boardNo);
	Attach selectAttachByBoardNo(int boardNo);
	Attach selectAttachByAttachNo(int attachNo);
	int insertBoard(Board board);
	int insertAttach(Attach attach);
}
