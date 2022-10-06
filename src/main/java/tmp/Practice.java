package tmp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		// driver.findElement(By.xpath("//input[@type='radio' and
		// @id='female']")).click();
//		WebElement drp = driver.findElement(By.xpath("//select[@class='custom-select']"));
//		Select sc = new Select(drp);
		//sc.selectByVisibleText("Spain");
		//sc.selectByIndex(5);
//		List<WebElement> li = sc.getOptions();
//		for (WebElement we : li) {
//			if (we.getText().equals("Spain")) {
//				we.click();
//			}
//		}
		//driver.findElement(By.xpath("//label[text()='1 year']")).click();
		List<WebElement> check=driver.findElements(By.xpath("//input[@type='checkbox' and @class='custom-control-input']"));
		for(WebElement we:check)
		{	
			String tmp=we.getAttribute("id");
			System.out.println("temp is" +tmp);
			if(tmp.equalsIgnoreCase("cucumber"))
			{
				we.click(); 
				break;
			}
		}
	}
}
