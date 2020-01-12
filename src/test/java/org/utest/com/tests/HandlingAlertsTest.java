package org.utest.com.tests;

import org.testng.annotations.Test;
import org.utest.com.base.Base;
import org.utest.com.pages.HandlingAlertsPage;

/**
Vidya M
*/
public class HandlingAlertsTest extends Base {
	private HandlingAlertsPage handleAlerts = null;
	
	@Test(priority=3)
	public void handleAlerts() {
		handleAlerts = new HandlingAlertsPage(driver);
		handleAlerts.handlingAlerts();
	}
}
