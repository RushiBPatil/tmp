package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleIframes {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/main/div/section[1]/ul/li[1]/a/span")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("classFrame");
		System.out.println(""+driver.findElement(By.xpath("/html/body/main/div[1]/h2")).getText());						

	}

}
