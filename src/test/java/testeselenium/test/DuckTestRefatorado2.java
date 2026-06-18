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
public class DuckTestRefatorado2 extends BaseTest {
	
	private static DuckPO duckPage;
	
	@Before
	public void prepararTestes() {
		driver.get("https://duckduckgo.com/");
		duckPage = new DuckPO(driver);
	}
	
	@Test
	public void testPesquisarNoDuckGo() {
		//Montagem do cenário
		//@BeforeClass e
		//private satatic void iniciar() na classe BaseTest
		
		//Preparação
		//WebElement inputPesquisa = driver.findElement(By.id("searchbox_input")); //acessa o campo de busca pelo id
		
		//Execução		
		//inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER); //insere o texto no campo acessado e da enter
		duckPage.inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER);
		
		//String resultado = driver.findElement(By.cssSelector("span.EKtkFWMYpwzMKOYr0GYm")).getText(); //captura o elemento pela classe da tag span
		String resultado = duckPage.resultado.getText();
		
		System.out.println(resultado);
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("chocolate"));
		
		//Não precisa
		//driver.quit();
		//Pois temos em BaseTest
		//@AfterClass
		//public static void finalizar()
	}
	
	@Test
	public void testPesquisarNoDuckGo2() {
		
		duckPage.inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER);
		
		String resultado = duckPage.resultado.getText();
		
		assertTrue(resultado, resultado.contains("chocolate"));
		
	}
	
}
