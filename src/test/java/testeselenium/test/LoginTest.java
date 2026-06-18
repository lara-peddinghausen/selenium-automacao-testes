package testeselenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import testeselenium.pageObject.LoginPO;

//Lembrar de extender BaseTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Executa os testes em ordem alfabética
public class LoginTest extends BaseTest{
	
	private static LoginPO loginPage;
	
	@Before
	public void prepararTestes() {
		driver.get("file:///C:/Users/36129382024.2n/Desktop/Teste%20de%20software/sistema/sistema/login.html"); // Pegar o caminho do arquivo no computador (Propriedades -> Local)
		loginPage = new LoginPO(driver);
	}

	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		loginPage.inputEmail.sendKeys("");
		loginPage.inputSenha.sendKeys("");
		loginPage.buttonEntrar.click();
		String mensagemModal = loginPage.spanMensagem.getText();
		
		assertEquals(mensagemModal, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailESenhaVazios() {
//		loginPage.inputEmail.sendKeys("");
//		loginPage.inputSenha.sendKeys("");
//		loginPage.buttonEntrar.click();
		loginPage.executarAcaoDeLogar("", "");
		
//		String mensagemModal = loginPage.spanMensagem.getText();
		String mensagemModal = loginPage.obterMensagem();
		
		assertEquals(mensagemModal, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailESenhaInvalidos() {
		loginPage.inputEmail.sendKeys("teste");
		loginPage.inputSenha.sendKeys("teste");
		loginPage.buttonEntrar.click();
		String mensagemModal = loginPage.spanMensagem.getText();
		
		assertEquals(mensagemModal, "E-mail ou senha inválidos");
		
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaValidos() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

//		String tituloDaPagina = loginPage.obterTituloDaPagina();
//		
//		assertEquals(tituloDaPagina, "Controle de Produtos");
		
		assertEquals(loginPage.obterTituloDaPagina(), "Controle de Produtos");
		
	}
}
