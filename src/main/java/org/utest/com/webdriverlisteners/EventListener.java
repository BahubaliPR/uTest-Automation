package org.utest.com.webdriverlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener implements WebDriverEventListener {

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert has been accepted");
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert has been dismissed");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charseq) {
		System.out.println("After changing value");
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on : " + element);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found the elemet : " + element);
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver, String str) {
		System.out.println("Got text : " + str);
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Browser refreshed");
	}

	public void afterNavigateTo(String str, WebDriver driver) {
		System.out.println("Navigated to : " + str);
	}

	public void afterScript(String str, WebDriver driver) {
		System.out.println("Script has been ran");
	}

	public void afterSwitchToWindow(String str, WebDriver driver) {
		System.out.println("Switched to window : " + str);
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Alert has been popped up");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before alert dismissed");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] charseq) {
		System.out.println("Before change value");
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on : " + element);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before finding element : " + element);
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("Before getting screenshot");
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Before getting text");
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before navigating back");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before navigating forward");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before refreshing browser");
	}

	public void beforeNavigateTo(String str, WebDriver driver) {
		System.out.println("Before navigating to : " + str);
	}

	public void beforeScript(String str, WebDriver driver) {
		System.out.println("Before script");
	}

	public void beforeSwitchToWindow(String str, WebDriver driver) {
		System.out.println("Before switching to window");
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured");
	}
}
