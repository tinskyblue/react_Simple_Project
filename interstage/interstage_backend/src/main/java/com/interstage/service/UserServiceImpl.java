package com.interstage.service;

import org.springframework.stereotype.Service;
import com.interstage.domain.LoginRequest;
import com.interstage.domain.UserDTO;
import com.interstage.mapper.UserMapper;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public boolean login(LoginRequest request) {
        UserDTO user = userMapper.findByUsername(request.getUsername());

        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }

        return true;
    }

    @Override
    public void signup(UserDTO user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        userMapper.insertUser(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.findAll();
    }
}
