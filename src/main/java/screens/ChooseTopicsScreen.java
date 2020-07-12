package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.ScreenBase;
import extentlisteners.ExtentListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseTopicsScreen extends ScreenBase{
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List<AndroidElement> topic;
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_continue_button")
	public WebElement pickerContinueButton;

	public ChooseTopicsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public ChooseTopicsScreen chooseOptions(int topicsCount)
	{
		for(int i=0;i<topicsCount;i++)
		{
			topic.get(i).click();
			ExtentListener.testReport.get().log(Status.INFO, "Selecting the topic "+topic.get(i).getText()+"\n");
		}
		
		return this;
	}
	
	public CreateAccountScreen clickContinue() 
	{
		pickerContinueButton.click();
		
		return new CreateAccountScreen(driver);
	}

}
