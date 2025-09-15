package com.interstage.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.interstage.domain.LoginRequest;
import com.interstage.domain.UserDTO;
import com.interstage.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService; // 인터페이스 주입

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public Map<String, Object> signup(@Valid @RequestBody UserDTO user, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();

        if (bindingResult.hasErrors()) {
            Map<String, String> fieldErrors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    fieldErrors.put(error.getField(), error.getDefaultMessage())
            );
            response.put("success", false);
            response.put("errors", fieldErrors);
            return response;
        }

        try {
            userService.signup(user);
            response.put("success", true);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }

        return response;
    }
    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        Map<String,Object> response = new HashMap<>();
        try {
            boolean success = userService.login(request);
            response.put("success", success);
        } catch (IllegalArgumentException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

}
