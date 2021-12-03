package ua.pivdenny.pionmobile.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

@Slf4j
public class BaseScreen {

    protected AppiumDriver appiumDriver;

    public BaseScreen() {
    }


    public WebElement getElement(String id) {
        log.info("Get the element with id: '" + id + "'");
        return appiumDriver.findElement(By.id(id));
    }

    public WebElement getElementByName(String name) {
        log.info("Get the element with name: '" + name + "'");
        return appiumDriver.findElement(By.id(name));
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clearText(WebElement element) {
        String element_name = element.toString().split("-> id: ")[1].split("]")[0];
        log.info("Clearing the element: '" + element_name + "'");
        element.clear();
    }

    public void quitDriver() {
        log.info("Quit the driver");
        appiumDriver.quit();
    }

    public void closeDriver() {
        log.info("Close the driver");
        appiumDriver.close();
    }

    public void click(String id) {
        log.info("Clicking the element with id: '" + id + "'");
        try {
            getElement(id).click();
        } catch (Exception e) {
            log.error("Unable to click element with id: '" + id + "'");
            e.printStackTrace();
        }
    }

    public void clickOnUiElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickByName(String name) {
        log.info("Clicking the element with id: '" + name + "'");
        try {
            getElementByName(name).click();
        } catch (Exception e) {
            log.error("Unable to click element with id: '" + name + "'");
            e.printStackTrace();
        }
    }

    public void clickByXpath(String xpath) {
        log.info("Clicking on element with xpath: '" + xpath + "'");
        try {
            appiumDriver.findElement(By.xpath(xpath));
            getElement(xpath).click();
        } catch (Exception e) {
            log.error("Unable to click element with this xpath");
            e.printStackTrace();
        }
    }

    public List<WebElement> getElements(String locator) {
        try {
            log.info("Get the list of elements by locator: '" + locator + "'");
            return appiumDriver.findElementsByClassName(locator);
        } catch (Exception e) {
            log.error("Unable to found elements by this locator: '" + locator + "'");
            e.printStackTrace();
        }
        return null;
    }

    public void scrollToText(String scrollToText) {
        log.info("Scrolling to text: '" + scrollToText + "'");
        ((AndroidDriver) appiumDriver)
                .findElementByAndroidUIAutomator
                        ("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".scrollIntoView(new UiSelector()" +
                                ".textContains(\"" + scrollToText + "\").instance(0))");
    }

    public void swipeHorizontal(double startPercentage, double endPercentage, double anchorPercentage) {
        /* Left swipe (0.99, 0.01, 0.5)
         * Right swipe (0.01, 0.99, 0.5) */
        try {
            log.info("Performing horizontal swipe");
            Dimension size = appiumDriver.manage().window().getSize();
            int anchor = (int) (size.height * anchorPercentage);
            int startPoint = (int) (size.width * startPercentage);
            int endPoint = (int) (size.width * endPercentage);

            new TouchAction(appiumDriver)
                    .press(point(startPoint, anchor))
                    .waitAction(waitOptions(ofMillis(2000)))
                    .moveTo(point(endPoint, anchor))
                    .release().perform();
        } catch (Exception e) {
            log.error("Catch incorrect swipe");
        }

    }

    public void swipeVertical(double startPercentage, double endPercentage, double anchorPercentage) {
        /* Swipe up (0.9, 0.1, 0.5)
         * Swipe down (0.4, 0.9, 0.5) */
        try {
            log.info("Performing vertical swipe");
            Dimension size = appiumDriver.manage().window().getSize();
            int anchor = (int) (size.width * anchorPercentage);
            int startPoint = (int) (size.height * startPercentage);
            int endPoint = (int) (size.height * endPercentage);

            new TouchAction(appiumDriver)
                    .press(point(anchor, startPoint))
                    .waitAction(waitOptions(ofMillis(2000)))
                    .moveTo(point(anchor, endPoint))
                    .release().perform();
        } catch (Exception e) {
            log.error("Catch incorrect swipe");
        }
    }

    public void scrollToTextAndClickOnElement(String scrollToText) {
        log.info("Scrolling to text: '" + scrollToText + "'" + " and click the element.");
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true).instance(0)).scrollIntoView(new UiSelector()." +
                "textContains(\"" + scrollToText + "\").instance(0))")).click();
    }

    public void scrollToTextContainsElement(String scrollToText) {
        log.info("Scrolling to text contains element: '" + scrollToText + "'");
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                ".instance(0)).scrollIntoView(new UiSelector().textContains(\"" + scrollToText + "\").instance(0))"));
    }


}
