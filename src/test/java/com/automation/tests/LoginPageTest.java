package com.automation.tests;

import org.testng.annotations.Test;

import com.automation.frameworkBase.BasePage;
import com.automation.pages.AccountHolderEmailPage;
import com.automation.pages.LoginPage;
import com.automation.pages.NewMessagePage;

public class LoginPageTest extends BasePage {
	LoginPage myLoginPage= new LoginPage();
	AccountHolderEmailPage myAcctEmailPage= new AccountHolderEmailPage();
	NewMessagePage myNewMessagePage =new NewMessagePage();
	/**
	 * This test Automates Sending Email through Gmail Account
	 * @throws Exception
	 */
	@Test(enabled = true,priority=1)
	public void sendingEmailTest() throws Exception{
		myLoginPage.goto_theGmailWebsite();
		myLoginPage.enterCredentials();
		
		myAcctEmailPage.waitUntilPageLoadComplete();
		myAcctEmailPage.composeEmail();
		myAcctEmailPage.verifyEmailSendSuccessMessage();
		myAcctEmailPage.signout();
	}
	
    /**
	 * This test Automates verification of received email in the inbox folder
	 * @throws Exception
	 */
	@Test(enabled = true,priority=2)
	public void verifyEmailReceived() throws Exception  {
		myLoginPage.goto_theGmailWebsite();
		myLoginPage.enterCredentials();
		
		myAcctEmailPage.waitUntilPageLoadComplete();
		myAcctEmailPage.openUnReadEmail();
		
		myNewMessagePage.waitUntilPageLoadComplete();
		myNewMessagePage.verifyEmailText();
		
	}

}
