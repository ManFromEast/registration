package com.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("user", name);
        return "hello";
    }
}
