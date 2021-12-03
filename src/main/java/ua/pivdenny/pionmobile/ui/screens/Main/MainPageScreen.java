package ua.pivdenny.pionmobile.ui.screens.Main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;

public class MainPageScreen extends BaseScreen {

    public MainPageScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @AndroidFindBy(id = "btn_profile")
    private WebElement profileButton;

}
