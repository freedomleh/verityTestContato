package util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil extends SeleniumDriver {

	
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	protected JavascriptExecutor jse;
	protected Actions actions;
	private String idAbaPrincipal;
	
	public SeleniumUtil(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		//actions = new Actions(driver);
		//driverWait = new WebDriverWait(driver, 10);
		//idAbaPrincipal = driver.getWindowHandle();
	}
	
	/**
	 * Utilizado para navegação entre janelas
	 * <p>
	 * o id da aba principal sempre sera a referencia do conjunto de abas
	 * </p>
	 * 
	 * @param idAbaPrincipal
	 *            (deve ser um atributo da classe)
	 */
	public void mudarParaNovaAba(String idAbaPrincipal) {
		String novaAba;
		Iterator<String> abaIterator;
		Set<String> abas;

		abas = driver.getWindowHandles();
		abaIterator = abas.iterator();
		while (abaIterator.hasNext()) {
			novaAba = abaIterator.next();
			if (!novaAba.equals(idAbaPrincipal)) {
				driver.switchTo().window(novaAba);
			}
		}
	}

	/**
	 * utilizado para fechar aba atual e retornar para aba principal
	 * 
	 * @param idAbaPrincipal
	 *            (deve ser um atributo da classe)
	 */
	public void mudarParaAbaPrincipal(String idAbaPrincipal) {
		driver.close();
		driver.switchTo().window(idAbaPrincipal);

	}
	
	public void clicarLink(WebElement element){
		element.click();

		driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

		mudarParaNovaAba(idAbaPrincipal);
	}
	
	public void aguardarCarregarDOM() {
		
		
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				
				boolean isDOMComplete = jse.executeScript("return document.readyState").equals("complete");
			
				//old -> return jQuery.active == 0
				//This will make sure that your jQuery object is defined before checking if there are any active jQuery processes.
				boolean isAjaxActive = (Boolean)jse.executeScript("return window.jQuery != undefined && jQuery.active === 0"); 
				
				return isAjaxActive && isDOMComplete;
			}
		};

		driverWait.until(pageLoadCondition);

	}
	
	public  boolean waitForPageToLoad() {
		boolean pageLoadStatus = false;

		pageLoadStatus = driverWait
				.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';")) != null;

		return pageLoadStatus;
	}
	
}
