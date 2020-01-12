package org.utest.com.pages;

import org.apache.poi.hssf.record.formula.functions.Npv;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.utest.com.base.Base;
import org.utest.com.wait.WebDriverWaits;

/**
 * Vidya M
 */
public class HandlingAlertsPage {

	private WebDriver driver = null;
	private Base base = null;
	private WebDriverWaits wait = null;
	private Alert alert = null;
	private JavascriptExecutor jse = null;
	private Actions action = null;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]")
	WebElement moveToDemoSite;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]//following::li[5]")
	WebElement handlingAlerts;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Confirm Pop up')]")
	WebElement acceptAlert;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Confirm Pop up')]")
	WebElement dismisAlert;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Simple Alert')]")
	WebElement acceptSimpleAlert;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Prompt Pop up')]")
	WebElement yesPopupAlert;

	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Prompt Pop up')]")
	WebElement noPopupAlert;

	public HandlingAlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		jse = (JavascriptExecutor) driver;
		base = new Base();
		wait = new WebDriverWaits();
		action = new Actions(driver);
	}

	public void handlingAlerts() {
		try {
			wait.waitUntilElementToBeClickable(moveToDemoSite, driver);
			moveToDemoSite.click();

			wait.waitUntilElementToBeClickable(handlingAlerts, driver);
			handlingAlerts.click();

			wait.waitUntilElementToBeVisible(acceptSimpleAlert, driver);
			wait.waitUntilElementToBeClickable(acceptSimpleAlert, driver);
			jse.executeScript("arguments[0].click();", acceptSimpleAlert);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.accept();

			wait.waitUntilElementToBeVisible(acceptAlert, driver);
			wait.waitUntilElementToBeClickable(acceptAlert, driver);
			jse.executeScript("arguments[0].click();", acceptAlert);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.accept();

			wait.waitUntilElementToBeVisible(dismisAlert, driver);
			wait.waitUntilElementToBeClickable(dismisAlert, driver);
			jse.executeScript("arguments[0].click();", dismisAlert);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.dismiss();

			wait.waitUntilElementToBeVisible(yesPopupAlert, driver);
			wait.waitUntilElementToBeClickable(yesPopupAlert, driver);
			jse.executeScript("arguments[0].click();", yesPopupAlert);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.sendKeys("Yes");
			alert.accept();

			wait.waitUntilElementToBeVisible(noPopupAlert, driver);
			wait.waitUntilElementToBeClickable(noPopupAlert, driver);
			jse.executeScript("arguments[0].click();", noPopupAlert);
			wait.waitUntilAlertAppear(driver);
			alert = driver.switchTo().alert();
			alert.sendKeys("No");
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
