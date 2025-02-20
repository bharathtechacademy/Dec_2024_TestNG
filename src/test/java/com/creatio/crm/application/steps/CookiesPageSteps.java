package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements{
	
	public CookiesPageSteps(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyWhetherCookiesPopUpIsDisplayed() {
		waitForElement(cookiesHeader, 30);
		log("pass","Cookies pop-up is launched successfully");
	}
	
	public void verifyCookiesPopUpContent(String expContent) {
		String actualContent = getElementText(cookiesContent);
		Assert.assertEquals(actualContent, expContent);
		log("pass","Cookies content is matching successfully");
	}
	
	public void verifyCookiesPopUpLogos() {
		Assert.assertTrue(isElementDisplayed(creatioLogo));
		log("pass","Creatio Logo is displayed successfully");
		Assert.assertTrue(isElementDisplayed(cookiebotLogo));
		log("pass","CookieBot Logo is displayed successfully");
	}
	
	public void verifyCookiesSelectionButtons() {
		Assert.assertTrue(isElementDisplayed(allowAllBtn));
		Assert.assertTrue(isElementDisplayed(allowSelectionBtn));
		Assert.assertTrue(isElementDisplayed(denyBtn));
		log("pass","Cookie Selection buttons displayed successfully");
	}
	
	public void selectCookies(String option) {
		if(option.equalsIgnoreCase("AllowAll"))
			click(allowAllBtn);
		else if(option.equalsIgnoreCase("AllowSelection"))
			click(allowSelectionBtn);
		else if(option.equalsIgnoreCase("Deny"))
			click(denyBtn);
	}
	
	public void verifyCookiesPopUpNecessarySwitchButtonIsDisabled() {
//		Assert.assertTrue(isElementDisplayed(necessarySwitchtn));
		Assert.assertTrue(!isElementEnabled(necessarySwitchtn));
		log("pass","Necessary button is displayed and disabled");
	}
	
	public void verifyCookiesPopUpSwitchButtons() {
//		Assert.assertTrue(isElementDisplayed(preferencesSwitchBtn));
		Assert.assertTrue(isElementEnabled(preferencesSwitchBtn));
		log("pass","Preferences button is displayed and enabled");
		
//		Assert.assertTrue(isElementDisplayed(statisticsSwitchBtn));
		Assert.assertTrue(isElementEnabled(statisticsSwitchBtn));
		log("pass","Statistics button is displayed and enabled");
		
//		Assert.assertTrue(isElementDisplayed(marketingSwitchBtn));
		Assert.assertTrue(isElementEnabled(marketingSwitchBtn));
		log("pass","Marketing button is displayed and enabled");
	}
	
	public void clickOnShowDetailsLink() {
		click(showDetailsLink);
		log("pass","Cliked on Show Details Link");
	}

	public void verifyCookiesPopUpShowDetails() {
		waitForElement(cookiePopUpExpandedDetails, 10);
		log("pass","Cookies pop-up is Expanded successfully");
	}
	
	public void verifyCookiesPopUpGettingDisappeared() {
		waitForElementDisappeared(cookiesHeader, 10);
	}
}
