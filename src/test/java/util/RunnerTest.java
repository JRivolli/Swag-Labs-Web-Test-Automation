package util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"summary", "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		features = "src/test/java/features", 
		glue = {"stepDefinitions", "util"},
		tags = "@Login")

public class RunnerTest {
	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
//		options.addArguments("--headless");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}	
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
}
