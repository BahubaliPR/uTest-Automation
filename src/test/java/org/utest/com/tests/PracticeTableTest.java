package org.utest.com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.utest.com.base.Base;
import org.utest.com.extentreports.ExtentReport;
import org.utest.com.pages.PracticeTablePage;

import com.aventstack.extentreports.ExtentTest;

public class PracticeTableTest extends Base {

	public PracticeTablePage practiceTable = null;
	private ExtentReport report = null;

	@Test(priority=1)
	public void performPracticeTable() {
		report = new ExtentReport();
		practiceTable = new PracticeTablePage(driver);
		practiceTable.getDataFromTheTable();
	}
}
