package com.gtec20.findIdAndPassword.controller.api;

import com.gtec20.findIdAndPassword.application.dto.find.FindDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String type = findDto.getType();
        String id = findDto.getId();
        String pw = findDto.getPw();
        String name = findDto.getName();

        if("id_find".equals(type)) {
            idx = idFind(pw);

            if (name.isEmpty()) {
                return "이름이 입력되지 않았습니다.";
            }

            if (pw.isEmpty()) {
                return "암호가 입력되지 않았습니다.";
            }

            if(idx == -1) {
                return "암호가 일치하지 않습니다.";
            } else {
                idx = nameFind(name, idx);
                return "회원님의 아이디는 " + idList.get(idx) + "입니다.";
            }
        }

        if ("pw_find".equals(type)) {
            idx = pwFind(id);

            if (id.isEmpty()) {
                return "아이디가 입력되지 않았습니다.";
            }

            if (name.isEmpty()) {
                return "이름이 입력되지 않았습니다.";
            }

            if(idx == -1) {
                return "아이디가 일치하지 않습니다.";
            }else {
                idx = nameFind(name, idx);
                return "회원님의 암호는 " + pwList.get(idx) + "입니다.";
            }
        }
        return "";
    }

    //아이디 찾기(이름, 암호) 비밀번호 찾기(아이디, 이름)
    private int idFind (String pw) {
        for (int i = 0; i < pwList.size(); i++) {
            if(pw.equals(pwList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private int pwFind (String id) {
        for(int i = 0; i < idList.size(); i++) {
            if(id.equals(idList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private int nameFind (String name, int idx) {
        if(name.equals(nameList.get(idx))) {
            return 0;
        }
        return -1;
    }

    private String NameCheck(String type, String fir, String sec) {
        if ("id_find".equals(type) && fir.isEmpty()) {
            return "이름이 입력되지 않았습니다.";
        }

        for (int i = 0; i < nameList.size(); i++) {
            if ("id_find".equals(type) && !fir.equals(nameList.get(i))) {
                return "이름이 일치하지 않습니다.";
            }
        }

        if ("pw_find".equals(type) && sec.isEmpty()) {
            return "비밀번호가 입력되지 않았습니다.";
        }

        for (int i = 0; i < nameList.size(); i++) {
            if ("pw_find".equals(type) && !sec.equals(pwList.get(i))) {
                return "이름이 입력되지 않았습니다";
            }
        }

        return "이름이 일치하지 않습니다.";
    }

}
