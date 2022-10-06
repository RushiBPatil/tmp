package com.baseClassObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	//WebDriver driver =null;
	protected static paypageOperations po;
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
//	String ProjectPath= System.getProperty("user.dir");
	
	@Parameters("browser")	
	@BeforeClass
	public void setup(String browser) throws Exception {
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.out.println("in side broswer function");			
//			driver=WebDriverManager.chromedriver().create();
//			System.out.println("redirecting to browser");
//		}
//		else if(browser.equalsIgnoreCase("Firefox")) {
//			driver=WebDriverManager.firefoxdriver().create();
//			System.out.println("Firefox selected");
//		}
		if(browser.equalsIgnoreCase("LambdaChrome")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "70.0");
	        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
	        capabilities.setCapability("build", "Cross Browser");
	        capabilities.setCapability("name", "Chrome_70.00_Win10");	        
			driver=new RemoteWebDriver(new URL("https://" +"rushikeshp"+ ":" + "SLiMM9M3NS3HEc27g1oui68T6brl0yH37DJGTxcteYPGTeLND4" + gridURL), capabilities);
		}
		else {
			throw new Exception("Incorrect broser");
		}
	}
	@Test
	public void loadPage() throws FileNotFoundException, IOException, ParseException, InterruptedException{
			
//		paymentPageRequest ptr=new paymentPageRequest();
//		String url=ptr.payPageURL();
//		driver.get(url);
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		po=new paypageOperations();
//		po.setWebDriver(driver);
//		System.out.println("done with setting driver");
		driver.get("https://uatps48.aurusepay.com/storeservices/ecom/getiframe?a=03698C90a4c519cdc4d3ac819da3671ba35b6c45c8e39e37a535179c9d476006c5874652de06bbcc1b546ce0a48ef384623dde654eba9fa085db102701c8b3f27c72a88d5103968d18b076ffc8354587c0e4d061c757717bc310b9a417eedbfa26aec2ee0c6e8c6eda4d9e253f20644b5ef702306a9f6a42d12f227bba18458531ad1bcc89baf937b78cad120644c0a3d584b306e786b4821841b0a93dcc69c42290f9662d86ab452e2e09e0c7d66c51ab5333ca915df03d8a991e90cb0be695fc40859d99db4a7d03d656a0d1307847fdfda4aa2ccde314b0caca7a29f7ab0695dd5e8321e58309b85840708ec2e1d90f7515c8b8e795566ee27f0509714d9c20a0f6c7e380714c13765c4ab0cf6cc89ef7138be5763b1279b2f20407ccd11c369095428675e3fd8364c82798f99446036e21c4b48b62f04eabdbd2ae7e9668348edf4ef0102af87ab8d15e67060cfbd8bc0147fb68a535fee9c70f65bf2001e30735d0e0dc700cea4ca00c8a552714c949b4ad558033c6b22dfff9e4b64f4894a133a5");
		System.out.println("Title is "+driver.getTitle());
		
	}
	@AfterClass
	public void tearDown() {		
		driver.close();
	}
}
