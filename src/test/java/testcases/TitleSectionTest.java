package testcases;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import screens.ChooseTopicsScreen;
import screens.CreateAccountScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import utilities.CommonUtils;
import utilities.ScrollUtil;

public class TitleSectionTest extends TestBase {

	LoginScreen login;
	ChooseTopicsScreen topicScreen;
	CreateAccountScreen createAccount;
	HomeScreen home;

	@BeforeTest
	public void init() {

		setUp();
		login = new LoginScreen(driver);
		//topicScreen = new ChooseTopicsScreen(driver);
		//createAccount = new CreateAccountScreen(driver);
		home = new HomeScreen(driver);
	}

	@Test
	public void validateTitle() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.clickGetStartedBtn().chooseOptions(5).clickContinue().skipCreateAccountScreen();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		home.gotoTitleSection(1);
		//takeScreenshot();
		ScrollUtil.scrollUp(2, (AndroidDriver) driver);

	}

	@AfterTest
	public void quitDriver() {

		quit();
	}
	
	
	
	
}
