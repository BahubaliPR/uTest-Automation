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

	@FindBy(how = How.XPATH, using = "button[id='alert']")
	WebElement clickOnAlertBox;

	@FindBy(how = How.XPATH, using = "button[id='timingAlert']")
	WebElement clickOnTimeAlertBox;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'HOME')]")
	WebElement clickOnHome;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'Blogs')]")
	WebElement clickBlogs;
	
	public SwitchToWindowPage(WebDriver driver) {
		try{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This block of code will be used to navigate to Demo Site and clicks on practice window option.
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
			
/*			wait.waitUntilPageLoad(driver);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");*/
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to click on the element");
		}
		
	}

	/*
	 * This block of code will be used switch to another window when the new browser window will be opened.
	 */
	public void switchToNewBrowserWindow() {
		try {
			wait.waitUntilElementToBeClickable(clickNewBrowserWindow, driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickNewBrowserWindow);
			
			/*wait.waitUntilPageLoad(driver);
			driver.manage().window().maximize();*/
			
			wait.waitUntilElementToBeClickable(clickOnHome, driver);
			window.switchToWindowHandles(driver);
			
			wait.waitUntilElementToBeClickable(clickOnHome, driver);
			clickOnHome.click();	
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Unable to click on the element");
		}
		
	}

	/*
	 * This block of code will be used to switch to another window when the new message window will be opened. 
	 */
	public void switchToNewMessageWinodw() {
		try {
			wait.waitUntilElementToBeVisible(clickNewMessageWinodw, driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickNewMessageWinodw);
			
			window.switchToWindowHandles(driver);
			wait.waitUntilElementToBeClickable(clickNewMessageWinodw, driver);
			
			driver.manage().window().maximize();
			
			String windowMessage = clickNewMessageWinodw.getText();
			System.out.println(windowMessage);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Unable to click on the element");
		}
	}

	/*
	 * This block of code will be used to switch to another window when the new tab window will be opened.
	 */
	public void switchToNewBrowserTabWindow() {
	   try {
		   wait.waitUntilElementToBeClickable(clickNewBrowserTabWindow, driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickNewBrowserTabWindow);

			window.switchToWindowHandles(driver);
			wait.waitUntilElementToBeClickable(clickBlogs, driver);
			
			driver.manage().window().maximize();
			clickBlogs.click();
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   throw new RuntimeException("Unable to click on the element");
	   }
		
	}

	/*
	 * This block of code will be used to handle alerts in the page.
	 */
	public void handleAlerts() {
		try {
			window.moveToParentWindow(driver);
			wait.waitUntilElementToBeClickable(clickOnAlertBox, driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickOnAlertBox);

			wait.waitUntilAlertAppear(driver);
			Alert alert = driver.switchTo().alert();
			alert.accept();

			wait.waitUntilElementToBeClickable(clickOnTimeAlertBox, driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",clickOnTimeAlertBox);
			driver.manage().window().maximize();
			wait.waitUntilAlertAppear(driver);
			alert.accept();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("Unable to click on the element");
		}
	}
}
