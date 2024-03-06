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

        //아이디 찾기는 이름의 인덱스번호와 비밀번호의 인덱스번호가 같으면 그 같은 인덱스 번호의 id를 화면에 띄운다
        //비밀번호 찾기는 아이디의 인덱스번호와 이름의 인덱스번호가 같으면 그 같은 인덱스 번호의 pw를 화면에 띄운다
        //위에것들이 일치되지 않는다면 회원 정보를 확인할 수 없습니다.

        String name = findDto.getName();
        String id = findDto.getId();
        String pw = findDto.getPw();

        //아이디 찾기
        if (StringUtils.isEmpty(name) && StringUtils.isEmpty(pw)){
            int nameIdx = nameList.indexOf(name);
            int pwIdx = pwList.indexOf(pw);
            if(nameIdx == -1){
                return "이름을 다시 입력해주세요.";
            }
            if(nameIdx == pwIdx){
                return nameList.get(nameIdx) + "님의 아이디 : " + idList.get(nameIdx);
            }
        }

        //비번 찾기
        if(StringUtils.isEmpty(id) && StringUtils.isEmpty(name)){
            int idIdx = idList.indexOf(id);
            int nameIdx = nameList.indexOf(name);
            if(idIdx == -1){
                return "id를 다시 입력해주세요.";
            }
            if (idIdx == nameIdx){
                return idList.get(idIdx) + "님의 비밀번호 : " + pwList.get(idIdx);
            }
        }

        return "회원 정보를 확인 할 수 없습니다.";
    }

}
