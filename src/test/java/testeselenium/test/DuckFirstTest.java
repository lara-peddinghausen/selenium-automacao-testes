package testeselenium.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckFirstTest {
	private WebDriver driver;
	private final String URL_BASE = "https://duckduckgo.com/";
	private final String PATH_DRIVE = "src/test/resources/chromedriver.exe"; // botão direito no chromedriver -> copy qualified name - tirar o /automatizados/
	
	// chama o selenium
	private void iniciar() { // prepara e abre o navegador Chrome antes dos testes automatizados começarem.
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE); //Define onde está o arquivo chromedriver.exe, que é o programa usado pelo Selenium para controlar o Chrome.
		driver = new ChromeDriver(); //Cria uma nova instância do navegador Chrome.
		driver.manage().window().maximize(); // Abre o navegador em tela maximizada.
		driver.get(URL_BASE); //Acessa a URL definida
	}
	
	// chama o junit
	@Test
	public void testPesquisarNoDuckGo() {
		//Montagem do cenário
		iniciar();
		
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.id("searchbox_input")); //acessa o campo de busca pelo id
		
		//Execução		
		inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER); //insere o texto no campo acessado e da enter
		
		String resultado = driver.findElement(By.cssSelector("span.EKtkFWMYpwzMKOYr0GYm")).getText(); //captura o elemento pela classe da tag span. Pegar somente a primeira parte do span class (EKtkFWMYpwzMKOYr0GYm)
		
		System.out.println(resultado);
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("chocolate"));
	
		driver.quit();
	}

	
}
