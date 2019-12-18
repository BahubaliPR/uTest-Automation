package org.utest.com.base;

/*
 * Bahubali P R
 */
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.utest.com.configfilereader.PropertiesFileReader;
import org.utest.com.extentreports.ExtentReport;
import org.utest.com.utility.ExcelReader;
import org.utest.com.webdriverlisteners.WebEventListener;

public class Base {

	private PropertiesFileReader reader = null;

	/*
	 * Creating a WebDriver reference
	 */
	public WebDriver driver = null;
	public WebDriverWait wait = null;
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
		reader = new PropertiesFileReader();
		System.setProperty("webdriver.chrome.driver", userdir + reader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	/*
	 * Set the URL to be navigated
	 */
	public void navigateToURL() {
		driver.get(reader.getApplicationUrl());
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

	// * This block of code will be used to read data from excel sheet

	public String[][] getAllDataFromExcel(String excelFileName, String sheetName, String colName, int rowNumber) {
		String excelFilePath = userdir + "/TestData/" + excelFileName;
		readExcel = new ExcelReader(excelFilePath);
		String[][] data = readExcel.getDataFromSheet(sheetName, excelFileName);
		return data;
	}

	// This block of code will help to get cell data from the excel sheet

	public String getCellDataFromExcel(String excelFileName, String sheetName, String colName, int rowNumber) {
		String excelFilePath = userdir + "/TestData/" + excelFileName;
		readExcel = new ExcelReader(excelFilePath);
		String data = readExcel.getCellDataFromSheet(sheetName, colName, rowNumber);
		return data;
	}
}
