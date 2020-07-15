package testcases;

import java.util.Hashtable;

import org.springframework.util.unit.DataUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import screens.ChooseTopicsScreen;
import screens.CreateAccountScreen;
import screens.LoginScreen;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class FlipboardLoginTest extends TestBase{

	LoginScreen login;
	ChooseTopicsScreen topicScreen;
	
	@BeforeTest
	public void init() {
		
		setUp();
		login=new LoginScreen(driver);
		topicScreen=new ChooseTopicsScreen(driver);
	}
	
	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "flipBoard")
	public void validateGetStartedButton(Hashtable<String, String> data) {
		
		ExcelReader excel=new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("FlipBoardSuite", "validateGetStartedButton", data.get("Runmode"), excel);
		
		login.clickGetStartedBtn();
		Assert.fail("Fail the testcase");
	}
	
	@Test(priority = 2,dataProviderClass = DataProviders.class, dataProvider = "flipBoard")
	public void chooseTopicsTest(Hashtable<String, String> data) {
		
		ExcelReader excel=new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("FlipBoardSuite", "chooseTopicsTest", data.get("Runmode"), excel);
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		topicScreen.chooseOptions(4).clickContinue().skipCreateAccountScreen();
				
	}
	
	@AfterTest
	public void quitDriver() {
		
		quit();
	}
}
