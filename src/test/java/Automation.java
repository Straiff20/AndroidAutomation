import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Automation {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
    }

    @AfterAll
    static void tearDown(){
        SelenideLogger.removeListener("AllureSelenide");
    }


    @Deprecated()
    @Test
    void firstTest() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage0", "com.apegroup.mcdonaldsrussia.debug");
        dc.setCapability("appActivity", "com.apegroup.mcdonaldsrussia.activities.main.MainActivity");

        AndroidDriver<AndroidElement> ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        //TODO: вставить ID из приложения

        MobileElement el1 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/tvAuth");
        el1.click();
        MobileElement el2 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/etPhone");
        el2.click();
        el2.sendKeys("9999999999");
        MobileElement el3 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/button");
        el3.click();
        MobileElement el4 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/tvCodeOne");
        el4.sendKeys("1111");
        MobileElement el5 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/tvCodeTwo");
        el5.sendKeys("1");
        MobileElement el6 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/tvCodeThree");
        el6.sendKeys("1");
        MobileElement el7 = (MobileElement) ad.findElementById("com.apegroup.mcdonaldsrussia.debug:id/tvCodeFour");
        el7.sendKeys("1");
        (new TouchAction(ad)).tap(795, 604).perform();
        (new TouchAction(ad)).tap(654, 1938).perform();

    }
}
