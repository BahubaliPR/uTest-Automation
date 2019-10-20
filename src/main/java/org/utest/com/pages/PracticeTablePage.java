package org.utest.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.utest.com.base.Base;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class PracticeTablePage {

	public WebDriver driver = null;
	private Actions action = null;
	public Base base = null;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]")
	private WebElement moveToDemoSite;

	@FindBy(how = How.XPATH, using = ".//ul[@id='primary-menu']//preceding::nav[@class='navigation']//span[contains(text(),'DEMO SITES')]//following::li[4]")
	private WebElement clickOnPracticeTable;

	@FindBy(how = How.XPATH, using = ".//table[@summary='Sample Table']")
	private WebElement baseTable;

	/*
	 * Initialize all the web elements to driver
	 */
	public PracticeTablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Clicks on DEMO SITES Clicks on Automation practice table Select column
	 * Select cell data from the table
	 */
	public void getDataFromTheTable() {
		action = new Actions(driver);
		base = new Base();
		
		base.waitUntilElementToBeClickable(moveToDemoSite, driver);
		action.moveToElement(moveToDemoSite).perform();
		
		base.waitUntilElementToBeClickable(clickOnPracticeTable, driver);
		clickOnPracticeTable.click();

		base.waitUntilPageLoad(driver);
		List<WebElement> totalRows = baseTable.findElements(By.xpath(".//tr//td"));
      	int rowSize = totalRows.size();

		for (int row = 1; row < rowSize; row++) {
			
			String country = "UAE";
			String cellData = totalRows.get(row).getText();
			if(country.equals(cellData)){
				System.out.println(cellData);
				break;
			}
		}
	}

}
