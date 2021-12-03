package ua.pivdenny.pionmobile;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import ua.pivdenny.pionmobile.utils.ProjectProperties;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseTest {

    public static AndroidDriver appiumDriver;
    private static AppiumDriverLocalService service;
    protected ProjectProperties properties;


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws InterruptedException {

        log.info("Starting setting up test suite...");
        startAppiumServer();

        log.info("Set up has been finished");

    }

    public static void startAppiumServer() throws InterruptedException {
//        if (!service.isRunning())
//        service = AppiumDriverLocalService.buildDefaultService();
//        else {
//            log.info("Appium server service is running, performing restart");
//            service.stop();
//            service.start();
//        }
//        if (service.isRunning()) log.info("Appium server has been started");
//        else log.info("Appium server has NOT been started");
//
        log.info("Appium server is going to start");
        service = AppiumDriverLocalService.buildDefaultService();
        service.stop();
        service.start();
        Thread.sleep(10000);
        log.info("Appium server has been started");
    }

    public static void startADB() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/startADB.sh");
        Thread.sleep(5000);
        log.info("ADB has been started");
    }


    public static void startEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/startEmulator.sh");
        Thread.sleep(5000);
        log.info("Android Emulator has been started");

    }

    public static void stopEmulator() throws IOException, InterruptedException {

        Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/stopEmulator.sh");
        Thread.sleep(5000);
        log.info("android Emulator has been stopped");
    }

    public boolean checkIfAppInstalled() {
        return appiumDriver.isAppInstalled("com.bank.pivdenny.dev");
    }

    public AppiumDriver getAndroidDriverAndCapabilities() throws IOException, InterruptedException {

        File appDir = new File("/Users/stanislav.suleimanov/Desktop/pion-mobile/src/main/resources");
        File app = new File(appDir, properties.getProperty("apkFile"));


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        capabilities.setCapability("platformName", properties.getProperty("platformName"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));


        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
      //  capabilities.setCapability("skipDeviceInitialization", true);
 //       capabilities.setCapability("noReset", true);


       capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("autoAcceptAlerts", true);

        if (properties.getProperty("deviceType").equalsIgnoreCase("real")) {
            capabilities.setCapability("deviceName", properties.getProperty("real_device_name"));
        }
        if (properties.getProperty("deviceType").equalsIgnoreCase("emulator")) {
            capabilities.setCapability("deviceName", properties.getProperty("emulator_device_name"));
            startEmulator();
        }

        appiumDriver = new AndroidDriver(capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return appiumDriver;
    }


//    private DesiredCapabilities iosCapabilities() {
//
//        this.capabilities = new DesiredCapabilities();
//        return capabilities;
//    }

//    @AfterSuite(alwaysRun = true)
//    public static void tearDown() throws IOException, InterruptedException {
//
//        appiumDriver.closeApp();
//        log.info("Test apk was closed");
//
//        stopEmulator();
//
//        if (appiumDriver != null) {
//            appiumDriver.quit();
//            log.info("Android driver has been quit");
//        }
//
//        if (service != null) {
//            service.stop();
//            log.info("Appium server has been stopped");
//        }
//
//    }


}
