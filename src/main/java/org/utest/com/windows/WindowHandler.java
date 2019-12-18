package org.utest.com.windows;

import java.util.Set;
import org.openqa.selenium.WebDriver;

/**
 * Bahubali P R
 */
public class WindowHandler {

	private String parentWindowHandle = null;
	Set<String> windowHandles = null;

	/*
	 * Handling windows
	 */
	public void switchToWindowHandles(WebDriver driver) {
		parentWindowHandle = driver.getWindowHandle();
		windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!parentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
			} else {
				System.out.println("Window handle will not be applicable here.");
				// driver.close();
			}
		}
	}

	public void moveToParentWindow(WebDriver driver) {
		parentWindowHandle = driver.getWindowHandle();
		windowHandles = driver.getWindowHandles();
		for (String handle1 : windowHandles) {
			if (handle1.equals(parentWindowHandle)) {
				driver.switchTo().window(parentWindowHandle);
			} else {
				driver.close();
			}
		}
	}
}
