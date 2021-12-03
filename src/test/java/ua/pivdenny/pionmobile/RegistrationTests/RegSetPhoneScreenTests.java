package ua.pivdenny.pionmobile.RegistrationTests;

import io.appium.java_client.AppiumDriver;
import ua.pivdenny.pionmobile.BaseTest;
import ua.pivdenny.pionmobile.ui.screens.Registration.RegSetPhoneScreen;

import java.io.IOException;

public class RegSetPhoneScreenTests extends BaseTest {

    AppiumDriver appiumDriver = getAndroidDriverAndCapabilities();
    RegSetPhoneScreen regSetPhoneScreen = new RegSetPhoneScreen(appiumDriver);


    public RegSetPhoneScreenTests() throws IOException, InterruptedException {
    }



}
