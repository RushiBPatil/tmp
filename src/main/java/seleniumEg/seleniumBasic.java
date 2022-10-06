package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumBasic {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en/register");
		WebElement search=driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
		System.out.println("Display status: "+search.isDisplayed());
		System.out.println("Enable status: "+search.isEnabled());
		
		WebElement dropbox=driver.findElement(By.xpath("//*[@id=\"CountryId\"]"));
		System.out.println("Drop box status"+dropbox.isSelected());		
		

	}

}
