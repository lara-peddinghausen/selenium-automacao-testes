package testeselenium.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Desacopla elementos da página da parte de test

public class DuckPO extends BasePO{

	/**
	 * PageFactory: injeta em tempo de execução (cria dinamicamente)
	 * uma lógica dentro da classe de teste que instancia DuckPO,
	 * no caso DuckTestRefatorado2.
	 * P elemento/código que cria a factory está em BasePO
	 * (PageFactory.initElements(driver, this)), que é herdado por DuckPO 
	 * @param driver
	 */
	
	//WebElement inputPesquisa = driver.findElement(By.id("searchbox_input"));  //acessa o campo de busca pelo id
	@FindBy(id = "searchbox_input") 
	public WebElement inputPesquisa;
	
	//String resultado = driver.findElement(By.cssSelector("span.EKtkFWMYpwzMKOYr0GYm")).getText(); //captura o elemento pela classe da tag span
	@FindBy(css = "span.EKtkFWMYpwzMKOYr0GYm")
	public WebElement resultado;
	
	/**
	 * Construtor para criação da página do DuckDuckGo
	 * @param driver (Driver da página do DuckDuckGo)
	 */
	public DuckPO(WebDriver driver) {
		super(driver);
	}
	
	//***** para duckTestRefatorado3: máximo isolamento
	/** Método que irá efetuar uma pesquisa no Google baseado no texto
	 * @param texto Texto a ser pesquisado
	 */
	
//	duckPage.inputPesquisa.sendKeys("Receita de bolo de chocolate" + Keys.ENTER);
	public void pesquisar(String texto) {
		inputPesquisa.sendKeys(texto + Keys.ENTER);
	}
	
//	String resultado = duckPage.resultado.getText();
	public String obterResultadoDaPesquisa() {
		return resultado.getText();
	}

}
