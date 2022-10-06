package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragNDrop {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe")));
		WebElement img1=driver.findElement(By.xpath("//*[@id=\'gallery\']/li[1]"));
		WebElement img2=driver.findElement(By.xpath("//*[@id=\'gallery\']/li[2]"));
		WebElement destination=driver.findElement(By.xpath("//*[@id=\'trash\']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(img1, destination).perform();
		act.dragAndDrop(img2, destination).perform();
	}
}
