package com.panda.runner;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, dryRun = false, monochrome = false, tags = {
        "~@ignored" }, features = "src/test/resources/features/", glue = {
                "com.panda.cucumber.feature.definition" }, plugin = {
                        "pretty",
                        "html:target/cucumber/result.html",
                        "json:target/cucumber/result.json",
                        "junit:target/cucumber/result.xml" })
@ContextConfiguration(locations = { "classpath:cucumber.xml" })
public class AllFeaturesTestRunner {

}
