package automationAnywherePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereComprehensive4 {

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

	public void menuLinks() throws InterruptedException {
		WebElement cookies = driver.findElement(By.xpath("//button[text()='Accept All Cookies']"));
		cookies.click();
		Thread.sleep(1500);
		List<WebElement> menuList = driver.findElements(
				By.xpath("//li[contains(@class,'nav-head')]//child::a[contains(@data-coh-settings,'menu-level-2')]"));
		int menuSize = menuList.size();
		for (int i = 1; i <= menuSize; i++) {
			WebElement menuElement = driver.findElement(By
					.xpath("(//li[contains(@class,'nav-head')]//child::a[contains(@data-coh-settings,'menu-level-2')])["
							+ i + "]"));
			String menuLinkName = menuElement.getText();
			System.out.println("Menu link name: " + menuLinkName);
			menuElement.click();
			String currentUrl = driver.getCurrentUrl();
			if (menuLinkName.equals("Intelligent Automation") && currentUrl.contains("rpa")) {
				menuLinkName = menuLinkName.replace("Intelligent Automation", "rpa");
			}
			menuLinkName = menuLinkName.toLowerCase();
			boolean status = currentUrl.contains(menuLinkName);
			Assert.assertTrue(status);
			System.out.println("\tMenu clicked successfully and navigated to its respective page!");
			driver.navigate().back();
		}
	}

	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationAnywhereComprehensive4 cls = new AutomationAnywhereComprehensive4();
		cls.setBrowser();
		cls.navigateToUrl();
		cls.menuLinks();
		cls.closeBrowser();
	}

}