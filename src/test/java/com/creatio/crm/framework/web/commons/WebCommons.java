package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {

	// This class will have all the common methods related to selenium web action

	public WebDriver driver = new BasePage().getDriver();
	public Properties prop = PropUtil.readData("Config.properties");

	// method to launch the application
	public void launchTheApplication() {
		driver.get(prop.getProperty("url"));
	}

	// method to scroll to element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	// method to click on element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	// method to double click on element
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	// method to click on hidden element
	public void jsClick(WebElement element) {
		scrollToElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// method to enter text in textbox
	public void enterText(WebElement textbox, String textValue) {
		scrollToElement(textbox);
		textbox.clear();
		textbox.sendKeys(textValue);
	}
	
	// method to enter text in textbox using actions class
	public void enterInfo(WebElement textbox, String textValue) {
		scrollToElement(textbox);
		new Actions(driver).sendKeys(textbox, textValue).perform();
	}

	// method to select checkbox
	public void checkbox(WebElement checkbox, boolean status) {
		scrollToElement(checkbox);
		if (checkbox.isSelected() != status) {
			checkbox.click();
		}
	}

	// method to select option from dropdown
	public void selectOption(WebElement dropdown, String selectBy, String option) {
		scrollToElement(dropdown);
		Select s = new Select(dropdown);
		if (selectBy.equalsIgnoreCase("visibleText")) {
			s.selectByVisibleText(option);
		} else if (selectBy.equalsIgnoreCase("value")) {
			s.selectByValue(option);
		}
		if (selectBy.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(option));
		}
	}

	// method to wait
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// method to wait using implicit wait
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// method to wait using explicit wait - wait for element
	public void waitForElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// method to wait using explicit wait - wait for element
	public void waitForElement(By loactor, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(loactor, 0));
	}
	
	// method to wait using explicit wait - wait for element to be disappeared
	public void waitForElementDisappeared(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// method to take screenshot of window
	public static String takeWindowScreenshot(WebDriver driver, String screenshotNameAndFromat) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotNameAndFromat;
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}

	// method to take screenshot of element
	public static String takeElementScreenshot(WebElement element, String screenshotNameAndFromat) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotNameAndFromat;
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}

	// get element text
	public String getElementText(WebElement element) {
		return element.getText();
	}

	// get element attribute value
	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	// get title of the window
	public String getTitle() {
		return driver.getTitle();
	}

	// check element is displayed
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// check element is enabled
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	// generate unique id
	public String uniqueId(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String uniqueId = sdf.format(Calendar.getInstance().getTime());
		return uniqueId;
	}
	
	// print message in report
	public void log(String status , String message) {
		if(status.equalsIgnoreCase("pass")) {
			Reports.logger.pass(message);
		}else if(status.equalsIgnoreCase("fail")) {
			Reports.logger.fail(message);
		}else if(status.equalsIgnoreCase("warning")) {
			Reports.logger.warning(message);
		}else if(status.equalsIgnoreCase("info")) {
			Reports.logger.info(message);
		}
	}

}
