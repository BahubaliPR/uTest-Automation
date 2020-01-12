package org.utest.com.tests;

import org.testng.annotations.Test;
import org.utest.com.base.Base;
import org.utest.com.pages.SwitchToWindowPage;

/**
Vidya M
*/
public class SwitchToWindowTest extends Base{
	
	private SwitchToWindowPage switchWin = null;
	
	@Test(priority=2)
	public void handleSwitchesBetweenWindows() {
		switchWin = new SwitchToWindowPage(driver);
     	switchWin.moveToDemoSite();
		switchWin.switchToNewBrowserWindow();
		switchWin.switchToNewMessageWinodw();
		switchWin.switchToNewBrowserTabWindow();
		switchWin.handleAlerts();
	}
}
