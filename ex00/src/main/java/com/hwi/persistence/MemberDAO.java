package com.hwi.persistence;

import com.hwi.domain.MemberVO;

public interface MemberDAO {
	public String getTime(); // 현재 시간 체크하는 기능
	
	public void insertMember(MemberVO vo); // 테이블에 데이터를 추가하는 기능
	
	// DAO 작성 후 XML Mapper를 작성한다.
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
