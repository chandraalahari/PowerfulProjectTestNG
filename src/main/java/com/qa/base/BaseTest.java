package com.qa.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
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
		browser = prop.getProperty("browser", "chrome");
		log.info("Browser selected is - " + browser);
	}

	@BeforeMethod
	public void setUpMethod() throws FileNotFoundException, IOException {
		DriverFactory.getInstance().initiateBrowser(browser);
		DriverFactory.getDriver().get(prop.getProperty("mainurl"));
	}

	@AfterMethod
	public void tearDownDriver() {
		DriverFactory.quitBrowser();
	}
}
