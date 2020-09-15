package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumDriver {

	static final Logger LOGGER = LoggerFactory.getLogger(SeleniumDriver.class);
	
	private WebDriver driver;

	public WebDriver getDriver() {
		
		if (driver == null) {
			init();
			return driver;
		}
		
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	private void init() {

		try {

			FirefoxOptions ffOptions = new FirefoxOptions();
			//ffOptions.setAcceptInsecureCerts(true);
			//ffOptions.setHeadless(false);
			ffOptions.addPreference("browser.cache.disk.enable", false);
			ffOptions.addPreference("browser.cache.memory.enable", false);
			ffOptions.addPreference("browser.cache.offline.enable", false);
			ffOptions.addPreference("network.http.use-cache", false);
			
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\leticia.gonzalez\\workspace-eclipse\\br.com.verity.avaliacaoteste\\src\\main\\java\\resources\\geckodriver.exe");
			ffOptions.setCapability("marionette", true);

			driver = new FirefoxDriver(ffOptions);

		} catch (Exception e) {
			LOGGER.error("Nao foi inicializar selenium. Problema com o ambiente: {}", e.getMessage());
		}

	}
	
	
}
