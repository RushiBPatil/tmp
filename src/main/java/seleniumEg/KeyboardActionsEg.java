package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionsEg {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//Shows key entered using Keys class
//		driver.get("https://the-internet.herokuapp.com/key_presses");		
//		Actions act= new Actions(driver);
//		act.sendKeys(Keys.ENTER).perform();
//		Thread.sleep(1000);
//		act.sendKeys(Keys.SPACE).perform();		
		
		//copying text from 1 box to other and compare text
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		WebElement box1=driver.findElement(By.id("inputText1"));
		WebElement box2=driver.findElement(By.id("inputText2"));
		box1.sendKeys("hi this is rushi");
		Actions act= new Actions(driver);
		//control a to select all
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(2000);
		//control c to copy all
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		//change to box2 by tab and paste by cnt + v
		act.sendKeys(Keys.TAB);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		if(box1.getAttribute("value").equals(box2.getAttribute("value"))) {
			System.out.println("String is same");
		}
		else {
			System.out.println("String not same");
		}				
	}
}
