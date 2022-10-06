package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/");
		driver.manage().window().maximize();
		WebElement live=driver.findElement(By.id("menu-item-1728"));
		WebElement opt=driver.findElement(By.id("menu-item-2122"));
		Actions act= new Actions(driver);
		act.moveToElement(live).moveToElement(opt).click().perform();
	}
}
