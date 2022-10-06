package com.baseClassObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class paypageOperations {
	protected static WebDriver driver;

	public void setWebDriver(WebDriver driver) {
		paypageOperations.driver = driver;		
	}
	
	public void getTitle() {
		System.out.println("title is -"+driver.getTitle() );
	}
	
	@Test
	public String submitPage() throws InterruptedException {				
		driver.findElement(By.id("radio0")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cvvPopup")).sendKeys("111");
		driver.findElement(By.id("apply-btnCvvPopup")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("order_Continue_Btn")).click();
		Thread.sleep(3000);	
		String currURL= driver.getCurrentUrl();
		System.out.println("current url is  - "+currURL);	
		String[] splStr= currURL.split("=");
		System.out.println("after split string is -"+splStr[1]);
		String sessionID=splStr[1];
		System.out.println("in spliting data");
		driver.close();
		return sessionID;							
	}
}
