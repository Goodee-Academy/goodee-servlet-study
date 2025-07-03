package com.gn.mapper;

import java.util.Map;

import com.gn.dto.Member;

public interface MemberMapper {
	int insertMember(Member member);
	Member selectMember(Member member);
	Map<Integer, Member> selectAllMember();
}
