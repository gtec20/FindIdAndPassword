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
        int idx;

        if("id_find".equals(findDto.getType())) {
            if (StringUtils.isEmpty(findDto.getName())) {
                return "이름이 입력되지 않았습니다.";
            }

            if (StringUtils.isEmpty(findDto.getPw())) {
                return "암호가 입력되지 않았습니다.";
            }

            idx = pwCheck(findDto.getPw());

            if (idx == -1) {
                return "암호가 일치하지 않습니다.";
            }

            idx = nameFind(findDto.getName(), idx);

            if (idx == -1){
                return "이름이 일치하지 않습니다.";
            } else {
                return "회원님의 아이디는 " + idList.get(idx) + "입니다.";
            }

        }

        if ("pw_find".equals(findDto.getType())) {
            if (StringUtils.isEmpty(findDto.getId())) {
                return "아이디가 입력되지 않았습니다.";
            }

            if (StringUtils.isEmpty(findDto.getName())) {
                return "이름이 입력되지 않았습니다.";
            }

            idx = idCheck(findDto.getId());

            if(idx == -1) {
                return "아이디가 일치하지 않습니다.";
            }

            idx = nameFind(findDto.getName(), idx);

            if (idx == -1){
                return "이름이 일치하지 않습니다.";
            } else {
                return "회원님의 암호는 " + pwList.get(idx) + "입니다.";
            }
        }
        return "";
    }

    //아이디 찾기(이름, 암호) 비밀번호 찾기(아이디, 이름)
    private int pwCheck (String pw) {
        for (int i = 0; i < pwList.size(); i++) {
            if(pw.equals(pwList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private int idCheck (String id) {
        for(int i = 0; i < idList.size(); i++) {
            if(id.equals(idList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private int nameFind (String name, int idx) {
        if(name.equals(nameList.get(idx))) {
            return idx;
        }
        return -1;
    }

    private String NameCheck(String name, int idx) {
        if (name.equals(nameList.get(idx))) {
            return "이름이 일치하지 않습니다.";
        }
        return "이름이 일치하지 않습니다.";
    }

}
