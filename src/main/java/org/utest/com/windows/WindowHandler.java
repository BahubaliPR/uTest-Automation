package org.utest.com.windows;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Bahubali P R
 */
public class WindowHandler {

	private String parentWindowHandle = null;
	Set<String> windowHandles = null;

	/*
	 * Switch to webdriver control to current window.
	 */
	public void switchToChildWindow(WebDriver driver) {
		parentWindowHandle = driver.getWindowHandle();
		windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!parentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	/*
	 * Switch the webdriver control to parent window.
	 */
	public void moveToParentWindow(WebDriver driver) {
		driver.close();
		windowHandles = driver.getWindowHandles();
		driver.switchTo().window(parentWindowHandle);
	}
}
