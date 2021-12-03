package ua.pivdenny.pionmobile.ui.screens.Profile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;

public class UserProfileScreen extends BaseScreen {

    public UserProfileScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }



}
