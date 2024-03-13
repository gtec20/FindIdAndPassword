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
public class FindIdDto {
    String pw;
    String name;
    String type;

    public FindIdDto(String pw, String name, String type) {
        this.pw = pw;
        this.name = name;
        this.type = type;
    }

    public boolean isEmptyCheck() {
        if ("id_find".equals(this.type)) {
            if (StringUtils.isEmpty(this.name) || StringUtils.isEmpty(this.pw)) {
                return false;
            }
        }
        return true;
    }
}
