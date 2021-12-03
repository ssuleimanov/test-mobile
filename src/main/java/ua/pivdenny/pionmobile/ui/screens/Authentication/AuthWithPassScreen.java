package ua.pivdenny.pionmobile.ui.screens.Authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;
import ua.pivdenny.pionmobile.ui.screens.Main.MainPageScreen;

public class AuthWithPassScreen extends BaseScreen {

    public AuthWithPassScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);

    }

    /*LOCATORS*/
    @AndroidFindBy(id = "txt_toolbar_title")
    private WebElement toolbarTitle;

    @AndroidFindBy(id = "input_target")
    private WebElement passwordField;

    @AndroidFindBy(id = "btn_password_visibility")
    private WebElement buttonToSeePasswordUnmasked;

    @AndroidFindBy(id = "btn_accept")
    private WebElement buttonNext;

    @AndroidFindBy(id = "btn_forgot_pass")
    private WebElement buttonForgotPassword;

    @AndroidFindBy(id = "btn_logout")
    private WebElement buttonLogout;


    /*ACTIONS*/

    public AuthWithPassScreen enterPassword(String password) {
        sendKeys(passwordField, password);
        return this;
    }

    public MainPageScreen clickOnButtonNext() {
        clickOnUiElement(buttonNext);
        return new MainPageScreen(appiumDriver);
    }

    public MainPageScreen enterPasswordAndLogin(String password) {
        enterPassword(password);
        clickOnButtonNext();
        return new MainPageScreen(appiumDriver);
    }


}
