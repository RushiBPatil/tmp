package seleniumEg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();		
		driver.get("https://www.nopcommerce.com/en/register");
		WebElement dropCompany=driver.findElement(By.id("CountryId"));
		Select company=new Select(dropCompany);
//		company.selectByVisibleText("India");
//		Thread.sleep(1000);
//		company.selectByValue("250");
//		Thread.sleep(1000);
//		company.selectByIndex(1);
//		
		List<WebElement> list=company.getOptions();
		for(WebElement e:list) {
			if(e.getText().equals("India")) {
				e.click();
				break;
			}
		}
	}
}
