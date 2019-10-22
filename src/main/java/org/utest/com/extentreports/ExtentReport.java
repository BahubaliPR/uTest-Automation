package org.utest.com.extentreports;

/*
 * Bahubali P R
 */
import org.utest.com.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport extends Base {

	private ExtentHtmlReporter report = null;
	private ExtentReports extent = null;
	public ExtentTest logger = null;

	public void extentReports(String testName) {
		report = new ExtentHtmlReporter(userdir + "/ExtentReports/testReports.html");
		extent = new ExtentReports();
		extent.attachReporter(report);
		logger = extent.createTest(testName);
		logger.log(Status.PASS, "Table Value has been verified");
	}
}
