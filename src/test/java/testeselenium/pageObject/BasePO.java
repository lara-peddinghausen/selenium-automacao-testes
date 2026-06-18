package testeselenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Cria uma instancia do driver

//Componentes

/**
 * Classe base para a criação das novas PageObjects
 * Todas as pages devem herdar esta classe
 * @author 36129382024.2N
 *
 */
public class BasePO {  // Toda página terá um PO
	/** Driver base que será usado pelas pages */
	protected WebDriver driver; // instância do driver que o filho vai ter que implementar.
	
	/**
	 * Construtor base para a criação da fábrica de elementos (PageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
