package org.utest.com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.utest.com.wait.WebDriverWaits;
import org.utest.com.windows.WindowHandler;

/**
 * Vidya M
 */
public class DemoSiteKeyBoardEventPage {

	private WebDriver driver = null;
	private WebDriverWaits wait = null;
	private Actions action = null;
	private WindowHandler windowHandle = null;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]")
	WebElement demoSite;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]//following::li[1]")
	WebElement basicDemoSite;

	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Widgets')]")
	WebElement widgetMenu;

	@FindBy(how = How.XPATH, using = ".//div[@id='content']//ul//li//a[@href='https://demoqa.com/keyboard-events/']")
	WebElement keyboardEvent;

	@FindBy(how = How.XPATH, using = "input[id='browseFile']")
	WebElement browseFile;

	public DemoSiteKeyBoardEventPage(WebDriver driver) {
		try {
			action = new Actions(driver);
			wait = new WebDriverWaits();
			windowHandle = new WindowHandler();
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

	public void basicDemoSiteMenu() {
		try {
			wait.waitUntilElementToBeClickable(demoSite, driver);
			action.moveToElement(demoSite).build().perform();

			wait.waitUntilElementToBeClickable(basicDemoSite, driver);
			basicDemoSite.click();

			windowHandle.switchToChildWindow(driver);
			String title = driver.getTitle();
			System.out.println(title);
			
			wait.waitUntilElementToBeClickable(widgetMenu, driver);
			widgetMenu.click();

			wait.waitUntilElementToBeClickable(keyboardEvent, driver);
			keyboardEvent.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
