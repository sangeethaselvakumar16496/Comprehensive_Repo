package stepDefinitionsPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.InternetHerokuappLaunchPage;
import utilityPack.BaseCls;
import utilityPack.BrowserSetup;
import utilityPack.GlobalVariables;

public class StepDefinitionClass {

	private BrowserSetup bs;
	private GlobalVariables gbVar;
	private BaseCls base;
	private InternetHerokuappLaunchPage page;
	private WebDriver driver = null;

	@Before
	public void setupBrowser() {
		gbVar = new GlobalVariables();
		bs = new BrowserSetup();
		base = new BaseCls();
		page = new InternetHerokuappLaunchPage();
		GlobalVariables.driver = bs.browserConfig(gbVar.chromeBrowserName);
		driver = GlobalVariables.driver;
		base.implicitWait(driver, 10);
	}

	@After
	public void closeBrowser(Scenario scenario) {
		base.close(driver);
	}

	@Given("user navigates to the application")
	public void user_navigates_to_the_application() {
		base.navigateToUrl(driver, gbVar.url);
	}

	@And("verifies the main page title: {string}")
	public void verifies_the_main_page_title(String mainPageTitle) {
		String pageTitle = base.verifyPageTitle(driver);
		Assert.assertEquals(mainPageTitle, pageTitle, "Page title doesn't match......");
		System.out.println("Main page title: " + pageTitle + " ---> Page verified successfully!");
	}

	@When("user clicks on {string} link")
	public void user_clicks_on_link(String linkName) {
		base.clickElement(page.abTestingLink(driver, linkName));
		base.hardWait(3000);
	}

	@And("verifies the text on the page: {string}")
	public void verifies_the_text_on_the_page(String textToValidate) {
		String pageFromText = base.getTextFromPage(page.abTestPageTextElement(driver));
		boolean validationStatus = textToValidate.contains(pageFromText);
		Assert.assertTrue(validationStatus);
		System.out.println("A/B test page text validated successfully!");
	}

	@Then("user navigates back to homepage")
	public void user_navigates_back_to_homepage() {
		base.navigateBack(driver);
	}

	@Then("selects the dropdown value as {string}")
	public void selects_the_dropdown_value_as(String valueToSelect) {
		base.selectValueFromDropDown(driver, page.dropDownValueElement(driver), valueToSelect);
		String attrValue = base.getAttributeValue(page.dropDownValueAttr(driver, valueToSelect), "selected");
		if (attrValue.equals("true")) {
			System.out.println("Drop down value selected successfully!");
		}
	}

	@And("verifies the below hyperlinks are presented on the frames page")
	public void verifies_the_below_hyperlinks_are_presented_on_the_frames_page(List<String> linkTextList) {
		int listSize = linkTextList.size();
		for (int i = 0; i < listSize; i++) {
			String fetchedText = base.getTextFromPage(page.framesHyperlinkElement(driver, linkTextList.get(i)));
			Assert.assertEquals(linkTextList.get(i), fetchedText);
			System.out.println(fetchedText + " link verified successfully!");
		}
	}

}