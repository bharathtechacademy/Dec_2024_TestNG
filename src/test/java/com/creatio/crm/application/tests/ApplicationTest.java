package com.creatio.crm.application.tests;

import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {

	@Test(priority = 1)
	public void verifyCookiesPopUpIsDisplayed() {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
	}

	@Test(priority = 2, dataProvider = "data")
	public void verifyCookiesPopupContent(String content) {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookiesPopUpContent(content);
	}

	@Test(priority = 3)
	public void verifyCookiesPopupLogosAndButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
		cookiesPage.verifyCookiesPopUpLogos();
		cookiesPage.verifyCookiesPopUpSwitchButtons();
		cookiesPage.verifyCookiesSelectionButtons();
	}

	@Test(priority = 4)
	public void verifyCookiesPopupViewDetailsLink() {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
		cookiesPage.clickOnShowDetailsLink();
		cookiesPage.verifyCookiesPopUpShowDetails();
	}

	@Test(priority = 5)
	public void verifyCookiesPopupWhenUserAcceptCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
		cookiesPage.selectCookies("AllowAll");
		cookiesPage.verifyCookiesPopUpGettingDisappeared();
	}

	@Test(priority = 6, dataProvider = "data")
	public void verifyApplicationSignUp(String user, String pass) {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
		cookiesPage.selectCookies("AllowAll");
		cookiesPage.verifyCookiesPopUpGettingDisappeared();
		loginPage.clickOnSignUpLink();
		signUpPage.verifySignUpPageIsLaunched();
		signUpPage.enterUserDetails(user, pass);
		signUpPage.clickOnContinueButton();
		signUpPage.enterCompanyDetails();
		signUpPage.clickOnSignUpButton();
		homePage.verifySignUpIsSuccessful();
	}

	@Test(priority = 7, dataProvider = "data")
	public void verifyApplicationLogin(String user, String pass) {
		loginPage.launchApplication();
		cookiesPage.verifyWhetherCookiesPopUpIsDisplayed();
		cookiesPage.selectCookies("AllowAll");
		cookiesPage.verifyCookiesPopUpGettingDisappeared();
		loginPage.enterCredentials(user, pass);
		loginPage.clickOnLoginButton();
		homePage.verifyLoginIsSuccessful();
	}

}
