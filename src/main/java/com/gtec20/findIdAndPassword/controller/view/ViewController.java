package com.gtec20.findIdAndPassword.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/find")
    public String find() {
        return "page/find";
    }
}
