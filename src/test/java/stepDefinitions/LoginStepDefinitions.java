package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.DriverProperties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;


public class LoginStepDefinitions {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	
	
	@Given("Browser is opened")
	public void launchBrowser() {
		
//		driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println("Url is opened");
	}

	@When("^I enter valid (.*) and (.*)$")
	public void i_complete_action(String username, String password) {
		loginPage = new LoginPage(DriverProperties.getDriver());
		loginPage.enterCredntials(username, password);
	}

	@Then("I validate the Home page is opened successfully")
	public void i_validate_the_outcomes() {
		homePage = new HomePage(DriverProperties.getDriver());
		homePage.verifyHomePageDisplayed();
				
	}
	
	@When("I enter valid credntials")
	public void i_enter_valid_credntials(DataTable dataTable) {
		List<Map<String, String>> credentials = dataTable.asMaps();
		loginPage = new LoginPage(DriverProperties.getDriver());
		loginPage.enterCredntials(credentials.get(0).get("username"), credentials.get(0).get("password"));
	    
	}

}
