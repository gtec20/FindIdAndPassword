package com.gtec20.findIdAndPassword.application.dto.find;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindDto {
    String id;
    String name;
    String pw;

    public FindDto(String id, String name, String pw) {
        this.id = id;
        this.name = name;
        this.pw = pw;
    }
}
