package ua.pivdenny.pionmobile.ui.screens.Registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ua.pivdenny.pionmobile.ui.BaseScreen;

public class RegSetPassRepeatScreen extends BaseScreen {

    public RegSetPassRepeatScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @AndroidFindBy(id = "btn_1")
    private WebElement button1;

    @AndroidFindBy(id = "btn_2")
    private WebElement button2;

    @AndroidFindBy(id = "btn_3")
    private WebElement button3;

    @AndroidFindBy(id = "btn_4")
    private WebElement button4;

    @AndroidFindBy(id = "btn_5")
    private WebElement button5;

    @AndroidFindBy(id = "btn_6")
    private WebElement button6;

    @AndroidFindBy(id = "btn_7")
    private WebElement button7;

    @AndroidFindBy(id = "btn_8")
    private WebElement button8;

    @AndroidFindBy(id = "btn_9")
    private WebElement button9;

    @AndroidFindBy(id = "btn_0")
    private WebElement button0;

    @AndroidFindBy(id = "btn_backspace")
    private WebElement buttonBackspace;

}
