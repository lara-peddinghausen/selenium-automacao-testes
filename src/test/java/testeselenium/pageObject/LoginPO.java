package testeselenium.pageObject;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Lembrar de extender BasePO
public class LoginPO extends BasePO{ //corrigir erro(gerar construtor
	
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear(); // primeiro limpa o campo
		input.sendKeys(texto, Keys.TAB); // tab para passar para o próximo campo
	}
	
	public void executarAcaoDeLogar(String email, String senha) { // executa 2 vezes o método escrever
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
		buttonEntrar.click();
	}
	
	public String obterTituloDaPagina() {
		return driver.getTitle();
		
	}

	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
}
