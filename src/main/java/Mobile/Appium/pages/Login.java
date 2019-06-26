package Mobile.Appium.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Mobile.Appium.Utilitize.Utilitize;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login {
	
	Utilitize utilitize;
	
	SoftAssert softAssert;
	
	@AndroidFindBy(id="com.eam360.maximomobile.technician:id/tv_splash_login_sign_up")
	MobileElement signUp;
	
	@AndroidFindBy(id="com.eam360.maximomobile.technician:id/et_splash_login_username")
	MobileElement userName;
	
	@AndroidFindBy(id="com.eam360.maximomobile.technician:id/et_splash_login_password")
	MobileElement password;
	
	@AndroidFindBy(id="com.eam360.maximomobile.technician:id/btn_splash_login_sign_in")
	MobileElement signIn;
	
	@AndroidFindBy(id="com.eam360.maximomobile.technician:id/btn_splash_login_google_sign_in")
	MobileElement google;
	
	@AndroidFindBy(id="com.eam360.maximomobile.technician:id/tv_splash_login_forgot_password")
	MobileElement forgotPassword;
	
	public Login(Utilitize utilitize) {
		this.utilitize = utilitize;
		PageFactory.initElements(new AppiumFieldDecorator(this.utilitize.getDriver()), this);
	}
	
	public void signUp() {
		
		utilitize.click(signUp);
		
	}
	
	
	

}
