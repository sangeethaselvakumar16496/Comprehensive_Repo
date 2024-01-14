package comprehensivePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComprehensiveQuestion4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.automationanywhere.com/");
		Thread.sleep(2000);
		WebElement cookies = driver.findElement(By.xpath("//button[text()=\"Accept All Cookies\"]"));
		cookies.click();
		WebElement demo = driver.findElement(By.xpath("//a[text()=\"Request demo\"]"));
		demo.click();
		String page = driver.getCurrentUrl();
		System.out.println(page);
		if (page.equalsIgnoreCase("https://www.automationanywhere.com/request-live-demo")) {
			System.out.println("we navigated to demo page");
		} else {
			System.out.println("we are not  navigated to demo page");
		}
		Thread.sleep(2000);
		WebElement firstname = driver.findElement(By.xpath("//label[@for='FirstName']"));
		String labeltext = firstname.getText();
		System.out.println(labeltext);

		WebElement lastname = driver.findElement(By.xpath("//label[@for='LastName']"));
		String labeltext_last = lastname.getText();
		System.out.println(labeltext_last);

		driver.quit();
	}
}