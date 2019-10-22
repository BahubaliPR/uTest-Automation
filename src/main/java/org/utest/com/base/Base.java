package org.utest.com.base;

/*
 * Bahubali P R
 */
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.utest.com.extentreports.ExtentReport;
import org.utest.com.utility.ExcelReader;

public class Base {

	/*
	 * Creating a WebDriver reference
	 */
	public WebDriver driver = null;
	private WebDriverWait wait = null;
	private ExcelReader readExcel = null;
	private ExtentReport reports = null;

	/*
	 * setting up the user directory
	 */
	public String userdir = System.getProperty("user.dir");

	/*
	 * Launch the browser and maximize the window
	 */
	public void launchBrowser() {
		// driverPath = getCellDataFromExcel("testDataSheet.xlsx", "TestData",
		// "TableColumn", 1);
		System.setProperty("webdriver.chrome.driver", userdir + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	/*
	 * Set the URL to be navigated
	 */
	public void navigateToURL() {
		driver.get("http://www.toolsqa.com/");
	}

	/*
	 * Launch browser and navigate to URL
	 */
	@BeforeMethod
	public void init() {
		launchBrowser();
		navigateToURL();
	}

	/*
	 * Close and Quit the browser close() - Closes only current window or tab
	 * Quit() - Closes all the windows and quits the running web driver
	 */
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	/*
	 * Waits until the element to be clickable on the current page
	 */
	public void waitUntilElementToBeClickable(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*
	 * Waits until visibility of all the elements in the current page
	 */
	public void waitUntilElementsToBeVisible(List<WebElement> elements, WebDriver driver) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/*
	 * waits until current page to be loaded
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

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
		}
	}

	/*
	 * This block of code will be used to read data from excel sheet
	 */
	public String[][] getAllDataFromExcel(String excelFileName, String sheetName, String colName, int rowNumber) {
		String excelFilePath = userdir + "/TestData/" + excelFileName;
		readExcel = new ExcelReader(excelFilePath);

		String[][] data = readExcel.getDataFromSheet(sheetName, excelFileName);
		return data;
	}

	/*
	 * This block of code will help to get cell data from the excel sheet
	 */
	public String getCellDataFromExcel(String excelFileName, String sheetName, String colName, int rowNumber) {
		String excelFilePath = userdir + "/TestData/" + excelFileName;
		readExcel = new ExcelReader(excelFilePath);

		String data = readExcel.getCellDataFromSheet(sheetName, colName, rowNumber);
		return data;
	}

	/*
	 * This block of code will be used to geerate extent reports
	 */
	public void genarateExtentReports(String testName) {
		reports = new ExtentReport();
		reports.extentReports(testName);
	}
}
