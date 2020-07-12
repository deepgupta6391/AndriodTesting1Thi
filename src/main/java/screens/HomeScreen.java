package screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase{
	
	@AndroidFindBys(
			{
				@AndroidBy(id="flipboard.app:id/sliding_title_strip_container"),
				@AndroidBy(id="flipboard.app:id/sliding_title_text_view")
			})
	public List<AndroidElement> title;
	
	@AndroidFindBy(id="flipboard.app:id/sliding_title_text_view")
	public List<AndroidElement> bottomNavigation;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	

	public void gotoTitleSection(int sectionCount)
	{
		title.get(sectionCount-1).click();
	}
	
	public void selectBottomPanel(int screenNo)
	{
		bottomNavigation.get(screenNo-1).click();
	}

}
