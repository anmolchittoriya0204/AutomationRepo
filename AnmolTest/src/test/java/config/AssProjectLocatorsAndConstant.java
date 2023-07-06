package config;

import org.openqa.selenium.By;

public interface AssProjectLocatorsAndConstant {

	// login
	By LOGIN_EMAIL_EDITBOX = By.xpath("//div[@class='mod-input mod-login-input-email mod-input-email']/input");
	By FULLNAME__EDITBOX = By.xpath("//input[@placeholder='First Last']");
	By PASSWORD_EDIT_BOX = By.xpath("//div[@class='mod-input mod-input-password mod-login-input-password mod-input-password']/input");
	By SIGN_UP_WITH_EMAIL_BUTTON = By.xpath("//button[@class='next-btn next-btn-secondary next-btn-large']");
	By SLIDER_BUTTON = By.xpath("//span[@class='nc_iconfont btn_slide']");
	By SIGN_UP_BUTTON = By.xpath("//div[@class='mod-login-btn']/button");
	By VERIFICATION_CODE_EDITBOX = By.xpath("//div[@class='mod-login-sms']//input");
	

	// Description
	String Des_verifyLoginAppTC = "Verification of login flow with OTP";
}
