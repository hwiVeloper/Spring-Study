package com.hwi.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwi.domain.MemberVO;

@Repository // DAO를 스프링에 인식시키기 위하여 주로 사용
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.hwi.mapper.MemberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return (MemberVO)sqlSession.selectOne(namespace+".selectMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("userid", userid);
		param.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace + ".readWithPW", param);
	}
	
	/*
	 * selectOne
	 * selectList
	 * selectMap
	 * insert
	 * update
	 * delete
	 */
}
