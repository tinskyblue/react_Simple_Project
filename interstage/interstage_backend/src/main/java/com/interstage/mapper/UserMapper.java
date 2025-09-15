package com.interstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.interstage.domain.UserDTO;

@Mapper
public interface UserMapper {
	// interface 메서드의 기본 접근자는 public abstract
	List<UserDTO> findAll();
	int insertUser(UserDTO user);
	
	// 로그인 시 아이디로 사용자 조회
	UserDTO findByUsername(@Param("username") String username);
}
