package com.gtec20.findIdAndPassword.application.dto.find;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.thymeleaf.util.StringUtils;

@Getter
@Setter
@NoArgsConstructor
public class FindDto {
    String id;
    String name;
    String pw;
    String type;

    public FindDto(String id, String name, String pw, String type) {
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.type = type;
    }

    public boolean isIdCheck(){
        //이름암호 아이디이름
        //이름과 암호 둘 중 하나라도 비어있으면 찾을수없음
        //아이디와 이름 둘 중 하나라도 비어있으면 찾을수없음
        return StringUtils.isEmpty(name)||StringUtils.isEmpty(pw);
    }

    public boolean isPwCheck(){
        return StringUtils.isEmpty(id)||StringUtils.isEmpty(name);
    }


}
