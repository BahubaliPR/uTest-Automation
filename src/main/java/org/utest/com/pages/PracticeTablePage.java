package org.utest.com.pages;

/*
 * Bahubali P R
 */
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.utest.com.wait.WebDriverWaits;
import org.utest.com.windows.WindowHandler;

public class PracticeTablePage {

	public WebDriver driver = null;
	private Actions action = null;
	private WebDriverWaits wait = null;
	private WindowHandler windowHandle = null;

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
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Clicks on DEMO SITES Clicks on Automation practice table Select column
	 * Select cell data from the table
	 */
	public void getDataFromTheTable() {
		try {
			action = new Actions(driver);
			wait = new WebDriverWaits();
			windowHandle = new WindowHandler();

			wait.waitUntilElementToBeClickable(moveToDemoSite, driver);
			action.moveToElement(moveToDemoSite).build().perform();

			wait.waitUntilElementToBeClickable(clickOnPracticeTable, driver);
			clickOnPracticeTable.click();

			wait.waitUntilElementToBeVisible(baseTable, driver);
			windowHandle.switchToChildWindow(driver);
			List<WebElement> totalRows = baseTable.findElements(By.xpath(".//tr//td"));
			int rowSize = totalRows.size();

			for (int row = 1; row < rowSize; row++) {

				String country = "UAE";
				String cellData = totalRows.get(row).getText();
				if (country.equals(cellData)) {
					System.out.println(cellData);
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}
