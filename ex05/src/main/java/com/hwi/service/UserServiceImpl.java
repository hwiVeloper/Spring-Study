package com.hwi.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hwi.domain.UserVO;
import com.hwi.dto.LoginDTO;
import com.hwi.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
}
