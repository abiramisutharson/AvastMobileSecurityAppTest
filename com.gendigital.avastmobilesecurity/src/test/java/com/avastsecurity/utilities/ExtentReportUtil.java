package com.avastsecurity.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtil {
	  private static ExtentReports extent;
	    private static ExtentTest test;

	    public static void initReport() {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/extent-report.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	    public static ExtentTest createTest(String testName) {
	        test = extent.createTest(testName);
	        return test;
	    }

	    public static ExtentReports getExtent() {
	        return extent;
	    }

	    public static void flushReport() {
	        extent.flush();
	    }
}
