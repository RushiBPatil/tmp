package seleniumEg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/register");
		WebElement country = driver.findElement(By.id("CountryId"));
		handleDrop(country, "India");
		WebElement timeZone = driver.findElement(By.id("TimeZoneId"));
		handleDrop(timeZone, "(UTC+05:30) Chennai, Kolkata, Mumbai, New Delhi");
		WebElement company = driver.findElement(By.id("Details_CompanyIndustryId"));
		handleDrop(company, "I am student");
	}

	public static void handleDrop(WebElement e, String str) {
		Select s = new Select(e);
		List<WebElement> list = s.getOptions();
		for (WebElement we : list) {
			if (we.getText().equals(str)) {
				we.click();
				break;
			}
		}
	}
}
