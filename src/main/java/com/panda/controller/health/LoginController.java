package com.panda.controller.health;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "login";
    }
}
