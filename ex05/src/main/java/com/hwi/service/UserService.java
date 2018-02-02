package com.hwi.service;

import com.hwi.domain.UserVO;
import com.hwi.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
