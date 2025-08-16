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
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(DriverFactory.getDriver());
	}

	@Test(priority = 0, alwaysRun = true, description = "Login test are executed - Assert Page Title", retryAnalyzer = RetryAnalyzer.class)
	@Description("The Title Page Text Test")
	public void onionToolWebTitle() {
		String title = loginPage.getTitle();
		Assert.assertTrue(title.contains("Sign in to Onion"));
	}
	
	@Test(priority = 1, alwaysRun = true, description = "Forgot password link exist", retryAnalyzer = RetryAnalyzer.class)
	@Epic("Home Page Epic")
	@Feature("Home Page features")
	@Story("Home Page Story")
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPasswordLinkExists() {
		loginPage.clickForgotPasswordLink();
		boolean forgotText = loginPage.forgotPassWordPageShown();
		Assert.assertTrue(forgotText);
	}
	
	@Test(priority = 2, alwaysRun = true, description = "User Login Test", retryAnalyzer = RetryAnalyzer.class)
	@Epic("User Login Epic")
	@Feature("User Login features")
	@Story("User Login Story")
	@Severity(SeverityLevel.CRITICAL)
	public void userLoginTest() {
		loginPage.enterUserName("onion@gnapi.tech");
		loginPage.enterPassword("Gnapi@1234");
		loginPage.clickSignIn();
		String landingPageText = loginPage.extractTitleOnHomePage();
		Assert.assertEquals(landingPageText, "Onion: Complete Test Management Platform");
	}
	

}
