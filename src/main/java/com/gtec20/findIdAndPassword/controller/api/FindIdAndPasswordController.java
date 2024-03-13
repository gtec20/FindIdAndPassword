package com.gtec20.findIdAndPassword.controller.api;

import com.gtec20.findIdAndPassword.application.dto.find.FindIdDto;
import com.gtec20.findIdAndPassword.application.dto.find.FindPwDto;
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

    int idx;

    @GetMapping("/findPW")
    public String findPw(@ModelAttribute("findPwDto") FindPwDto findPwDto) {
        if (!findPwDto.isEmptyCheck()) {
            return "유효하지 않은 값입니다.";
        }

        idx = idCheck(findPwDto.getId());

        if(idx == -1) {
            return "아이디가 일치하지 않습니다.";
        }

        idx = nameFind(findPwDto.getName(), idx);

        if (idx == -1){
            return "이름이 일치하지 않습니다.";
        } else {
            return "회원님의 암호는 " + pwList.get(idx) + "입니다.";
        }
    }


    @GetMapping("/findID")
    public String findID(@ModelAttribute("findIdDto") FindIdDto findIdDto) {
        if (!findIdDto.isEmptyCheck()) {
            return "유효하지 않은 값입니다.";
        }

        idx = pwCheck(findIdDto.getPw());

        if (idx == -1) {
            return "암호가 일치하지 않습니다.";
        }

        idx = nameFind(findIdDto.getName(), idx);

        if (idx == -1){
            return "이름이 일치하지 않습니다.";
        } else {
            return "회원님의 아이디는 " + idList.get(idx) + "입니다.";
        }
    }



    //아이디 찾기(이름, 암호) 비밀번호 찾기(아이디, 이름)
    private int pwCheck (String pw) {
        return pwList.indexOf(pw);
    }

    private int idCheck (String id) {
        return idList.indexOf(id);
    }

    private int nameFind (String name, int idx) {
        if(name.equals(nameList.get(idx))) {
            return idx;
        }
        return -1;
    }

}
