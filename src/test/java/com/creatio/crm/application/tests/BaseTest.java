package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilities.ExcelUtil;

public class BaseTest extends BasePage {

	public LoginPageSteps loginPage;
	public CookiesPageSteps cookiesPage;
	public HomePageSteps homePage;
	public SignUpPageSteps signUpPage;

	@BeforeMethod(dependsOnMethods = "setupBrowser")
	public void initializeAllPages() {
		WebDriver driver = new BasePage().getDriver(); //get driver after launching the browser window successfully
		loginPage = new LoginPageSteps(driver); // pass browser details to each class while locating elements
		cookiesPage = new CookiesPageSteps(driver);
		homePage = new HomePageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);
	}
	
	@DataProvider(name="data")
	public String [][] testData(Method method){
		String [][] data = ExcelUtil.readData("TestData.xlsx", method.getName());
		return data;
	}

}
