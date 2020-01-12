package org.utest.com.tests;

import org.testng.annotations.Test;
import org.utest.com.base.Base;
import org.utest.com.pages.DemoSiteKeyBoardEventPage;

/**
Vidya M
*/
public class FileUploadTest extends Base{

	private DemoSiteKeyBoardEventPage uploadFile = null;
		
	@Test(priority=4)
	public void browseAndUploadFile() {
		uploadFile = new DemoSiteKeyBoardEventPage(driver);
		uploadFile.basicDemoSiteMenu();
	}
}
