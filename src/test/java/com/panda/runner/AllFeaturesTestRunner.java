package com.panda.runner;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/"
		,glue={"com.rakuten.jid.test.stepDefination"} 
		,monochrome = false
//		,dryRun = true 
		,plugin = {
				"pretty" ,"html:cucumber_run_report" ,
                "json:run_result/cucumber_result.json" ,
                "junit:junit_result/cucumber-result.xml"}
		,strict = true
		)
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public class AllFeaturesTestRunner {
	

}


