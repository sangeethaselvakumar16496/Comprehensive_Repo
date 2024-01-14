package comprehensivePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprehensiveQuestion3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.automationanywhere.com/");
		Thread.sleep(2000);
		WebElement cookies = driver.findElement(By.xpath("//button[text()=\"Accept All Cookies\"]"));
		cookies.click();
		WebElement product = driver.findElement(By.xpath("//a[text()=\"Products\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(product).build().perform();
		WebElement process = driver.findElement(
				By.xpath("//a[@title=\"Process Discovery\" and@class=\"coh-link js-coh-menu-item-link \"]"));
		Thread.sleep(2000);
		process.click();
		// String page=driver.getTitle();
		String page = driver.getCurrentUrl();
		System.out.println(page);
		if (page.equalsIgnoreCase("https://www.automationanywhere.com/products/process-discovery")) {
			System.out.println("we navigated to process discovery page");
		} else {
			System.out.println("we are not  navigated to process discovery page");
		}
		driver.quit();

	}
}