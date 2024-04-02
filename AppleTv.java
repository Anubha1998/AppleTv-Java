package com.lambdatest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AppleTv {

    public static String USERNAME = "anubhas";
    public static String ACCESS_KEY = "s0tLWr9RpxlsK4hqFdCoYklSTqEe4yYmsw447rDfQrSmU8lwcT";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("username", USERNAME);
        ltOptions.put("accessKey", ACCESS_KEY);
        ltOptions.put("Name", "TVOS-PROJECT");
        ltOptions.put("build", "TVOS-BUILD");
        ltOptions.put("sessionName", "TVOS-SESSION");
        ltOptions.put("networkLogs", true);
        ltOptions.put("platformName", "tvos");
        ltOptions.put("deviceName", "Apple TV");
        ltOptions.put("platformVersion", "16");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("video", true);
        ltOptions.put("visual", true);
        ltOptions.put("app", "lt://APP1016020161711965896259213");
        ltOptions.put("geoLocation", "FR");
        capabilities.setCapability("lt:options", ltOptions);

        AppiumDriver<MobileElement> driver = null;

        try {
            driver = new IOSDriver<MobileElement>(new URL("https://" + USERNAME + ":" + ACCESS_KEY +
                    "@mobile-hub-internal.lambdatest.com/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            System.out.println(driver.getPageSource());
            driver.getScreenshotAs(OutputType.FILE);

            System.out.println(driver.getSessionId());
            MobileElement element = (MobileElement) driver.switchTo().activeElement();
            String active = element.getAttribute("label");
            if (!active.equals("Keyboard")) {
                element = driver.findElement(MobileBy.AccessibilityId("EnterWebsiteName"));
                element.click();
                Thread.sleep(1000);
            }
            element = driver.findElement(MobileBy.AccessibilityId("EnterWebsiteName"));
            element.clear();
            Thread.sleep(1000);
//         element = driver.findElement(MobileBy.xpath("//XCUIElementTypeApplication[@name='chief.qaTvTestApp']/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextView/XCUIElementTypeOther/XCUIElementTypeOther"));
        element.sendKeys("https://ifconfig.me");

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Down");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Down");
            }});

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Down");
            }});

            element = (MobileElement) driver.switchTo().activeElement();
            element.click();
            Thread.sleep(1000);

            driver.executeScript("mobile: pressButton", new HashMap<String, Object>() {{
                put("name", "Right");
            }});

            element = (MobileElement) driver.switchTo().activeElement();
            element.click();
            Thread.sleep(3000);

            driver.executeScript("lambda-status=passed");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
