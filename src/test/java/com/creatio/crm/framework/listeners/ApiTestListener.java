package com.creatio.crm.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.api.commons.ApiCommons;
import com.creatio.crm.framework.reports.Reports;

public class ApiTestListener extends Reports implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();
		startReporting(testcaseName);
	}

	public void onTestSuccess(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();		
		logger.pass("Test Execution is successful for "+testcaseName);
		logger.pass(ApiCommons.response.getBody().asPrettyString());
		stopReporting();
	}

	public void onTestFailure(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();		
		logger.fail("Test Execution is Failed for Test Case :"+testcaseName);
		logger.fail("Test Execution is Failed due to :"+result.getThrowable().getLocalizedMessage());
		logger.pass(ApiCommons.response.getBody().asPrettyString());
		stopReporting();
	}

}
