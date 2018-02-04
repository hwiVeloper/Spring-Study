package com.hwi.persistence;

import java.util.Date;

import com.hwi.domain.UserVO;
import com.hwi.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
