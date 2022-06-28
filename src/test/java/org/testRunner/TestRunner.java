package org.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/org/featurefile",
		glue= {"org/appHook","org/stepDef"},
		dryRun=false,
		tags="@Smoke",
		monochrome=true,
		plugin= {"pretty",
				"html:./Reports/html_Report/Report.html",
				"json:./Reports/json_Report/Report.json",
				"junit:./Reports/junit_Report/Report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)
public class TestRunner {
	

}
