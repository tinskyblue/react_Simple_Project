package com.interstage.service;

import java.util.List;

import com.interstage.domain.LoginRequest;
import com.interstage.domain.UserDTO;

public interface UserService {
	boolean login(LoginRequest request);
	void signup(UserDTO user);
	List<UserDTO> getAllUsers();
}
