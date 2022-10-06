package seleniumEg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxEg {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("size is "+list.size());
		//select specific checkbox
		//driver.findElement(By.id("monday")).click();		
		//select all checkbox
		/*for(WebElement e:list) {
			e.click();
		}*/
		//select only given checkbox name
		/*for(WebElement e:list) {
			String s=e.getAttribute("id");
			if(s.equals("monday") || s.equals("tuesday")) {
				e.click();
			}
		}*/
		//select only last 2 checkbox
//		int total=list.size();
//		for(int i=total-2;i<total;i++) {
//			list.get(i).click();
//		}
		//select only first 3 checkbox
		for(int i=0;i<list.size();i++) {
			if(i<3) {
				list.get(i).click();
			}
		}	
	}
}
