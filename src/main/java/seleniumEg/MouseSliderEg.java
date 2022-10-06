package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseSliderEg {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement min=driver.findElement(By.xpath("//span[1]"));
		WebElement max=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of min "+min.getLocation()+"Location of max "+max.getLocation());
		System.out.println("size height & Width of the element "+min.getSize());
		
		Actions act= new Actions(driver);
		act.dragAndDropBy(min, 100, 0).perform();
		act.dragAndDropBy(max, -100, 0).perform();
		System.out.println("Location of min "+min.getLocation()+"Location of max"+max.getLocation());
	}
}
