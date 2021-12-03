package ua.pivdenny.pionmobile.ui.screens.Registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;
import ua.pivdenny.pionmobile.ui.screens.Authentication.AuthWithPassScreen;

public class RegOtpScreen extends BaseScreen {

    public RegOtpScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    /*LOCATORS*/
    @AndroidFindBy(id = "input_target")
    private WebElement otpInputField;

    @AndroidFindBy(id = "btn_accept")
    private WebElement otpConfirmButton;

    @AndroidFindBy(id = "btn_resend_code")
    private WebElement otpResendButton;


    /*ACTIONS*/
    public RegOtpScreen enterOtp(String otp) {
        sendKeys(otpInputField, otp);
        return this;
    }

    public RegOtpScreen clickOnOtpConfirmButton() {
        clickOnUiElement(otpConfirmButton);
        return this;
    }

    public AuthWithPassScreen clickOnOtpResendButton() {
        clickOnUiElement(otpResendButton);
        return new AuthWithPassScreen(appiumDriver);
    }

    public AuthWithPassScreen enterOtpAndClickOnConfirmButton(String otp) {
        enterOtp(otp);
        clickOnOtpConfirmButton();
        return new AuthWithPassScreen(appiumDriver);
    }

}


