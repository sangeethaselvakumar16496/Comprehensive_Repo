package utilityPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseCls {

	public void navigateToUrl(WebDriver driver, String input) {
		driver.get(input);
	}

	public String verifyPageTitle(WebDriver driver) {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		hardWait(1500);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void selectValueFromDropDown(WebDriver driver, WebElement element, String valueToSelect) {
		Select select = new Select(element);
		select.selectByVisibleText(valueToSelect);
	}

	public String getTextFromPage(WebElement element) {
		String textFromPage = element.getText();
		return textFromPage;
	}

	public String getAttributeValue(WebElement element, String attributeName) {
		String attributeValue = element.getAttribute(attributeName);
		return attributeValue;
	}

	public void hardWait(long timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(WebDriver driver, long timeInMilliSec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInMilliSec));
	}

	public void close(WebDriver driver) {
		driver.quit();
	}

}