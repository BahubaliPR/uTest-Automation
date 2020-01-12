package org.utest.com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utest.com.base.Base;
import org.utest.com.wait.WebDriverWaits;
import org.utest.com.windows.WindowHandler;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Vidya M
 */
public class SwitchToWindowPage {

	private WebDriver driver = null;
	private WindowHandler window = null;
	private WebDriverWaits wait = null;
	private Actions action = null;
	private JavascriptExecutor execute = null;
	private Alert alert = null;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]")
	WebElement moveToDemoSite;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]//following::li[3]")
	WebElement clickOnSwitchWindow;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'New Browser Window')]")
	WebElement clickNewBrowserWindow;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'New Message Window')]")
	WebElement clickNewMessageWinodw;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'New Browser Tab')]")
	WebElement clickNewBrowserTabWindow;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Alert Box')]")
	WebElement clickOnAlertBox;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Timing Alert')]")
	WebElement clickOnTimeAlertBox;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'HOME')]")
	WebElement clickOnHome;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'Blogs')]")
	WebElement clickBlogs;

	public SwitchToWindowPage(WebDriver driver) {
		try {
			execute = (JavascriptExecutor) driver;
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This block of code will be used to navigate to Demo Site and clicks on
	 * practice window option.
	 */
	public void moveToDemoSite() {

		try {
			window = new WindowHandler();
			action = new Actions(driver);
			wait = new WebDriverWaits();

			wait.waitUntilElementToBeClickable(moveToDemoSite, driver);
			action.moveToElement(moveToDemoSite).build().perform();

			wait.waitUntilElementToBeClickable(clickOnSwitchWindow, driver);
			clickOnSwitchWindow.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to click on the element");
		}
	}

	/*
	 * This block of code will be used switch to another window when the new
	 * browser window will be opened.
	 */
	public void switchToNewBrowserWindow() {
		try {
			wait.waitUntilElementToBeClickable(clickNewBrowserWindow, driver);
			execute.executeScript("arguments[0].click();", clickNewBrowserWindow);
			window.switchToChildWindow(driver);
			System.out.println(driver.getTitle());
			driver.manage().window().maximize();
			wait.waitUntilElementToBeClickable(clickOnHome, driver);
			clickOnHome.click();

			window.moveToParentWindow(driver);
			System.out.println(driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/*
	 * This block of code will be used to switch to another window when the new
	 * message window will be opened.
	 */
	public void switchToNewMessageWinodw() {
		try {
			wait.waitUntilElementToBeVisible(clickNewMessageWinodw, driver);
			execute.executeScript("arguments[0].click();", clickNewMessageWinodw);
			window.switchToChildWindow(driver);
			driver.manage().window().maximize();
			window.moveToParentWindow(driver);
			System.out.println(driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/*
	 * This block of code will be used to switch to another window when the new
	 * tab window will be opened.
	 */
	public void switchToNewBrowserTabWindow() {
		try {
			wait.waitUntilElementToBeClickable(clickNewBrowserTabWindow, driver);
			execute.executeScript("arguments[0].click();", clickNewBrowserTabWindow);
			window.switchToChildWindow(driver);
			driver.manage().window().maximize();
			wait.waitUntilElementToBeClickable(clickBlogs, driver);
			clickBlogs.click();

			window.moveToParentWindow(driver);
			System.out.println(driver.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

	/*
	 * This block of code will be used to handle alerts in the page.
	 */
	public void handleAlerts() {
		try {
			wait.waitUntilElementToBeClickable(clickOnAlertBox, driver);
			execute.executeScript("arguments[0].click();", clickOnAlertBox);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.accept();

			wait.waitUntilElementToBeClickable(clickOnTimeAlertBox, driver);
			execute.executeScript("arguments[0].click();", clickOnTimeAlertBox);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
