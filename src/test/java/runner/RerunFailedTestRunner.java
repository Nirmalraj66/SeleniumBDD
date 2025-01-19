package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/FailedScenarios/failedScenarios.txt",
		glue= {"StepDefinitions"},
		monochrome=true,
		plugin= {"pretty","html:target/HTMLReports/index.html",
				"pretty","junit:target/XMLReports/index.xml",
				"pretty","html:target/JSONReports/index.json",
			    "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
		tags="@PDF"


		)
public class RerunFailedTestRunner   {
	
	
	
	}


