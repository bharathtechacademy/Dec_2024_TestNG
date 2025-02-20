package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class SignUpPageElements extends WebCommons{
	
	@FindBy(xpath="//div[text()='Create a free account']")
	public WebElement signUpPageHeader;
	
	@FindBy(xpath="//input[@aria-label='Business email']")
	public WebElement businessEmailTxtb;
	
	@FindBy(xpath="//input[@aria-label='Password']")
	public WebElement passwordTxtb;
	
	@FindBy(xpath="//span[text()=' CONTINUE ']")
	public WebElement continueBtn;
	
	@FindBy(xpath="//img[@class='icon-LinkedIn']")
	public WebElement linkedInIcon;
	
	@FindBy(xpath="//img[@class='icon-google']")
	public WebElement googleIcon;
	
	@FindBy(xpath="//img[@class='icon-facebook']")
	public WebElement facebookIcon;
	
	@FindBy(xpath="//div[text()='Have an account?']")
	public WebElement signUpHeader;
	
	@FindBy(xpath="//span[text()=' log in ']")
	public WebElement logInLink;
	
	//Step 2 elements
	
	@FindBy(xpath="//input[@aria-label='First name']")
	public WebElement firstNameTxtb;
	
	@FindBy(xpath="//input[@aria-label='Last name']")
	public WebElement lastNameTxtb;
	
	@FindBy(xpath="//input[@aria-label='Company']")
	public WebElement companyTxtb;
	
	@FindBy(xpath="//input[@aria-label='Website']")
	public WebElement websiteTxtb;
	
	@FindBy(xpath="//input[@aria-label='Country']")
	public WebElement countryTxtb;
	
	@FindBy(xpath="//span[text()='India']")
	public WebElement countryOption;
	
	@FindBy(xpath="//input[@aria-label='Phone']")
	public WebElement phoneTxtb;
	
	@FindBy(xpath="//span[text()=' SIGN UP ']")
	public WebElement SignUpBtn;

}
