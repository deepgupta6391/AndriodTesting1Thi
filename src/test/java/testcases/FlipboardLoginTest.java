package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.ChooseTopicsScreen;
import screens.CreateAccountScreen;
import screens.LoginScreen;

public class FlipboardLoginTest extends TestBase{

	LoginScreen login;
	ChooseTopicsScreen topicScreen;
	
	@BeforeTest
	public void init() {
		
		setUp();
		login=new LoginScreen(driver);
		topicScreen=new ChooseTopicsScreen(driver);
	}
	
	@Test(priority = 1)
	public void validateGetStartedButton() {
		
		login.clickGetStartedBtn();
		
	}
	
	@Test(priority = 2)
	public void chooseTopicsTest() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		topicScreen.chooseOptions(4).clickContinue().skipCreateAccountScreen();
		//createAccount.skipCreateAccountScreen();
		Assert.fail();
		
	}
	
	@AfterTest
	public void quitDriver() {
		
		quit();
	}
}
