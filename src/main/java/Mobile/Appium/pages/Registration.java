package Mobile.Appium.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Mobile.Appium.Utilitize.Utilitize;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Registration {

	Utilitize utilitize;

	SoftAssert softAssert;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_first_name")
	MobileElement firstName;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_last_name")
	MobileElement lastName;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_password")
	MobileElement password;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_confirm_password")
	MobileElement confirmPassword;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_email")
	MobileElement email;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_contact_no")
	MobileElement contact;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/btn_sign_up")
	MobileElement signUp;
	
	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/action_search")
	MobileElement search;
	
	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/search_src_text")
	MobileElement searchText;

	@AndroidFindBy(id = "com.eam360.maximomobile.technician:id/et_sign_up_time_zone")
	MobileElement timeZone;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Choose your options')]")
	MobileElement timeZoneHeading;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
	List<MobileElement> timeZoneOptions;

	public Registration(Utilitize utilitize) {
		this.utilitize = utilitize;
		PageFactory.initElements(new AppiumFieldDecorator(this.utilitize.getDriver()), this);
	}

	public void signUpNewUsers(String firstName1, String lastName1, String email1, String password1,
			String confirmPassword1, String searchText1, String contact1) throws MalformedURLException {

		utilitize.setText(firstName, firstName1);
		utilitize.setText(lastName, lastName1);
		utilitize.setText(email, email1);
		utilitize.setText(password, password1);
		utilitize.hideKeyBoard();
		utilitize.setText(confirmPassword, confirmPassword1);
		utilitize.hideKeyBoard();
		utilitize.click(timeZone);
		utilitize.waitUntilVisible(timeZoneHeading, 30);
		utilitize.click(search);
		utilitize.setText(searchText, searchText1);
		timeZoneOptions.get(0).click();
		/*boolean exitFlag = false;
		for (int i = 0; i < 100; i++) {
			for(int j = 0; j < timeZoneOptions.size(); j++) {
				String options = utilitize.getText(timeZoneOptions.get(j));
				//System.out.println(options);
				if(options.toLowerCase().contains("Cairo".toLowerCase())){
					utilitize.click(timeZoneOptions.get(j));
					exitFlag = true;
					break;
				}
				//1) compare with text received is true, 2) click, 3) set exitFlag = true, 4) break this loop
				
			}
			//check if exitflag is false /then scroll / else exist this loop
			
			if(!exitFlag) {
				utilitize.scrollDown();
			}else {
				break;
			}
		}*/
		
		utilitize.setText(contact, contact1);
		utilitize.hideKeyBoard();
		utilitize.click(signUp);

	}

}
