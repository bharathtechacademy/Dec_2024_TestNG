package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void verifyLoginIsSuccessful() {
		waitForElement(homePageHeaderLink,10);
		log("pass","Application Login is Successful");
	}
	
	public void verifySignUpIsSuccessful() {
		waitForElement(homePageHeaderLink,10);
		log("pass","Application Sign Up is Successful");
	}


}
