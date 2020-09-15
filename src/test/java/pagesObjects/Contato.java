package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import locators.LocatorContato;
import util.EnviaEmail;
import util.GerarScreenShot;
import util.SeleniumUtil;

public class Contato extends SeleniumUtil {

    public Contato(WebDriver driver)
    {
		super(driver);
    }
    
    public void acessarVerity()
    {
    	driver.manage().window().maximize();
		driver.get(LocatorContato.URL_VERITY);
    }
    
    public void acessaContato()
    {
        driver.findElement(LocatorContato.CONTATO.getLocator()).click();
    }

    public void setContato(String nome, String empresa, String email, String fone, String mensagem)
    {	
    
    	aguardarCarregarDOM();
    	
    	//driverWait.until(ExpectedConditions.presenceOfElementLocated((LocatorContato.NOME_COMPLETO.getLocator())));
    	//driverWait.until(ExpectedConditions.visibilityOfElementLocated((LocatorContato.NOME_COMPLETO.getLocator())));
    	
        driver.findElement(LocatorContato.NOME_COMPLETO.getLocator()).sendKeys(nome);
        driver.findElement(LocatorContato.EMPRESA.getLocator()).sendKeys(empresa);
        driver.findElement(LocatorContato.EMAIL.getLocator()).sendKeys(email);
        driver.findElement(LocatorContato.FONE.getLocator()).sendKeys(fone);
        driver.findElement(LocatorContato.MENSAGEM.getLocator()).sendKeys(mensagem);
    }
    
    public void enviarMensagem()
    {
        driver.findElement(LocatorContato.ENVIAR.getLocator()).click();
    }
    
    public String getMensagemRetorno() {
    	
    	String x = driver.findElement(LocatorContato.MENSAGEM_RETORNO.getLocator()).getText();
    	
    	System.out.println(x);
    	
    	return x;
    }
    
    public void closeQuit() {
    	
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
    }

	public void catchErro () {
		GerarScreenShot capturar = new GerarScreenShot(driver);
  		capturar.capturar();
	}
	
	public void enviaEmail () {
		EnviaEmail enviarEmail = new EnviaEmail();
		enviarEmail.envia("Erro no contato");
	}
	
    
}
