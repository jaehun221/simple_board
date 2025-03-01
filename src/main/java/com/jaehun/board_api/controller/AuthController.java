package com.jaehun.board_api.controller;

import com.jaehun.board_api.entity.User;
import com.jaehun.board_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        User newUser = userService.registerUser(username, password);
        return ResponseEntity.ok(Map.of("message", "회원가입 성공!", "userId", newUser.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        try {
            User user = userService.login(username, password);
            return ResponseEntity.ok(Map.of(
                    "message", "로그인 성공!",
                    "userId", user.getId(),
                    "username", user.getUsername()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

}