package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProperties {
	
	public static WebDriver driver ;
	
	public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initializeBrowser(String browserName)
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		tDriver.set(new ChromeDriver());
		tDriver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		tDriver.get().manage().window().maximize();
		return getDriver();
		
	}
	
	public static WebDriver getDriver() {
		driver = tDriver.get();
		return driver;
	}

}
