package seleniumEg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		
		//to handle Permission pop up need to use ChromeOptions
		//this will use for diff operations as well for handling permission popup
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--headless");
		option.setAcceptInsecureCerts(true);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(option);
		
		//Handle windows default alert pop up
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(1000);
		al.sendKeys("Welcome");
		al.accept();
		
		//Handle authentictor pop up
		//url is - https://the-internet.herokuapp.com/basic_auth
		//send uname, pass in url synatx as follow
//		https://uname:password@the-internet.herokuapp.com/basic_auth
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
				
	}	

}
