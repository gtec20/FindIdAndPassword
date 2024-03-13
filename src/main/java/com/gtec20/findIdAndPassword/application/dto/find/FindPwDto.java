package com.gtec20.findIdAndPassword.application.dto.find;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.thymeleaf.util.StringUtils;

@Getter
@Setter
@NoArgsConstructor
public class FindPwDto {
    String id;
    String name;
    String type;

    public FindPwDto(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public boolean isPwCheck(){
        return StringUtils.isEmpty(id)||StringUtils.isEmpty(name);
    }


}
