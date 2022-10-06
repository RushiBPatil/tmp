package seleniumEg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsEg {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();		
		driver.get("https://www.nopcommerce.com/en/register");
		
		//findElement return single first match element 
		WebElement fname=driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
		System.out.println(fname.getText());
		
		//findElements return all match elements 
		List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"register-page\"]/body/div[7]/footer/div[1]/div/div//a"));
		System.out.println("size of list is: "+list.size());	
		for(WebElement e:list) {
			System.out.println(" "+e.getText());
		}
	}
}
