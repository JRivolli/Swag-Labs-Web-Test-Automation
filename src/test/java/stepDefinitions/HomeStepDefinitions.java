package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static util.ScreenShot.captureScreenshot;

import io.cucumber.java.pt.*;
import pages.HomePage;


public class HomeStepDefinitions extends HomePage {
	
	@Quando("efetuo o logout")
	public void efetuo_o_logout() {
		
		efetuarLogout();
		
	}
	
	@Entao("valido o acesso")
	public void valido_o_acesso() {

		captureScreenshot(driver, homePageLogo);
		assertTrue(driver.findElement(homePageLogo).isDisplayed());
		
	}
	
	@Quando("adicionar o produto {string} no carrinho")
	public void adicionar_o_produto_no_carrinho(String produto) {
		
		adicionarProdutoCarrinho(produto);
		
	}
}
