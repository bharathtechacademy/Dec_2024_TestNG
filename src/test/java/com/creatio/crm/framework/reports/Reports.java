package com.creatio.crm.framework.reports;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	// This class will have all common methods related to test result reports
	
	public static ExtentReports extent = null; 
	public static ExtentHtmlReporter html= null;
	public static ExtentTest logger= null;
	
	//method to setup report
	@BeforeSuite(alwaysRun=true)
	public void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationTestResults.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	//method to start printing process for each test case
	public void startReporting(String testcaseName) {
		logger = extent.createTest(testcaseName);
		logger.info("Test Execution started for "+testcaseName);
	}
	
	//method to stop reporting
	public void stopReporting() {
		extent.flush();
	}

}
