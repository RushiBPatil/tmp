package seleniumEg;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleEg {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		driver.findElement(By.xpath("//a[@id='getwebsitebtn']")).click();
		Set<String> handles=driver.getWindowHandles();
		System.out.println("handlers count"+handles.size());
		
		List<String> list=new ArrayList<String>(handles);
		for(String s:list) {
			String title=driver.switchTo().window(s).getTitle();
			System.out.println("title is "+title);
			if(title.equals("Create a Free Website | Free Website Builder | W3Schools.com")) {
				//driver.close(); // close single window
				driver.quit(); //close all opened windows
			}
		}		
	}
}
