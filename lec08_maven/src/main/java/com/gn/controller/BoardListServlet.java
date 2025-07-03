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
		
		// 게시글 목록 페이지로 이동
		List<Board> boardList = service.selectBoardList();
		Map<Integer, Member> memberMap = memberService.selectAllMember();
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("memberList", memberMap);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
