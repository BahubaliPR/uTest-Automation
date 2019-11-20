package org.utest.com.windows;

import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * Bahubali P R
 */
public class WindowHandler {

	/*
	 * Handling windows
	 */
	public void switchToHandleWindow(WebDriver driver) {

		String parentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
			if (!parentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				String windowTitle = driver.getTitle();
				System.out.println("Windows Title : " + windowTitle);
			}
			else 
			{
				System.out.println("Window handle will not be applicable here.");
			}
		}
	}
}
