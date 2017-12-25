package com.automation.frameworkBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {
	public static WebDriver driver;

	@BeforeMethod
	public void setup(){
		System.out.println("Launching Chrome Browser... ");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		System.out.println("Closing Browser... ");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
