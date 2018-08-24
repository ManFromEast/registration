package com.panda.controller.health;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account/*")
public class UserAccountController {

    @RequestMapping
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/forgotpassword")
    public String forgotpassword() {
        return "forgotpassword";
    }

    // @PostMapping("/signup/process")
    // public String processSignup(ModelMap model,
    // @RequestParam("nickname") String nickname,
    // @RequestParam("emailaddress") String emailAddress,
    // @RequestParam("password") String password) {
    // model.addAttribute("login", true);
    // model.addAttribute("nickname", nickname);
    // return "index";
    // }

    @RequestMapping("/signup/process")
    public String processSignup(ModelMap model, @RequestParam("nickname") String nickname,
            @RequestParam("emailaddress") String emailAddress, @RequestParam("password") String password) {
        model.addAttribute("login", true);
        model.addAttribute("nickname", nickname);
        return "index";
    }
    //
    // @PostMapping("/signup/process")
    // public ModelAndView processSignup(ModelMap model, @RequestParam("nickname") String nickname,
    // @RequestParam("emailaddress") String emailAddress, @RequestParam("password") String password) {
    // model.addAttribute("login", true);
    // model.addAttribute("nickname", nickname);
    // model.addAttribute("message", "Have a great day ahead.");
    // return new ModelAndView("index", model);
    // Will result in display of index.jsp page
    // return new ModelAndView("index");
    //
    // // Will result in display of index.jsp page.
    // //The JSP page could consist of code such as "Hello ${name}"
    // //which will get displayed as "Hello Calvin Hobbes"
    //
    // return new ModelAndView("index", "name", "Calvin Hobbes");
    //
    // // Will result in display of index.jsp page.
    // // The JSP page could consist of code such as
    // //"Hello ${model.firstName} ${model.lastName}"
    // //which will get displayed as "Hello Calvin Hobbes"
    //
    // UserInfo userInfo = new UserInfo();
    // userInfo.setFirstName("Calvin");
    // userInfo.setLastName("Hobbes");
    // return new ModelAndView("index", "model", userInfo);
    //
    // // Will result in display of index.jsp page.
    // // The JSP page could consist of code such as "Hello ${name}"
    // // which will get displayed as "Hello Calvin Hobbes"
    //
    // Map<String, Object> map = new HashMap<String, Object>();
    // map.put("name", "Calvin Hobbes");
    // return new ModelAndView("index", map);
    // }

    @GetMapping("/{nickname}")
    public String home(ModelMap model, @PathVariable String nickname) {
        model.addAttribute("name", nickname);
        return "index";
    }

}
