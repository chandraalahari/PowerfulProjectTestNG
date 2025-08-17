package com.qa.Tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.factory.DriverFactory;
import com.qa.pages.AllControlsPage;
import com.qa.util.TestListener;

@Listeners(TestListener.class)
public class AllControls extends BaseTest {

	AllControlsPage allctrlPage;
	@BeforeClass
	public void setUpControlsPage() {
		base_url = System.getenv("CONTROLS_URL");
		if (base_url == null || base_url.isEmpty()) {
			base_url = prop.getProperty("controlsurl");
		}
	}
	
	@BeforeMethod
	public void setUpMethod() throws FileNotFoundException, IOException {
		super.setUpMethod();
		allctrlPage = new AllControlsPage(DriverFactory.getDriver());
	}
	
	@Test
	public void inputSimpleControls() {
		allctrlPage.inputSimpleControls();
	}

}
