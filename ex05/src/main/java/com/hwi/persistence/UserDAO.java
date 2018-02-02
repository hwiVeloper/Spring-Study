package com.hwi.persistence;

import com.hwi.domain.UserVO;
import com.hwi.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
}
