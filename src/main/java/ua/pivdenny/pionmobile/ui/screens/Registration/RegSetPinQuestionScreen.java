package ua.pivdenny.pionmobile.ui.screens.Registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;

public class RegSetPinQuestionScreen extends BaseScreen {

    public RegSetPinQuestionScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @AndroidFindBy(id = "btn_accept")
    private WebElement acceptButton;

    @AndroidFindBy(id = "btn_later")
    private WebElement laterButton;


}
