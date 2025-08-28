package com.avastsecurity.utilities;

import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	public class ScreenshotUtil {
	    public static void takeScreenshot(WebDriver driver, String screenshotName) {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(screenshot, new File("screenshots/" + screenshotName + ".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
