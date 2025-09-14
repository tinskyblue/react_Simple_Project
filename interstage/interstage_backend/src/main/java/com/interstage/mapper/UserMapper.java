package com.interstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.interstage.domain.UserDTO;

@Mapper
public interface UserMapper {
	// interface 메서드의 기본 접근자는 public abstract
	List<UserDTO> findAll();
	int insertUser(UserDTO user);
}
