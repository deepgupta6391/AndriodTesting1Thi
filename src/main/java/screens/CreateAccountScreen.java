package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateAccountScreen extends ScreenBase{

	
	@AndroidFindBy(id="flipboard.app:id/account_login_buttons_skip")
	public WebElement skipButton;
	
	public CreateAccountScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public HomeScreen skipCreateAccountScreen()
	{
		skipButton.click();
		
		return new HomeScreen(driver);
	}

}
