package org.utest.com.webdriverlisteners;

/*
 * Bahubali P R
 */
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert has been accepted : " + driver.switchTo().alert().getText());
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert has been dismissed : " + driver.switchTo().alert().getText());
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charseq) {
		System.out.println("After changing value");
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on the button : " + element.getTagName());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found the elemet : " + element.getTagName() + ", By " + by.toString());
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
	System.out.println("Screen shot : " + arg0.toString() +" , "+ arg1.toString());
	}

	public void afterGetText(WebElement element, WebDriver driver, String str) {
		System.out.println("Got text : " + element.getText() + " , "+ " String is : " + str);
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to URL : " + driver.getCurrentUrl() + " , Title is " + driver.getTitle());
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward : " + driver.getCurrentUrl() + " , " + driver.getTitle());
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Browser refreshed : " + driver.getCurrentUrl() + " , " + driver.getTitle());
	}

	public void afterNavigateTo(String str, WebDriver driver) {
		System.out.println("Navigated to the URL : " + driver.getCurrentUrl());
	}

	public void afterScript(String str, WebDriver driver) {
		System.out.println("Java Script has been ran : " + str + " , " + driver.toString());
	}

	public void afterSwitchToWindow(String str, WebDriver driver) {
		System.out.println("Switched to window : " + str + " , " + driver.getWindowHandle());
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("This alert is about to popped up : " + driver.switchTo().alert().getText());
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("This alert is about to dismissed : " + driver.switchTo().alert().getText());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charseq) {
		System.out.println("Before change value : " + element.getTagName() + " , " + driver.toString() + " , Characters are : " + charseq);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("The button" + element.getTagName() + "is about to click");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("The element " + element.getTagName() + " is about to findout" + " By " + by.toString() );
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("About to take screen shot : " + arg0.toString());
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("About to get the text : " + element.getTagName());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("About to navigate back to : " + driver.getCurrentUrl());
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("About to navigate forward : " + driver.getCurrentUrl());
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("About to refresh the browser : " + driver.getCurrentUrl());
	}

	public void beforeNavigateTo(String str, WebDriver driver) {
		System.out.println("About to navigate to : " + driver.getTitle());
	}

	public void beforeScript(String str, WebDriver driver) {
		System.out.println("Script is about to ru : " + str);
	}

	public void beforeSwitchToWindow(String str, WebDriver driver) {
		System.out.println("About to switch to window : " + driver.getWindowHandle());
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured on : " + throwable.getMessage());
	}
}
