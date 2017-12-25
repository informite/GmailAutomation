package com.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.frameworkBase.BasePage;

public class NewMessagePage extends BasePage {
	public NewMessagePage waitUntilPageLoadComplete() {	
		
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
        };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);  

	return new NewMessagePage();
}
	public NewMessagePage verifyEmailText() throws Exception{
		//Verify the email body text
		WebElement emailBody=driver.findElement(By.xpath("//div[@dir='ltr' and contains(text(),'This is an auto-generated mail!!!')]"));
		 for (int i=0;i<4;i++) {
			    WrapsDriver wrappedElement=(WrapsDriver) emailBody;
				JavascriptExecutor jse=(JavascriptExecutor) wrappedElement.getWrappedDriver();
				Thread.sleep(2000);
				jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", emailBody, "color: yellow; border: 2px solid yellow;");
		        jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", emailBody, "");
				 }
				System.out.println(emailBody.getText());
				
				assertEquals("This is an auto-generated mail!!!", emailBody.getText());
				
				return new NewMessagePage();
	}

}
