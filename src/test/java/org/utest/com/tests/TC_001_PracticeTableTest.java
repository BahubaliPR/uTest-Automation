package org.utest.com.tests;

import org.testng.annotations.Test;
import org.utest.com.base.Base;
import org.utest.com.pages.PracticeTablePage;

public class TC_001_PracticeTableTest extends Base {

	public PracticeTablePage practiceTable = null;

	@Test
	public void performPracticeTable() {
		practiceTable = new PracticeTablePage(driver);
		practiceTable.getDataFromTheTable();
	}
}
