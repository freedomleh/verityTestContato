package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pagesObjects.Contato;
import util.SeleniumDriver;

public class ContatoTest {

    static Contato sut;
    static WebDriver driver;
    static SeleniumDriver sd;
	
    @Test
    public void teste_Envio_Mensagem_Contato() {
    	
    	try {
    		
    		sd = new SeleniumDriver();
            driver = sd.getDriver();
            sut = new Contato(driver);
            
            sut.acessarVerity();
            sut.acessaContato();
            sut.setContato("Letícia Gonzalez", "Verity", "leticia.s.gonzalez@hotmail.com", "11991841348", "Teste para vaga de Automação");
            sut.enviarMensagem();
           
            assertEquals("Mensagem enviada com sucesso!", sut.getMensagemRetorno());
            
            sut.closeQuit();
            
    	} catch (Exception e) {
			sut.catchErro();
			sut.enviaEmail();
    	}
    }
    
}
