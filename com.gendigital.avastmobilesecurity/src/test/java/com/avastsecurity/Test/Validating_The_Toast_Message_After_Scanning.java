package com.avastsecurity.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.avastsecurity.PageObjects.AvastHomePage;
import com.avastsecurity.PageObjects.AvastOnboardingPage;
import com.avastsecurity.PageObjects.AvastScanPage;
import com.avastsecurity.utilities.ExtentReportUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Validating_The_Toast_Message_After_Scanning extends BaseTest {
	  AvastOnboardingPage onboardingPage;
	    AvastScanPage threatPage;
	    AvastHomePage homepage;

	    @BeforeClass
	    public void setupPages() {
	        onboardingPage = new AvastOnboardingPage(driver);
	        homepage = new AvastHomePage(driver);
	        threatPage = new AvastScanPage(driver);
	        ExtentTest test = ExtentReportUtil.createTest("Toast Validation");
	        test.log(Status.PASS, "Toast appeared as expected");
	    }

	    @Test
	    public void testToastMessageAfterScan() {
	        try {
	            onboardingPage.clickGetStartedButton();
	            test.info("Clicked Get Started button");
	            //onboardingPage.clickCancelButton();
	            test.info("Clicked Cancel button");
	            onboardingPage.clickAllowPermissionButton();
	            test.info("Clicked Allow Permission button");
	            onboardingPage.clickContinueWithFreeButton();
	            test.info("Clicked Continue With Free button");
	            homepage.clickStartScanButton();
	            test.info("Clicked Start Scan button");
	            onboardingPage.clickContinueWithAdsButton();
	            test.info("Clicked Continue With Ads button");
	           
	            homepage.clickPermissionRequiredOKButton();
	            test.info("Clicked Permission Required OK button");
	            homepage.clickStoragePermissionToggle();
	            test.info("Clicked Storage Permission toggle");
	            driver.navigate().back();
	            //homepage.clickScanAgainButton();
	            test.info("Clicked Scan Again button");
	            // Verify threat message
	            Assert.assertTrue(threatPage.isThreatMessageDisplayed());
	            test.info("Threat message displayed");
	            // Remove threat and click OK
	            threatPage.clickRemoveThreatButton();
	            test.info("Clicked Remove Threat button");
	            threatPage.clickOKButton();
	            test.info("Clicked OK button");
	            // Verify toast message
	            try {
	                WebElement toastMessage = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[1]")));
	                String message = toastMessage.getText();
	                test.info("Toast message: " + message);
	                Assert.assertNotNull(message);
	                test.pass("Test method passed");
	            } catch (TimeoutException e) {
	                test.fail("Toast message not found");
	                Assert.fail("Toast message not found");
	            }
	        } catch (Exception e) {
	            test.fail("Test method failed");
	            logger.error("Error occurred: " + e.getMessage());
	            takeScreenshot("testToastMessageAfterScan");
	            Assert.fail("Test method failed");
	        }
	    }
	}