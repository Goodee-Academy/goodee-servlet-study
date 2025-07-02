package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String memberId, String memberPw) {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		return dao.insertMember(member);
	}
}
