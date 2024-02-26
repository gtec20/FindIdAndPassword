package com.gtec20.firstproject.application.dto.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDto {
    String id;
    String pw;

    public LoginDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
