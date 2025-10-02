package com.kh.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.vo.Member;

public class MemberDao {

	
	public Member login(SqlSession sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.login",member);
	}
	
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember",member);
	}
	public int update(SqlSession sqlSession, Member member) {
		return sqlSession.update("memberMapper.update", member);
	}
	
	public int delete(SqlSession sqlSession, Map<String,String> map) {
		return sqlSession.update("memberMapper.delete", map);
	}
	
	public int updatePwd(SqlSession sqlSession, Map<String, String> map) {
		return sqlSession.update("memberMapper.updatePwd", map);
	}
	
}
