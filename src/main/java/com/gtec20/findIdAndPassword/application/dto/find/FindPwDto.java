package com.gtec20.findIdAndPassword.application.dto.find;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.thymeleaf.util.StringUtils;

@ToString
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

    public boolean isEmptyCheck() {
        if ("pw_find".equals(this.type)) {
            if (StringUtils.isEmpty(this.id) || StringUtils.isEmpty(this.name)) {
                return false;
            }
        }
        return true;
    }
}
