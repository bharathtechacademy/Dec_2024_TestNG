package com.creatio.crm.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {

	// This class will have all the common methods related to browser configurations

	private static WebDriver driver = null;

	// method to launch the browser based on browser name coming from runner file
	@BeforeMethod(alwaysRun=true)
	@Parameters(value = "browser")
	public void setupBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Invalid browser input");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	// method to tear down the browser sessions
	@AfterMethod(alwaysRun=true)
	public void teardownBrowser() {
		driver.quit();
	}

	// method to share browser session (driver) with other classes
	public WebDriver getDriver() {
		return driver;		
	}
	
	// method to update browser session
	public void setDriver(WebDriver newDriver) {
		driver =newDriver ;		
	}
}
