package seleniumEg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=binge&rlz=1C1JJTC_enIN972IN972&oq=bing&aqs=chrome.2.69i57j0i131i433i512l2j0i433i512j0i131i433j0i131i433i512j46i433i512j0i512j0i131i433i512.3274j0j7&sourceid=chrome&ie=UTF-8");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.name("q")).click();
		List<WebElement> list=driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//span"));
		System.out.println("size of list"+list.size());
		for(WebElement e:list) {
			if(e.getText().equals("binge tv")) {
				e.click();
				break;
			}
		}
	}
}
