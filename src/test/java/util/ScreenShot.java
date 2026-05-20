package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenShot {
	
	/** Screenshot com realce de um elemento */
	public static byte[] captureScreenshot(WebDriver driver, By by) {
		
		//Espera o elemento estar visível antes de capturar a tela
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String originalStyle = element.getAttribute("style");
		js.executeScript("arguments[0].style.border='3px solid red'", element);
			    
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Hooks.scenario.attach(screenshot, "image/png", "");
		
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
        
        return screenshot;
        	
	}
	
	/** Screenshot com realce de dois elementos */
	public static byte[] captureScreenshot(WebDriver driver, By by, By by2) {
		
		//Espera o elemento estar visível antes de capturar a tela
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by2));
		
		WebElement element = driver.findElement(by);
		WebElement element2 = driver.findElement(by2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String originalStyle = element.getAttribute("style");
		String originalStyle2 = element2.getAttribute("style");
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		js.executeScript("arguments[0].style.border='3px solid red'", element2);
			    
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Hooks.scenario.attach(screenshot, "image/png", "");
		
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element2, originalStyle2);
        
        return screenshot;
        	
	}
	
	
	/** Screenshot simples */ 
	public static byte[] captureScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Hooks.scenario.attach(screenshot, "image/png", "");
		
		return screenshot;

	}

}
