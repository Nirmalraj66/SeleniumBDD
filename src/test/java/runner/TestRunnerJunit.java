package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/",
		glue= {"stepDefinitions","hooks"},
		monochrome=true,
		plugin= {"pretty","html:target/HTMLReports/index.html",
				"pretty","junit:target/XMLReports/index.xml",
				"pretty","html:target/JSONReports/index.json",
			    "me.jvt.cucumber.report.PrettyReports:target/cucumber",
			    "rerun:target/FailedScenarios/failedScenarios.txt"},
		tags="@LoginPage"


		)
public class TestRunnerJunit   {
	
	
	
	}


