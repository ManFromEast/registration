package com.panda.integrationtest.controller;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.panda.service.WebDriverService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// @EnableAutoConfiguration
// @ContextConfiguration(classes = { PandaConfiguration.class })
public class HelloControllerIntegrationTest {

    WebDriver driver = null;

    @Autowired
    WebDriverService webDriverService;

    @BeforeClass
    public void setUp() {
        if (driver == null) {
            driver = webDriverService.getFirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Given("^I will say hello to \"([^\"]*)\"$")
    public void i_will_say_hello_to(String name) throws Throwable {
        String url = "http://localhost:8080/registration/hello/sayHello/?name=" + name;
        System.out.println("url::" + url);
        driver.navigate().to(url);
    }

    @When("^access sayHello method with paramter name$")
    public void access_sayHello_method_with_paramter_name() throws Throwable {
        driver.findElement(By.id("user")).getText().equalsIgnoreCase("Hello , Dolly");
    }

    @Then("^I call parser to resovle response$")
    public void i_call_parser_to_resovle_response() throws Throwable {
        driver.findElement(By.id("user")).getText().equalsIgnoreCase("Hello , Dolly");
    }

}
