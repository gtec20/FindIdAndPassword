package com.gtec20.firstproject.controller.api;

import com.gtec20.firstproject.application.dto.login.LoginDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    List<String> nameList = List.of("최승우", "채승주", "유정하");
    List<String> idList = List.of("seungwoo", "seungjoo", "jeongha");
    List<String> pwList = List.of("123", "456", "789");

    @GetMapping("")
    public String isLogin(@ModelAttribute("loginDto") LoginDto loginDto) {
        return "";
    }

}
