package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternetHerokuappLaunchPage {

	private WebElement element = null;

	public WebElement abTestingLink(WebDriver driver, String linkName) {
		element = driver.findElement(By.xpath("//ul//li//a[contains(text(),'" + linkName + "')]"));
		return element;
	}

	public WebElement abTestPageTextElement(WebDriver driver) {
		element = driver.findElement(By.xpath("(//div[@id='content']//h3)[1]"));
		return element;
	}

	public WebElement dropDownValueElement(WebDriver driver) {
		element = driver.findElement(By.xpath("//div//*[@id='dropdown']"));
		return element;
	}

	public WebElement dropDownValueAttr(WebDriver driver, String selectedValue) {
		element = driver.findElement(By.xpath("//div//*[@id='dropdown']//*[contains(text(),'" + selectedValue + "')]"));
		return element;
	}

	public WebElement framesHyperlinkElement(WebDriver driver, String linkText) {
		element = driver.findElement(By.xpath("//div//li//a[contains(text(),'" + linkText + "')]"));
		return element;
	}

}