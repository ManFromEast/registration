package com.panda.unittest.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.validation.support.BindingAwareModelMap;

import com.panda.controller.HelloController;

public class HelloControllerTest {

    @Test
    public void sayHello() {
        HelloController controller = new HelloController();
        String result = controller.sayHello("Dolly", new BindingAwareModelMap());
        assertEquals("hello", result);
    }
}
