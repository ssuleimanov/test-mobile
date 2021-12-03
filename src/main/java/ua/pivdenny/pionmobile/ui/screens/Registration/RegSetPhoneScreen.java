package ua.pivdenny.pionmobile.ui.screens.Registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;

public class RegSetPhoneScreen extends BaseScreen {


    public RegSetPhoneScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }


    @AndroidFindBy(id = "input_target")
    private WebElement phoneField;


    @AndroidFindBy(id = "btn_accept")
    private WebElement confirmButton;


    public RegSetPhoneScreen enterPhone(String phoneNumber) {
        sendKeys(phoneField, phoneNumber);
        return this;
    }

    public RegOtpScreen clickOnConfirmButton() {
        clickOnUiElement(confirmButton);
        return new RegOtpScreen(appiumDriver);
    }

    public RegOtpScreen enterPhoneAndClickConfirm(String phoneNumber) {
        enterPhone(phoneNumber);
        clickOnConfirmButton();
        return new RegOtpScreen(appiumDriver);
    }

}
