package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.gn.dto.Board;
import com.gn.dto.Member;
import com.gn.service.BoardService;
import com.gn.service.MemberService;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
  public BoardListServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 사용자만 접근 허용
		HttpSession session = request.getSession(false);
		MemberService memberService = new MemberService();
		
		// 비정상 접근
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		// 비로그인 접근
		if (session.getAttribute("loginMember") == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		Board board = new Board();
		
		// 현재 페이지 정보 세팅
		int nowPage = 1;
		String nowPageStr = request.getParameter("nowPage");
		if (nowPageStr != null) nowPage = Integer.parseInt(nowPageStr);
		board.setNowPage(nowPage);
		
		// 검색어 세팅
		String keyword = request.getParameter("keyword");
		board.setKeyword(keyword);
		
		// 전체 게시글 개수 조회
		int totalData = service.selectBoardCount(board);
		board.setTotalData(totalData);
		
		// 게시글 목록 페이지로 이동
		List<Board> boardList = service.selectBoardList(board);
		Map<Integer, Member> memberMap = memberService.selectAllMember();
		
		if (session.getAttribute("memberMap") == null) {
			session.setAttribute("memberMap", memberMap);
		}
		
		request.setAttribute("paging", board);
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
