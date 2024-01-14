package comprehensivePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprehensiveQuestion5 {

	private WebDriver driver;

	@BeforeSuite
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}

	@Test(priority = 1)
	public void navigateToUrl() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.automationanywhere.com/");
	}

	@Test(priority = 2)
	public void verifyProcessDiscoveryTabUrl() throws InterruptedException {
		WebElement cookies = driver.findElement(By.xpath("//button[text()=\"Accept All Cookies\"]"));
		cookies.click();
		Thread.sleep(1500);
		WebElement product = driver.findElement(By.xpath("//a[text()=\"Products\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(product).build().perform();
		WebElement process = driver.findElement(
				By.xpath("//a[@title=\"Process Discovery\" and@class=\"coh-link js-coh-menu-item-link \"]"));
		process.click();
		Thread.sleep(3000);
		String page = driver.getCurrentUrl();
		if (page.equalsIgnoreCase("https://www.automationanywhere.com/products/process-discovery")) {
			System.out.println("we navigated to process discovery page");
		} else {
			System.out.println("we are not navigated to process discovery page");
		}
	}

	@Test(priority = 3)
	public void verifyRequestLiveDemoTabUrl() throws InterruptedException {
		WebElement demo = driver.findElement(By.xpath("//a[text()=\"Request demo\"]"));
		demo.click();
		String page = driver.getCurrentUrl();
		System.out.println(page);
		if (page.equalsIgnoreCase("https://www.automationanywhere.com/request-live-demo")) {
			System.out.println("we navigated to demo page");
		} else {
			System.out.println("we are not navigated to demo page");
		}
		Thread.sleep(3000);
		WebElement firstname = driver.findElement(By.xpath("//label[@for='FirstName']"));
		String labeltext = firstname.getText();
		System.out.println(labeltext);
		WebElement lastname = driver.findElement(By.xpath("//label[@for='LastName']"));
		String labeltext_last = lastname.getText();
		System.out.println(labeltext_last);
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}