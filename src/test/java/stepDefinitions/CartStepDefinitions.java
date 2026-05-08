package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static util.ScreenShot.captureScreenshot;

import io.cucumber.java.pt.*;
import pages.CartPage;


public class CartStepDefinitions extends CartPage {
	
	@E("remover o produto {string} do carrinho")
	public void remover_o_produto_do_carrinho(String produto) {
		
		acessarCarrinho();
		removerProdutoCarrinho(produto);
	    
	}
	
	@Entao("eu valido que o produto {string} está no carrinho")
	public void eu_valido_que_o_produto_esta_no_carrinho(String produto) {
		
		acessarCarrinho();
		captureScreenshot(driver, buscarProdutoNoCarrinho(produto));
		assertTrue(driver.findElement(buscarProdutoNoCarrinho(produto)).isDisplayed());
		limparCarrinho(produto);
		
	}
	
	@Entao("valido que o produto {string} não está no carrinho")
	public void valido_que_o_produto_nao_esta_no_carrinho(String produto) {
	    
		captureScreenshot(driver);
		assertTrue(driver.findElements(buscarProdutoNoCarrinho(produto)).isEmpty());
		
	}
	
	@Quando("efetuar o checkout {string}")
	public void efetuar_o_checkout(String string) {
		switch (string) {
		case "com informacoes validas":
			efetuarCheckout("João", "Silva", "12345");
			finalizarCompra();
			break;
			
		case "com campo nome vazio":
			efetuarCheckout("", "Silva", "12345");
			break;
			
		case "com campo sobrenome vazio":
			efetuarCheckout("João", "", "12345");
			break;
			
		case "com campo codigo postal vazio":
			efetuarCheckout("João", "Silva", "");
			break;
			
		}	
	}

	@Entao("valido que a compra foi finalizada")
	public void valido_que_a_compra_foi_finalizada() {

		captureScreenshot(driver, orderConfirmation, orderConfirmationText);
		assertEquals("Thank you for your order!", driver.findElement(orderConfirmation).getText());
		assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", driver.findElement(orderConfirmationText).getText());
		
	}
	
	@Entao("valido a mensagem de erro {string} no checkout")
	public void valido_a_mensagem_de_erro_no_checkout(String string) {
		switch (string) {
		case "nome requerido":
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Error: First Name is required", driver.findElement(errorMessage).getText());
			break;
			
		case "sobrenome requerido":
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Error: Last Name is required", driver.findElement(errorMessage).getText());
			break;
			
		case "codigo postal requerido":
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Error: Postal Code is required", driver.findElement(errorMessage).getText());
			break;
			
		}
	}
}
