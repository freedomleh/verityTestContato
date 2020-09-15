package locators;

import org.openqa.selenium.By;


public enum LocatorContato {

    CONTATO (By.id("comp-kevyodnk7label")),
    NOME_COMPLETO (By.id("comp-kex026e31input")),
    EMPRESA (By.id("comp-kex026ecinput")),
    EMAIL (By.id("comp-kex026eeinput")),
    FONE (By.id("comp-kex026eginput")),
    MENSAGEM (By.id("comp-kex026eitextarea")),
    ENVIAR (By.id("comp-kex026eq2label")),
    MENSAGEM_RETORNO (By.cssSelector("span > .font_8 > span > span > span"));

	public static String URL_VERITY = "https://www.verity.com.br/";
    
	private By locator;
	
	LocatorContato(By locator){
		this.locator = locator;
	}
	
	public By getLocator(){
		return locator;
	}
	
	
	
}
