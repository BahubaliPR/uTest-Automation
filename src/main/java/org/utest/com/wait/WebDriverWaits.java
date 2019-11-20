package org.utest.com.wait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utest.com.configfilereader.PropertiesFileReader;

/**
 * Bahubali P R
 */
public class WebDriverWaits {

	private WebDriverWait wait = null;
	private FluentWait<WebDriver> fwait = null;

	private PropertiesFileReader reader = null;
	private long implicitWaitTime;
	private long explicitWaitTime;
	private long pollTime;

	public void dataInitialization() {
		reader = new PropertiesFileReader();
		implicitWaitTime = reader.getImplicitlyWait();
		explicitWaitTime = reader.getExplicitWait();
		pollTime = reader.getPollingTime();
	}

	/*
	 * waits until current page to be loaded
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(implicitWaitTime, TimeUnit.SECONDS);
	}

	/*
	 * Waits until the element to be clickable on the current page
	 */
	public void waitUntilElementToBeClickable(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*
	 * Waits until visibility of all the elements in the current page
	 */
	public void waitUntilElementsToBeVisible(List<WebElement> elements, WebDriver driver) {
		wait = new WebDriverWait(driver, explicitWaitTime);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitUntilElementToBeVisible(WebElement element, WebDriver driver){
		wait = new WebDriverWait(driver,explicitWaitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * Below block of code gives FluentWait functionality
	 */
	public void fluentWait(WebDriver driver) {
		fwait = new FluentWait<WebDriver>(driver).withTimeout(explicitWaitTime, TimeUnit.SECONDS)
				.pollingEvery(pollTime, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}
}
