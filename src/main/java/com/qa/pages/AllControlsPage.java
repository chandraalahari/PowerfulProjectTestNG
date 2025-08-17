package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllControlsPage {
	
	private WebDriver driver;
	private WebDriverWait eWait;
	
	public AllControlsPage(WebDriver driver) {
		this.driver = driver;
		eWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "txtName")
	private WebElement idTxtName;

	public void inputSimpleControls() {
		idTxtName.sendKeys("Chandra");
	}

}
