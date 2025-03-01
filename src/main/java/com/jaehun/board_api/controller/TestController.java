package com.jaehun.board_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class TestController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "인증 없이 접근 가능한 엔드포인트!";
    }
}