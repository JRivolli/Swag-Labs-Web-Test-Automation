package pages;

import static util.ScreenShot.captureScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.RunnerTest;

public class HomePage {
	protected WebDriver driver = RunnerTest.getDriver();

	protected By homePageLogo = By.className("app_logo");
	protected By btnOpenMenu = By.id("react-burger-menu-btn");
	protected By btnLogout = By.id("logout_sidebar_link");	

	public void abrirMenu() {
		
		driver.findElement(btnOpenMenu).click();
		
	}
	
	public void efetuarLogout() {
		
		abrirMenu();
		captureScreenshot(driver, btnLogout);
		driver.findElement(btnLogout).click();
		
	}
	
	public void adicionarProdutoCarrinho(String product) {
		
		By btnAddToCart = By.xpath("//*[@class=\"inventory_item_name \" and contains(text(), \"" + product + "\")]//../../..//div[@class=\"pricebar\"]//button");
		
		captureScreenshot(driver, btnAddToCart);
		driver.findElement(btnAddToCart).click();
		
	}
}
