package seleniumEg;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTablePagination {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=39.0_1");
		driver.manage().window().maximize();
		String s = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_info\"]")).getText();
		System.out.println("text is " + s);
		int total_page_entries = Integer.valueOf(s.substring(s.indexOf("f ") + 2, s.indexOf("entries") - 1));
		System.out.println("total entries are " + total_page_entries);		
		int clicks=0;
		for (int i = 1; i <= 6; i++) {
			int rows = driver.findElements(By.xpath("//table[@class='datatable table table-striped table-bordered dataTable']//tbody/tr")).size();
			System.out.println("total rows " + rows);
			for (int r = 1; r <= rows; r++) {
				String browser = driver.findElement(
						By.xpath("//table[@class='datatable table table-striped table-bordered dataTable']//tbody/tr["
								+ r + "]/td[2]"))
						.getText();
				String platform = driver.findElement(
						By.xpath("//table[@class='datatable table table-striped table-bordered dataTable']//tbody/tr["
								+ r + "]/td[3]"))
						.getText();
				System.out.println(browser + " " + platform);
			}

			boolean ref = true;
			
			String tmp = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_next\"]")).getAttribute("href");
			System.out.println(" temp " + tmp);
			if (tmp.equals("#")) {
				ref = false;
			} else if (ref == true) {
				driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();
				clicks++;
				System.out.println("no of clicks"+ clicks);
			}
		}
	}
}