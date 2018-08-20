package com.panda.runner;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/outline.feature",
        // features = "src/test/resources/features/com.panda.controller/HelloController.feature",
        glue = {
                "com.panda.cucumber.feature.definition",
        // "com.panda.integrationtest.controller"
        }, tags = {
                "~@ignored" }, monochrome = false, dryRun = false, strict = true, plugin = {
                        "pretty",
                        "html:target/cucumber/result.html",
                        "json:target/cucumber/result.json",
                        "junit:target/cucumber/result.xml" })
@ContextConfiguration(locations = { "classpath:applicationContext-cucumber.xml" })
@SpringBootApplication
// @EntityScan(basePackages = { "com.panda" })
public class SingleFeatureTestRunner {

}
