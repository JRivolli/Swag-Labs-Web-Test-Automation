package pages;

import static util.ScreenShot.captureScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Runner;

public class CartPage {
	protected WebDriver driver = Runner.getDriver();
	
	protected By cartItemName = By.className("inventory_item_name");
	protected By btnCart = By.className("shopping_cart_link");
	protected By btnCheckout = By.id("checkout");
	protected By inputFirstName = By.id("first-name");
	protected By inputLastName = By.id("last-name");
	protected By inputPostalcode = By.id("postal-code");
	protected By btnContinue = By.id("continue");
	protected By btnfinish = By.id("finish");
	protected By orderConfirmation = By.className("complete-header");
	protected By orderConfirmationText = By.className("complete-text");
	protected By errorMessage = By.xpath("//*[@data-test=\"error\"]  ");

    
	public void acessarCarrinho() {
		
		captureScreenshot(driver, btnCart);
		driver.findElement(btnCart).click();
		
	}
    
    public By buscarProdutoNoCarrinho(String product) {
		
		By cartItem = By.xpath("//*[@class=\"inventory_item_name\" and contains(text(), \"" + product + "\")]");
		return cartItem;
    			
	}
	
    public void removerProdutoCarrinho(String product) {
    	
    	By btnRemoveFromCart = By.xpath("//*[@class=\"inventory_item_name\" and contains(text(), \"" + product + "\")]/../..//div[@class=\"item_pricebar\"]//button");
    	captureScreenshot(driver, btnRemoveFromCart);
    	driver.findElement(btnRemoveFromCart).click();
    	
    }
    
    public void efetuarCheckout(String firstName, String lastName, String postalCode) {
		
    	driver.findElement(btnCart).click();
		captureScreenshot(driver, btnCheckout);
		driver.findElement(btnCheckout).click();
		driver.findElement(inputFirstName).sendKeys(firstName);
		driver.findElement(inputLastName).sendKeys(lastName);
		driver.findElement(inputPostalcode).sendKeys(postalCode);
		captureScreenshot(driver, btnContinue);
		driver.findElement(btnContinue).click();
					
	}
    
    public void finalizarCompra() { 
    	
    	captureScreenshot(driver, btnfinish);
    	driver.findElement(btnfinish).click();
    	
    }
    
    public void limparCarrinho(String product) {
		
		By btnRemoveFromCart = By.xpath("//*[@class=\"inventory_item_name\" and contains(text(), \"" + product + "\")]/../..//div[@class=\"item_pricebar\"]//button");
		
		while (!driver.findElements(btnRemoveFromCart).isEmpty()) {
			driver.findElement(btnRemoveFromCart).click();
		}
		
	}
}
