package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	private static AppiumDriver<MobileElement> driver;
	private static URL serverUrl;
	private static DesiredCapabilities capabilities=new DesiredCapabilities();
	private static String APPIUM_PORT;
	private static int IMPLICIT_WAIT_TIME;
	private static int EXPLICIT_WAIT_TIME;
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
	private static String APP_PATH;
	private static String BROWSER_NAME;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	private static String UDID;
	private static String BUNDLE_ID;
	private static String APP;
	
	
	private static Properties prop=new Properties();
	private static FileInputStream fis;

	public static void loadAndroidConfProp(String loadPropertyFile) {
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+loadPropertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IMPLICIT_WAIT_TIME=Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME=Integer.parseInt(prop.getProperty("explicit.wait"));
		BASE_PKG=prop.getProperty("base.pgk");
		APP_ACTIVITY=prop.getProperty("application.activity");
		APP_PATH=prop.getProperty("application.path");
		BROWSER_NAME=prop.getProperty("browser.name");
		PLATFORM_NAME=prop.getProperty("Android");
		DEVICE_NAME=prop.getProperty("Android Emulator");
		PLATFORM_VERSION=prop.getProperty("platform.version");
		APPIUM_PORT=prop.getProperty("appium.server.port");
		
	}

	public static void setAndroidCapabilities() {

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,PLATFORM_NAME);
		//capabilities.setCapability(CapabilityType.BROWSER_NAME,BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
	}

	public static void loadIOSConfProp(String loadPropertyFile) {

	}

	public static void setIOSCapabilities() {

	}
	

	public static AppiumDriver<MobileElement> getAndroidDriver() {

		try {
			serverUrl=new URL("http://localhost:"+APPIUM_PORT+"/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver=new AndroidDriver<MobileElement>(serverUrl, capabilities);
		return driver;
	}

	public static AppiumDriver<MobileElement> getIOSDriver() {

		return driver;
	}

	public static long getIMPLICIT_WAIT_TIME() {
		return IMPLICIT_WAIT_TIME;
	}

		
	
		

	
	
	
	

}
