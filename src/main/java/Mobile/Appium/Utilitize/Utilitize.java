package Mobile.Appium.Utilitize;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Utilitize {

	AppiumDriver<MobileElement> driver;

	public Utilitize(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
	}

	private MobileElement findElement(MobileElement element) {

		MobileElement mobileElement = null;
		try {
			Wait<AppiumDriver<MobileElement>> wait = new FluentWait<AppiumDriver<MobileElement>>(driver)
					.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(500))
					.ignoring(NoSuchElementException.class);
			mobileElement = wait.until(new Function<AppiumDriver<MobileElement>, MobileElement>() {
				public MobileElement apply(AppiumDriver<MobileElement> input) {
					// TODO Auto-generated method stub
					return element;
				}
			});
		} catch (Exception e) {
		}

		return mobileElement;
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public boolean waitUntilVisible(MobileElement element, int waitTimeInSeconds) {

		boolean visible = false;

		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(findElement(element)));
			visible = true;
		} catch (Exception e) {

			visible = false;
		}
		return visible;
	}

	public boolean waitUntilInVisible(MobileElement webElement, int waitTimeInSeconds) {
		boolean visible = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			visible = wait.until(ExpectedConditions.invisibilityOf(findElement(webElement)));
		} catch (Exception e) {
			visible = false;
		}
		return visible;
	}

	public void openURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e2) {

		}
	}

	public void click(MobileElement element) {
		try {
			findElement(element).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isDisplayed(MobileElement element) {

		boolean isDispalyed = false;

		try {
			isDispalyed = findElement(element).isDisplayed();

		} catch (Exception e) {

		}

		return isDispalyed;
	}

	public void setText(MobileElement element, String inputValue) {

		try {
			element.sendKeys(inputValue);
		} catch (Exception e4) {
			throw e4;
		}
	}

	public String getText(MobileElement element) {

		String text = "";
		try {
			text = findElement(element).getText();

		} catch (Exception e4) {

		}

		return text;
	}

	public boolean isInteger(String percentageValue) {
		boolean isInteger = true;
		try {
			Integer.valueOf(percentageValue);
		} catch (Exception e) {
			isInteger = false;
		}
		return isInteger;
	}

	public void executeActions(Actions actions) {
		actions.build().perform();
	}

	public void scrollUp() {
		int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;
		Dimension size = driver.manage().window().getSize();
		endY = (int) (size.height * 0.70);
		startY = (int) (size.height * 0.30);
		startX = (size.width / 2);
		TouchAction<?> action = new TouchAction<AndroidTouchAction>(driver);
		action.press(PointOption.point(startX, startY))
		.waitAction()
		.moveTo(PointOption.point(endX, startY))
		.release()
		.perform();
	}
	
	public void scrollDown() {
		int startX = 0;
	    int startY = 0;
	    int endY = 0;
		Dimension size = driver.manage().window().getSize();
		startY = (int) (size.height * 0.70);
		endY = (int) (size.height * 0.30);
		startX = (size.width / 2);
		TouchAction<?> action = new TouchAction<AndroidTouchAction>(driver);
		action.press(PointOption.point(startX, startY))
		.waitAction()
		.moveTo(PointOption.point(startX, endY))
		.release()
		.perform();
	}
	
	public void hideKeyBoard() {
		
		driver.hideKeyboard();
	}

}