package seleniumEg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableEg {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		//get no of rows from table
		int row=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println("No of rows are "+row);
		//get no cols from table
		int cols=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		System.out.println("No of cols "+cols);
		//get specific row data from table
		String s=driver.findElement(By.xpath("//table[@id='customers']//tr[2]/td[1]")).getText();
		System.out.println("Value is "+s);		
		//get all data from table
		for(int i=2;i<=row;i++) {
			for(int j=2;j<=cols;j++){
				String data=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data+" ");								
			}
			System.out.println();
		}
		
		//get multiple specific row data from table
		System.out.println("====================================");
		for(int i=2;i<=row;i++) {
			for(int j=1;j<=cols;j++) {
				String match=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td[1]")).getText();
				if(match.equals("Adobe")) {
					String contact=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td[2]")).getText();
					String country=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td[3]")).getText();
					System.out.println("Contact is "+contact+ " Country is "+country);
					break;
				}
			}
		}
		
		//driver.close();
	}

}
