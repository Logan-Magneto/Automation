package Mobile.Appium.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Mobile.Appium.Utilitize.Utilitize;
import Mobile.Appium.pages.Login;
import Mobile.Appium.pages.Registration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class Scenario {
	
	@Test
	public void runApplication() throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.eam360.maximomobile.technician");
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		cap.setCapability("appActivity", "com.sedintechnologies.workbook.view.activity.SplashWithLoginActivity");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				cap);
		Thread.sleep(5000);
		SoftAssert softAssert = null;
		Utilitize utilitize = new Utilitize(driver);
		Login login = new Login(utilitize);
		Registration registration = new Registration(utilitize);
		
		try {
			
			login.signUp();
			registration.signUpNewUsers("hiyadhut", "goaltends", "hjskka@gmail.com", "password1_23", "password1_23", "Adelaide", "8988765432");
			
			}catch (Exception e) {
				
			}finally {
				softAssert.assertAll();
				//driver.quit();
			}
		
	}

}
