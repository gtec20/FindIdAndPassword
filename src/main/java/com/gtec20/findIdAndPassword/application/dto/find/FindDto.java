package com.gtec20.findIdAndPassword.application.dto.find;

import io.micrometer.common.util.StringUtils;
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

    public String getType() {
        if(
                StringUtils.isEmpty(this.id)
                && StringUtils.isNotEmpty(this.pw)
                && StringUtils.isNotEmpty(this.name))
        {
            return "id";
        }

        if(
                StringUtils.isNotEmpty(this.id)
                && StringUtils.isEmpty(this.pw)
                && StringUtils.isNotEmpty(this.name))
        {
            return "pw";
        }
        return null;
    }
}
