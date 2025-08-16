package com.qa.Tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.util.TestListner;

@Listeners(TestListner.class)
public class LoginTest extends BaseTest {

	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(DriverFactory.getDriver());
	}

	@Test(priority = 0, alwaysRun = true, description = "Login test are executed - Assert Page Title")
	public void userLogin() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("Sign"));
		String title = loginPage.getTitle();
		Assert.assertTrue(title.contains("Sign"));
	}

}
