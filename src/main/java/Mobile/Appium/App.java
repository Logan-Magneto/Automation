package Mobile.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.eam360.maximomobile.technician");
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		cap.setCapability("appActivity", "com.sedintechnologies.workbook.view.activity.SplashWithLoginActivity");
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				cap);
		Thread.sleep(5000);
		try {
			driver.findElementById("com.eam360.maximomobile.technician:id/et_splash_login_username").sendKeys("test");
			driver.findElementById("com.eam360.maximomobile.technician:id/et_splash_login_password").sendKeys("test");
			driver.findElementById("com.eam360.maximomobile.technician:id/btn_splash_login_sign_in").click();
		} catch (Exception e) {

		} finally {
			driver.quit();
		}
	}
}
