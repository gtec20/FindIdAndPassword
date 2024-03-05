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

        return "";
    }

    //아이디 찾기(이름, 암호)
    private int idFind (String name) {
        for(String nowName : nameList) {
            if(nameList.equals(nowName)) {
                return 0;
            }
        }
        return ;
    }

}
