package seleniumEg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) throws MalformedURLException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.deadlinkcity.com");
		// linkText() & partialLinkTest() methods are used to get link type of element
		// text
		 WebElement tmp=driver.findElement(By.linkText("here"));
		 System.out.println("url"+tmp.getAttribute("href"));
		// driver.findElement(By.partialLinkText("ere")).click();
		int cnt = 0;
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (WebElement e : list) {
			String s = e.getAttribute("href");
			// System.out.println("received href are: "+s);
			URL url = new URL(s);
			if (s == null || s.isEmpty()) {
				System.out.println("URL is empty");
			} else {
				try {
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.connect();
					if (conn.getResponseCode() < 400) {
						System.out.println("Valid link is " + url);
					} else if (conn.getResponseCode() >= 400) {
						System.out.println("Broken link is " + url);
						cnt++;
					}
				} catch (Exception e1) {

				}
			}
		}
		System.out.println("Total Broken links are " + cnt);

	}

}
