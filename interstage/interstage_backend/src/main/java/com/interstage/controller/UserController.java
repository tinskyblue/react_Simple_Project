package com.interstage.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.interstage.domain.UserDTO;
import com.interstage.mapper.UserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userMapper.findAll();
    }

    @PostMapping("/signup")
    public Map<String, Object> signup(@Valid @RequestBody UserDTO user,
                                      BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();

        // 유효성 검사 실패 시
        if (bindingResult.hasErrors()) {
            Map<String, String> fieldErrors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    fieldErrors.put(error.getField(), error.getDefaultMessage())
            );
            response.put("success", false);
            response.put("errors", fieldErrors); // 프론트가 바로 사용 가능
            return response;
        }

        // 비밀번호 확인 일치 여부
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            response.put("success", false);
            Map<String, String> fieldErrors = new HashMap<>();
            fieldErrors.put("confirmPassword", "비밀번호가 일치하지 않습니다.");
            response.put("errors", fieldErrors);
            return response;
        }

        try {
            userMapper.insertUser(user);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "회원가입 실패: " + e.getMessage());
        }

        return response;
    }
}
