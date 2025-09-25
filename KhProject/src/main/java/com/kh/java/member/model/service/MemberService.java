package com.kh.java.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.common.Template;
import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.Member;

public class MemberService {

	private MemberDao md = new MemberDao();
	
	public Member login(Member member) {
		// 로그인 처리 -> DAO 보내서 있나없나 -> 결과값 반환
//		validateMember(member); 비즈니스 로직
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
		
	}
	
	public void validateMember(Member member) {
		// 유효성 검증
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		String pattern = "&^[a-zA-Z0-9]{4,20}$";
		if(!member.getUserId().matches(pattern)) {
			return;
		}
		// 비밀번호 검증 로직
		
	}
	
	
}
