package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static util.ScreenShot.captureScreenshot;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;
import util.Runner;

public class LoginStepDefinitions extends LoginPage {
	private WebDriver driver = Runner.getDriver();

	@Dado("que eu acesse o site da Swag Labs")
	public void que_eu_acesse_o_site_da_swag_labs() {

		driver.get("https://www.saucedemo.com/");

	}
	
	@Dado("que eu acesse o site com as credenciais validas")
	public void que_eu_acesse_o_site_com_as_credenciais_validas() {
		
		driver.get("https://www.saucedemo.com/");
		efetuarLogin("standard_user", "secret_sauce");
			
	}

	
	@Quando("preencho com o usuario e senha {string}")
	public void preencho_com_o_usuario_e_senha_(String string) {
		switch (string) {
		
		case "validos":
			efetuarLogin("standard_user", "secret_sauce");
			break;

		case "invalidos":
			efetuarLogin("invalid_user", "invalid_password");
			break;

		}	
	}
	
	@Quando("tento logar com o campo {string} vazio")
	public void preencho_com_o_campo_vazio(String string) {
		switch (string) {

		case "usuario":
			efetuarLogin("", "secret_sauce");
			break;

		case "senha":
			efetuarLogin("standard_user", "");
			break;

		}
	}
	
	@Quando("tento logar com um usuario bloqueado")
	public void tento_logar_com_um_usuario_bloqueado() {
		
		efetuarLogin("locked_out_user", "secret_sauce");
		
	}
		
	@Entao("valido a mensagem de erro {string}")
	public void valido_a_mensagem_de_erro(String string) {
		switch (string) {
		case "usuario e senha invalidos":
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Epic sadface: Username and password do not match any user in this service", driver.findElement(errorMessage).getText());
			break;
			
		case "usuario requerido": 
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Epic sadface: Username is required", driver.findElement(errorMessage).getText());
			break;
		
		case "senha requerida":
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Epic sadface: Password is required", driver.findElement(errorMessage).getText());
			break;
			
		case "usuario bloqueado":
			
			captureScreenshot(driver, errorMessage);
			assertEquals("Epic sadface: Sorry, this user has been locked out.", driver.findElement(errorMessage).getText());
			break;
			
		}
	}
	
	@Entao("valido a pagina inicial de login")
	public void valido_a_pagina_inicial_de_login() {
		
		captureScreenshot(driver);
    	assertTrue(driver.findElement(loginLogo).isDisplayed());
		
	}
}
