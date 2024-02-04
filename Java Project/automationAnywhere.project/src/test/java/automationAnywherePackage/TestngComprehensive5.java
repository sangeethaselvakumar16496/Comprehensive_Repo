package automationAnywherePackage;

import org.testng.annotations.Test;

public class TestngComprehensive5 {

	private AutomationAnywhereComprehensive3 comp3;
	private AutomationAnywhereComprehensive4 comp4;

	@Test(priority = 1)
	public void comprehensive3() throws InterruptedException {
		comp3 = new AutomationAnywhereComprehensive3();
		comp3.setBrowser();
		comp3.navigateToUrl();
		comp3.verifyRequestLiveDemoTabUrl();
		comp3.closeBrowser();
	}

	@Test(priority = 2)
	public void comprehensive4() throws InterruptedException {
		comp4 = new AutomationAnywhereComprehensive4();
		comp4.setBrowser();
		comp4.navigateToUrl();
		comp4.menuLinks();
		comp4.closeBrowser();
	}

}