package hooks;

import java.util.concurrent.TimeUnit;

import utils.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	WebDriver driver = null;
	ConfigReader configReader = new ConfigReader();
	DriverProperties driverProperties = new DriverProperties();
	
	
//	@Before
//	public static WebDriver intializeBrowser()
//	{
//		try {
//			if(browser.equalsIgnoreCase("chrome"))
//			{
//			String projectPath = System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return driver;
//	}
	
	@Before
	public void setUp() {
		String browser = configReader.getConfigValue("browser");
		driver = driverProperties.initializeBrowser(browser);
		driver.get(configReader.getConfigValue("url"));
	}

	@After
	public void teardown(Scenario scenario) {
		String scenarioName = scenario.getName();
		if(scenario.isFailed())
		{
			 byte[] scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(scrFile, "img/png", scenarioName);
		}
		
		
		driver.quit();
	}
}
