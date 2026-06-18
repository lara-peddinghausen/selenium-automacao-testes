package testeselenium.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//infra + navegador
//instrumentação do código
public class BaseTest {
	
	protected static WebDriver driver; // protected -> quer proteção e manter abertura na hierarquia da herança
	private static final String URL_BASE = "https://duckduckgo.com/";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver.exe"; // botão direito no chromedriver -> copy qualified name - tirar o /automatizados/
	
	@BeforeClass
	public static void iniciar() { // prepara e abre o navegador Chrome antes dos testes automatizados começarem.
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE); //Define onde está o arquivo chromedriver.exe, que é o programa usado pelo Selenium para controlar o Chrome.
		driver = new ChromeDriver(); //Cria uma nova instância do navegador Chrome.
		driver.manage().window().maximize(); // Abre o navegador em tela maximizada.
		driver.get(URL_BASE); //Acessa a URL definida
	}
	
	@AfterClass
	public static void finalizar() {
		driver.quit();
	}

}
