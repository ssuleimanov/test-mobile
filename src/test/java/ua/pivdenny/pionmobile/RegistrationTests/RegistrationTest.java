package ua.pivdenny.pionmobile.RegistrationTests;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import ua.pivdenny.pionmobile.BaseTest;
import ua.pivdenny.pionmobile.ui.screens.Registration.RegSetPhoneScreen;

import java.io.IOException;

import static org.testng.Assert.fail;

public class RegistrationTest extends BaseTest {

    public RegistrationTest() throws IOException, InterruptedException {
    }

    AppiumDriver appiumDriver = getAndroidDriverAndCapabilities();
    RegSetPhoneScreen regSetPhoneScreen = new RegSetPhoneScreen(appiumDriver);

    @Test
    public void firstTest() {

        regSetPhoneScreen.enterPhoneAndClickConfirm("996593834").
                          enterOtpAndClickOnConfirmButton("123456").
                          enterPasswordAndLogin("Aval-2023");

    }
}
