package com.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	private MemberDao md = new MemberDao();
	
	public Member login(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession,member);
		
		validateMember(member);
		
		sqlSession.close();
		
		return loginMember;
	}

	public void validateMember(Member member) {
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		String pattern = "&^[a-zA-Z0-9]{4,20}$";
		if(!member.getUserId().matches(pattern)) {
			return;
		}		
	}
}
