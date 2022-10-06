package seleniumEg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperation1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();		
		//Right click operation
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");		
		WebElement btn=driver.findElement(By.xpath("//span[@Class='context-menu-one btn btn-neutral']"));
		Actions act= new Actions(driver);
		act.contextClick(btn).perform();
		//driver.findElement(By.xpath("/html/body/ul/li[7]")).click();
		
		//double click operations
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.switchTo().frame("iframeResult");
		WebElement field1=driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys("Welcome rushi");	
		WebElement btn2= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));	
		act.doubleClick(btn2).perform();
	}

}
