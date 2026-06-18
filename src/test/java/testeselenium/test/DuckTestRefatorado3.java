package testeselenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;

import testeselenium.pageObject.DuckPO;

// DuckFirstTest refatorada para usar BaseTest
// Separando a lógica de infra do teste automatizado
// Como extende da BaseTest e lá o iniciar() é um @BeforeClass, não preciso chamar o iniciar aqui. O mesmo vale para o finalizar()
public class DuckTestRefatorado3 extends BaseTest {
	
	private static DuckPO duckPage;
	
	@Before
	public void prepararTestes() {
		driver.get("https://duckduckgo.com/");
		duckPage = new DuckPO(driver);
	}
	
	@Test
	public void testPesquisarNoDuckGo2() {
		
		duckPage.inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER);
		
		String resultado = duckPage.resultado.getText();
		
		assertTrue(resultado, resultado.contains("chocolate"));
		
	}
	
	@Test
	public void testPesquisarNoDuckGo3() {
		
		//duckPage.inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER);
		duckPage.pesquisar("Receita de bolo de laranja");
		
		//String resultado = duckPage.resultado.getText();
		String resultado = duckPage.obterResultadoDaPesquisa();
		
		assertTrue(resultado, resultado.contains("laranja"));
		
	}
	
	
}
