package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/resources/Features/",
		glue= {"StepDefinitions"},
		monochrome=true,
		plugin= {"pretty","html:target/HTMLReports/index.html",
				"pretty","junit:target/XMLReports/index.xml",
				"pretty","html:target/JSONReports/index.json"}
//		tags="@PDF"


		)
public class TestRunner2 extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	}


