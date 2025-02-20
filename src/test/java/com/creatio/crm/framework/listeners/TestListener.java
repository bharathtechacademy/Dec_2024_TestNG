package com.creatio.crm.framework.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class TestListener extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();
		startReporting(testcaseName);
	}

	public void onTestSuccess(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();
		logger.pass("Test Execution is successful for "+testcaseName);
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();		
		logger.fail("Test Execution is Failed for Test Case :"+testcaseName);
		logger.fail("Test Execution is Failed due to :"+result.getThrowable().getLocalizedMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeWindowScreenshot(new BasePage().getDriver(), testcaseName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
