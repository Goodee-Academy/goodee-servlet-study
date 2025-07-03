package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.gn.dto.Member;
import com.gn.service.MemberService;

@WebServlet("/memberLogin")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
       
  public MemberLoginServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// 전달받은 정보가 일치하는 회원을 반환
		Member member = service.selectMember(memberId, memberPw);
		
		// 1. service: 바구니에 담아 dao에게 전달
		// 2. dao: 인터페이스에게 db 연결 요청
		// 3. Mapper: mapper.xml한테 쿼리 호출
		// 4. xml: select * 쿼리 구성 + resultMap (memberResultMap)
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("res_code", "500");
		jsonObj.put("res_msg","로그인 중 오류가 발생하였습니다.");
		
		if (member != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(60 * 30);
			
			jsonObj.put("res_code", "200");
			jsonObj.put("res_msg", "로그인에 성공했습니다.");
		}
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
	}

}
