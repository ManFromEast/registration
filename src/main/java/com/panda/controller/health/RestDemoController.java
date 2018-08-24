package com.panda.controller.health;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panda.entity.health.HelloMessage;
import com.panda.entity.health.User;

@Controller
public class RestDemoController {

    @PostMapping("/api/rest/hello")
    public HelloMessage getHelloMessage(@RequestBody User user) {
        HelloMessage helloMessage = new HelloMessage();
        String name = user.getName();
        helloMessage.setMessage("Hello " + name + "! How are you doing?");
        helloMessage.setName(name);
        return helloMessage;
    }

    @RequestMapping(value = "/api/rest/hello3", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HelloMessage getHelloMessage2(@RequestBody User user) {
        HelloMessage helloMessage = new HelloMessage();
        String name = user.getName();
        helloMessage.setMessage("Hello " + name + "! How are you doing?");
        helloMessage.setName(name);
        return helloMessage;
    }
}
