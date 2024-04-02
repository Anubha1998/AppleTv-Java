package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class FireTv {

    public static DesiredCapabilities getCaps() {
        DesiredCapabilities Capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("deviceName", "Amazon Fire TV Stick");
        ltOptions.put("platformVersion", "7");
        ltOptions.put("platformName", "fireos");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("build", "firetv");
        ltOptions.put("video", true);
        ltOptions.put("app", "lt://APP1016020161712050918939233");
        ltOptions.put("network", false);
     //   ltOptions.put("geoLocation", "RU");
        ltOptions.put("devicelog", true);
        ltOptions.put("visual", true);
        ltOptions.put("w3c", true);
//        ltOptions.put("automationName","UIAutomator2");
        ltOptions.put("appiumVersion","2.0");
        Capabilities.setCapability("lt:options", ltOptions);
        return Capabilities;
    }

    public static void runTest() {
        String USERNAME = "anubhas";
        String ACCESS_KEY = "s0tLWr9RpxlsK4hqFdCoYklSTqEe4yYmsw447rDfQrSmU8lwcT";
        String gridUrl = "mobile-hub-internal.lambdatest.com/wd/hub";

        DesiredCapabilities desiredCapabilities = getCaps();
        String url = "http://" + USERNAME + ":" + ACCESS_KEY + "@" + gridUrl;

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
            System.out.println("Initiating remote driver on platform: " + desiredCapabilities.getCapability("deviceName") + " browser: " + " version: " + desiredCapabilities.getCapability("platformVersion"));

            ((RemoteWebDriver) driver).getSessionId();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            WebElement inputField = driver.findElement(By.id("enterText"));
            inputField.sendKeys("https://ifconfig.me");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            inputField = driver.findElement(By.id("JustAButton"));
            inputField.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            WebElement list2 = driver.findElement(By.xpath("//*[@resource-id='ip_address_cell']"));
            System.out.println(list2.getText());

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            ((RemoteWebDriver) driver).executeScript("lambda-status=passed");
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void main(String[] args) {
        runTest();
    }
}
