package com.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.frameworkBase.BasePage;

public class AccountHolderEmailPage extends BasePage {

	public AccountHolderEmailPage waitUntilPageLoadComplete() {	
		
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	        };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);  
	
		return new AccountHolderEmailPage();
	}
	
	public AccountHolderEmailPage composeEmail() throws Exception{
		//Click "Compose" email button
        WebElement compose= driver.findElement(By.cssSelector(".T-I.J-J5-Ji.T-I-KE.L3"));
        compose.click();
        Thread.sleep(1000);
        
        //Click on "To" field
        WebElement toField2=driver.findElement(By.name("to"));
        toField2.sendKeys("rishamtestemail@gmail.com");
        Thread.sleep(1000);
        
        //Click on "Subject" field
        WebElement subjectField= driver.findElement(By.name("subjectbox"));
        System.out.println("Entering Subject Field");
        subjectField.sendKeys("Hello Message");
        Thread.sleep(1000);
        
        //Click on "Message Body" Field    
        WebElement message =driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        message.sendKeys("This is an auto-generated mail!!!");
        Thread.sleep(1000); 

        //Click on "Send" email button
        WebElement sendMail=driver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3"));
        System.out.println("Sending Email");
        sendMail.click();
        Thread.sleep(2000); 
        
        return new AccountHolderEmailPage();
        
	}
	
	
	public AccountHolderEmailPage verifyEmailSendSuccessMessage() {
		WebElement emailSentConfirmation = driver.findElement(By.cssSelector(".b8 > div:nth-child(1) > div:nth-child(2)"));
		System.out.println(emailSentConfirmation.getText());
		assertEquals(emailSentConfirmation.getText(), "Your message has been sent. View message");
		return new AccountHolderEmailPage();
	}
	
	public AccountHolderEmailPage signout(){
		WebElement myEmailLogo=driver.findElement(By.cssSelector(".gb_fb"));
        myEmailLogo.click();
        driver.findElement(By.id("gb_71")).click();       //Clicking Signout Element
		return new AccountHolderEmailPage();
	}
	
	public AccountHolderEmailPage verifyLogout(){
		//Now Verify logout is successful
        WebElement forgotPasswordElem = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf((driver.findElement(By.id("forgotPassword")))));
        Assert.assertNotNull(forgotPasswordElem);
		return new AccountHolderEmailPage();
	}
	
	public AccountHolderEmailPage openUnReadEmail() throws Exception {
		// Click on "Inbox"
		WebElement inboxElem = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/#inbox']"));
		System.out.println("Clicking Inbox");
		inboxElem.click();
		Thread.sleep(1000);

		// Select the new UNREAD received email
		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement senderName = driver.findElement(By.className("zF"));
		// Performing Click on senderName using JavascriptExecutor
		js.executeScript("arguments[0].click();", senderName);
		Thread.sleep(1000);
				
		return new AccountHolderEmailPage();
	}
}
