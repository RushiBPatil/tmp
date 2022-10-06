package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleInnerIframes2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(0);
		System.out.println("inner iframe text "+ driver.findElement(By.xpath("/html/body/h1")).getText());
		driver.switchTo().parentFrame();
		System.out.println("outer iframe text "+ driver.findElement(By.xpath("/html/body/h2")).getText());

	}

}
