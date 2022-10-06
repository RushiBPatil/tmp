package seleniumEg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotEg {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com");
		driver.manage().window().maximize();		
		//Take screenshot of whole page
		
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File trg= new File(".\\Utility\\main.png");
//		FileUtils.copyFile(src, trg);
		
		//Specific section screenshot
//		WebElement section=driver.findElement(By.xpath("//*[@id=\"post-117\"]/div[2]/div[2]/div/div/section[4]/div/div/div/div/div/div/div/div/img"));
//		File src=section.getScreenshotAs(OutputType.FILE);
//		File trg= new File(".\\Utility\\section.png");
//		FileUtils.copyFile(src, trg);				
		
		//specific element screenshot
		WebElement ele=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/a"));
		File src=ele.getScreenshotAs(OutputType.FILE);
		File trg= new File(".\\Utility\\Element.png");
		FileUtils.copyFile(src, trg);		
		driver.close();
		

	}

}
