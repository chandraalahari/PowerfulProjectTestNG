package com.qa.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.qa.factory.ConfigReader;
import com.qa.factory.DriverFactory;
import com.qa.util.LoggerHelper;

public class BaseTest {

	private String browser;
	protected Logger log;
	private Properties prop;

	@BeforeSuite
	public void setUpClass() throws FileNotFoundException, IOException {
		log = LoggerHelper.getLogger(this.getClass());
	    prop = ConfigReader.readConfigProperties();
		browser = System.getenv("BROWSER");
		if(browser == "" || browser.isEmpty())
			browser = "chrome"; //assign default
		log.info("Browser selected is - " + browser);
	}

	@BeforeMethod
	public void setUpMethod() throws FileNotFoundException, IOException {
		DriverFactory.getInstance().initiateBrowser(browser);
		String onionUrl = System.getenv("BASE_URL");
		if(onionUrl == null || onionUrl.isEmpty()) {
			onionUrl = prop.getProperty("mainurl");
		}
		
		DriverFactory.getDriver().get(onionUrl);
		WaitforPageLoad();
	}

	private void WaitforPageLoad() {
		 new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20))
		          .until(ExpectedConditions.titleContains("Sign"));
		
	}

	@AfterMethod
	public void tearDownDriver() {
		DriverFactory.quitBrowser();
	}
}
