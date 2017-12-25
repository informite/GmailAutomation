/**
 * 
 */
package com.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frameworkBase.BasePage;

/**
 * @author Risham
 *This class logs in to gmail account
 */
public class LoginPage extends BasePage {

	private String loginpageURL = "https://www.gmail.com/";

	public LoginPage goto_theGmailWebsite() {
		driver.get(loginpageURL);
		
		// Verify page title
		String actualWebsiteTitle = driver.getTitle();
		System.out.println("Actual Title: " + actualWebsiteTitle);
		String expectedWebsiteTitle = "Gmail";
		assertEquals(actualWebsiteTitle, expectedWebsiteTitle);
		return new LoginPage();
	}
	
	public LoginPage enterCredentials() throws Exception{
		 //Enter UserName
        WebElement email=driver.findElement(By.id("identifierId"));
        System.out.println("Entering email ");
        email.sendKeys("rishamtestemail");
        Thread.sleep(1000);
        
        //Click "Next"
        WebElement nextElement=driver.findElement(By.className("CwaK9"));
        nextElement.click();
        System.out.println("Entering Next Button...");
        Thread.sleep(1000);
        
        //Enter Password
        WebElement password =driver.findElement(By.cssSelector(".whsOnd.zHQkBf"));
        password.sendKeys("rishamtest1@");
        Thread.sleep(1000);
        
        //Click "Next"
        WebElement nextElem=driver.findElement(By.className("CwaK9"));
        nextElem.click();
        Thread.sleep(1000); 
        
		return new LoginPage();
	}
	
	
}
