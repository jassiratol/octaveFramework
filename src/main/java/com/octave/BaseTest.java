package com.octave;

import org.testng.annotations.Test;

import com.octave.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	InputStream inputStream;
	
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
  @Parameters({"platformName","platformVersion","deviceName"})
  @BeforeTest
  public void beforeTest(String platformName, String platformVersion, String deviceName) throws Exception{
	  try {
		  props = new Properties();
		  String propFileName = "config.properties";
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(inputStream);
		  
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("platformVersion", platformVersion);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
			desiredCapabilities.setCapability("appPackage",  props.getProperty("androidAppPackageName"));
			desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
		    //desiredCapabilities.setCapability("avd", "Pixel_3");
			desiredCapabilities.setCapability("udid","emulator-5554");
		    URL appURL = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
		    desiredCapabilities.setCapability("app", appURL);
		    URL url = new URL(props.getProperty("appiumURL"));

		    driver = new AndroidDriver(url, desiredCapabilities) ;
		    String sessionId = driver.getSessionId().toString();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }

  }
  
  public void waitForVisibility(MobileElement e) {
	  WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
	  wait.until(ExpectedConditions.visibilityOf(e));
  }

  public void click(MobileElement e) {
	  waitForVisibility(e);
	  e.click();
  }
  
  public void sendKeys(MobileElement e, String keys) {
	  waitForVisibility(e);
	  e.sendKeys(keys);
  }
  
  public String getAttribute(MobileElement e, String attriute) {
	  waitForVisibility(e);
	 return  e.getAttribute(attriute);
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
