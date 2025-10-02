package com.kh.member.model.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	private MemberDao md = new MemberDao();
	
	public Member login(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession,member);
		
//		validateMember(member);
		
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
	
	public int insertMember(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.insertMember(sqlSession,member);
		
		if(result > 0 ) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
		
	}
	
	public Member update(Member member) {
		
		Member updateMember = null;
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.update(sqlSession,member);
		
		if(result > 0) {
			sqlSession.commit();
			updateMember = new MemberDao().login(sqlSession, member);
		}
		
		sqlSession.close();
		
		return updateMember;
	}
	
	public int delete(Map<String, String> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.delete(sqlSession,map);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
		
	}
	
	public int updatePwd(Map<String, String> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.updatePwd(sqlSession,map);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
		
	}
	
	
}
