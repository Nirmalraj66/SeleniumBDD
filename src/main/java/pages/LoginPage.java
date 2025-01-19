package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "username")
	private WebElement txtUsername;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(id="submit")
	private WebElement btnSubmit;
	
	public void enterCredntials(String username, String password)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(txtUsername));
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnSubmit.click();
	}

}
