package com.avastsecurity.Test;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.avastsecurity.PageObjects.AvastHomePage;
import com.avastsecurity.PageObjects.AvastOnboardingPage;
import com.avastsecurity.PageObjects.AvastScanPage;
import com.avastsecurity.utilities.ExtentReportListener;

public class Validating_The_Toast_Message_After_Scanning extends BaseTest {
    private static final Logger logger = Logger.getLogger(Validating_The_Toast_Message_After_Scanning.class);
    private AvastHomePage avastHomePage;
    private AvastOnboardingPage avastOnboardingPage;
    private AvastScanPage avastScanPage;
    private SoftAssert softAssert;

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logPass(String message) {
        logger.info(message);
    }

    public void logFail(String message) {
        logger.error(message);
    }

   

    @Test
    public void testScan() {
        logInfo("Starting testScan test case");
        
        avastHomePage = new AvastHomePage(driver);
       avastHomePage.clickGetStarted();
        logInfo("Clicking Get Started button");

        logPass("Get Started button clicked successfully");
        avastOnboardingPage = new AvastOnboardingPage(driver);


        //logInfo("Clicking Cancel button");
       // avastHomePage.clickCancel();
        //logPass("Cancel button clicked successfully");
        logInfo("Allowing permissions");
        avastHomePage.allowPermissions();
        logPass("Permissions allowed successfully");
        logInfo("Clicking Continue with Free button");
        avastOnboardingPage.clickContinueWithFree();
        avastScanPage = new AvastScanPage(driver);

        logPass("Continue with Free button clicked successfully");
       
        logInfo("Clicking Start Scan button");
        avastScanPage.clickStartScan();
        logPass("Start Scan button clicked successfully");
        logInfo("Clicking Continue with Ads button");
        avastOnboardingPage.clickContinueWithAds();
        logPass("Continue with Ads button clicked successfully");
        logInfo("Clicking Permission Required OK button");
        avastScanPage.clickPermissionRequiredOK();
        logPass("Permission Required OK button clicked successfully");
        logInfo("Clicking Storage Permission Toggle");
        avastScanPage.clickStoragePermissionToggle();
        logPass("Storage Permission Toggle clicked successfully");
        driver.navigate().back();
        logInfo("Navigated back");
//        logInfo("Clicking Scan Again button");
//        avastScanPage.clickScanAgain();
//        logPass("Scan Again button clicked successfully");
        logInfo("Verifying threat displayed");
        softAssert.assertTrue(avastScanPage.isThreatDisplayed(), "Threat not displayed");
        logPass("Threat displayed successfully");
        logInfo("Clicking Remove button");
        avastScanPage.clickRemove();
        logPass("Remove button clicked successfully");
        logInfo("Clicking OK button");
        avastScanPage.clickOK();
        logPass("OK button clicked successfully");
        logInfo("Validating toast message");
        avastScanPage.validateToastMessage("The selected threats have been removed");
        logPass("Toast message validated successfully");
        logInfo("Test case completed successfully");
        softAssert.assertAll();
    }

   
}

