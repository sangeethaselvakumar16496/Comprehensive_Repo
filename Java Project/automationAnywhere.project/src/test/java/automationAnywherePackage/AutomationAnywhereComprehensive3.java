package automationAnywherePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereComprehensive3 {

	private WebDriver driver = null;

	public void setBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void navigateToUrl() {
		driver.get("https://www.automationanywhere.com/");
	}

	public void verifyRequestLiveDemoTabUrl() throws InterruptedException {
		WebElement cookies = driver.findElement(By.xpath("//button[text()='Accept All Cookies']"));
		cookies.click();
		Thread.sleep(1500);
		WebElement demo = driver.findElement(By.xpath("//a[text()='Request demo']"));
		boolean requestDemoButtonStatus = demo.isDisplayed();
		Assert.assertTrue(requestDemoButtonStatus);
		System.out.println("Is request demo button displayed:" + requestDemoButtonStatus);
		demo.click();
		String textToVerify = "request-live-demo";
		String requestDemoPage = driver.getCurrentUrl();
		Assert.assertTrue(requestDemoPage.contains(textToVerify));
		System.out.println("Button click is success!");
	}

	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationAnywhereComprehensive3 cls = new AutomationAnywhereComprehensive3();
		cls.setBrowser();
		cls.navigateToUrl();
		cls.verifyRequestLiveDemoTabUrl();
		cls.closeBrowser();
	}

}