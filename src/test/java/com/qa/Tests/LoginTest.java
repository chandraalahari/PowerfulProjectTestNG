package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.util.RetryAnalyzer;
import com.qa.util.TestListener;

import io.qameta.allure.Description;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(DriverFactory.getDriver());
	}

	@Test(priority = 0, alwaysRun = true, description = "Login test are executed - Assert Page Title", retryAnalyzer = RetryAnalyzer.class)
	@Description("The Title Page Text Test")
	
	public void userLogin() {
		String title = loginPage.getTitle();
		Assert.assertTrue(title.contains("Sign"));
	}

}
