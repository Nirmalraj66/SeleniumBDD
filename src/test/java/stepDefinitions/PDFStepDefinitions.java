package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DriverProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FileDownloadPage;


public class PDFStepDefinitions {
	WebDriver driver = null;

	 FileDownloadPage fileDownloadPage = new FileDownloadPage(DriverProperties.getDriver());
	

//	@Before
//	public void intializeBrowser() {
//		String projectPath = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		
//	}
//
//	@After
//	public void teardown() {
//		driver.quit();
//	}

	@Given("I hit the URL for Download")
	public void openDownloadURL() {
		DriverProperties.getDriver().get("https://the-internet.herokuapp.com/download");
		
	}

	@When("I download the file")
	public void downLoadFile() {
		fileDownloadPage.clickOnElement();
		
	}

	
	@Then("^I validate the (.*) inside the file$")
	public void validateDownloadedFile(String expectedText) {
		
		Assert.assertTrue(fileDownloadPage.validateFileContent(expectedText));

	}

}
