package com.gtec20.findIdAndPassword.controller.api;

import com.gtec20.findIdAndPassword.application.dto.find.FindDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api/find")
public class FindIdAndPasswordController {

    List<String> nameList = List.of("최승우", "채승주", "유정하");
    List<String> idList = List.of("seungwoo", "seungjoo", "jeongha");
    List<String> pwList = List.of("password1", "password2", "password3");

    @GetMapping("")
    public String isFind(@ModelAttribute("findDto") FindDto findDto) {
        String type = findDto.getType();
        if(StringUtils.isEmpty(type)) {
            return "필수 값이 존재하지 않습니다.\n다시 입력해주세요.";
        }
        if(type.equals("id")) {
            return getId(findDto);
        }

        return getPw(findDto);
    }

    public String getId(FindDto findDto) {
        int nameIdx = nameList.indexOf(findDto.getName());
        if(nameIdx == -1) {
            return "이름이 존재하지 않습니다.";
        }

        if(!pwList.get(nameIdx).equals(findDto.getPw())) {
            return "비밀번호가 잘 못 입력되었습니다.";
        }

        return idList.get(nameIdx);
    }

    public String getPw(FindDto findDto) {
        int idIdx = idList.indexOf(findDto.getId());
        if(idIdx == -1) {
            return "아이디가 존재하지 않습니다.";
        }

        if(!nameList.get(idIdx).equals(findDto.getName())) {
            return "이름이 잘 못 입력되었습니다.";
        }

        return pwList.get(idIdx);
    }

}
