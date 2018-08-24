package com.panda.controller.health;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/api/{nickname}")
    public String home(ModelMap model, @PathVariable String nickname) {
        model.addAttribute("name", nickname);
        return "index";
    }

    @RequestMapping("/api/")
    public String usingRequestParam(Model model,
            @RequestParam(value = "name", required = false) String nickname) {
        model.addAttribute("nickname", nickname);
        return "index";
    }

    @RequestMapping("/api/2/{nickname}")
    public String usingPathVariable(Model model, @PathVariable String nickname) {
        model.addAttribute("nickname", nickname);
        return "index";
    }
}
