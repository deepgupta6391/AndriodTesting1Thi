package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchScreen extends ScreenBase{
	
	@AndroidFindBy(id="flipboard.app:id/search_box_place_holder")
	public WebElement searchBox;
	
	@AndroidFindBy(id="flipboard.app:id/search_view_input")
	public WebElement searchInput;

	public SearchScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	public void searchFilpBoard(String searchText)
	{
		searchBox.click();
		searchInput.sendKeys(searchText);
		enter();
	}
}
