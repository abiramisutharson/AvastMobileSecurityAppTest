package com.avastsecurity.Test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.avastsecurity.utilities.ExtentReportUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class BaseTest {
	  protected static AppiumDriver driver;
	    protected static URL url;
	    protected static ExtentReports extent;
	    protected static ExtentTest test;
	    protected static final Logger logger = Logger.getLogger(BaseTest.class);

	    @BeforeSuite
	    public  void setupReport() {
	        ExtentReportUtil.initReport();

	    }

	    @BeforeClass
	    public  void setup() {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("udid", "nr6dcit4pvjzmrtc");
	        capabilities.setCapability("deviceName", "POCO C55");
	        capabilities.setCapability("appPackage", "com.avast.android.mobilesecurity");
	        capabilities.setCapability("appWaitActivity", "*");
	        capabilities.setCapability("automationName", "UiAutomator2");
	        capabilities.setCapability("appium:noReset", true);
	        try {
	            url = new URL("http://localhost:4723/");
	        } catch (MalformedURLException e) {
	            logger.error("Invalid URL: " + e.getMessage());
	        }
	        driver = new AndroidDriver(url, capabilities);
	        logger.info("Driver initialized");
	    }

	    @AfterClass
	    public  void tearDown() {
	        driver.quit();
	        logger.info("Driver quit");
	    }

	    @AfterSuite
	    public  void tearDownReport() {
	        ExtentReportUtil.flushReport();
	    }

	    protected WebDriverWait getWait() {
	        return new WebDriverWait(driver, 60);
	    }

	    public static void takeScreenshot(String screenshotName) {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(screenshot, new File("screenshots/" + screenshotName + ".png"));
	        } catch (IOException e) {
	            logger.error("Error taking screenshot: " + e.getMessage());
	        }
	    }
}