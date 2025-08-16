package com.qa.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayInputStream;

import com.qa.factory.DriverFactory;

import io.qameta.allure.Allure;



public class TestListner implements ITestListener {

	protected Logger log = LoggerHelper.getLogger(TestListner.class);

	public void onTestStart(ITestResult result) {
		//ExtentTestManager.createTest(result.getTestName());
		log.info("Test Method Started " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		//ExtentTestManager.getTest().pass(result.getTestName());
		log.info("Test Method Success " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		//ExtentTestManager.getTest().fail(result.getTestName());
		log.error("Test Method Failure " + result.getName());
		File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		byte[] srcBytes = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		String desSrc = System.getProperty("user.dir") + "/Screenshot/" + result.getName() + System.currentTimeMillis()
				+ ".png";
		/*
		 * if (ExtentTestManager.getTest() != null) {
		 * ExtentTestManager.getTest().fail(result.getTestName());
		 * ExtentTestManager.getTest().fail("Screenshot of Failure",
		 * com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(
		 * desSrc).build()); } else { log.error("ExtentTest not found for " +
		 * result.getTestName()); }
		 */
		try {
			FileUtils.copyFile(src, new File(desSrc));

			Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(srcBytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		//ExtentTestManager.getTest().skip(result.getTestName());
		log.warn("Test Method Skipped " + result.getName());
	}

	public void onFinish(ITestContext context) {
		log.info("Test Class Finish " + context.getName());
		//ExtentManager.getExtentReports().flush();
	}

}
