package pages;

import static util.ScreenShot.captureScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Runner;


public class LoginPage {
	protected WebDriver driver = Runner.getDriver();
	
	protected By inputUSerName = By.id("user-name");
	protected By inputPassword = By.id("password");
	protected By btnLogin = By.id("login-button");
	protected By errorMessage = By.cssSelector("h3[data-test='error']");
	protected By loginLogo = By.className("login_logo");

	public void efetuarLogin(String user, String password) {
		driver.findElement(inputUSerName).sendKeys(user);
		driver.findElement(inputPassword).sendKeys(password);
		captureScreenshot(driver, btnLogin);
		driver.findElement(btnLogin).click();
		
	}
	
}
