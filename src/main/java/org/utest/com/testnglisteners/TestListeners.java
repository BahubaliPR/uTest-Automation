package org.utest.com.testnglisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	public void onFinish(ITestContext context) {
		System.out.println("On Finish" + context.getEndDate());
	}

	public void onStart(ITestContext context) {
		System.out.println("On Start : " + context.getStartDate());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on Test Failed But Within Success Percentage : " + result.getStatus());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("On test failure : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("On test skipped : " + result.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("On test start : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("On test success : " + result.getName());
	}

}
