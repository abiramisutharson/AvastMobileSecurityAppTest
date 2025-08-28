package com.avastsecurity.Test;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public AppiumDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setup() {
        try {
            // Set up desired capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "nr6dcit4pvjzmrtc");
            capabilities.setCapability("deviceName", "POCO C55");
            capabilities.setCapability("appPackage", "com.avast.android.mobilesecurity");
            capabilities.setCapability("appWaitActivity", "*");
            capabilities.setCapability("appium:noReset", true);
            capabilities.setCapability("automationName", "UiAutomator2"); 

            // Create driver instance
            URL url = new URL("http://localhost:4723/");
            driver = new AppiumDriver(url, capabilities);
            System.out.println("Driver initialized successfully");

            // Set up wait
            wait = new WebDriverWait(driver, 60);
            System.out.println("Wait initialized successfully");
        } catch (Exception e) {
            System.out.println("Error in setup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void teardown() {
        try {
            if (driver != null) {
                // Quit driver instance
                driver.quit();
                System.out.println("Driver quit successfully");
            }
        } catch (Exception e) {
            System.out.println("Error in teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}