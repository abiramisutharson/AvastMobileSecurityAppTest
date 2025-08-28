package com.avastsecurity.PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AvastScanPage {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(AvastScanPage.class);


    public AvastScanPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/button")
    private WebElement startScanButton;

    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/scan_again")
    private WebElement scanAgainButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.avast.android.mobilesecurity:id/generic_card_subtitle_first\" and @text=\"AV Test App contains malicious code. Remove it now.\"]")
    private WebElement threat;

    @AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.avast.android.mobilesecurity:id/buttons_group_button_primary\"])[1]")
    private WebElement removeButton;
    
    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/btn_positive")
    private WebElement permissionRequiredOK;
    @AndroidFindBy(id = "android:id/switch_widget")
    private WebElement storagePermissionToggle;
    
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    private WebElement toastMessage;
    
    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;

    public void clickOK() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    public void clickStoragePermissionToggle() {
    storagePermissionToggle.click();
    }
    

    public void clickPermissionRequiredOK() {
        wait.until(ExpectedConditions.elementToBeClickable(permissionRequiredOK)).click();
    }


    public void clickStartScan() {
        wait.until(ExpectedConditions.elementToBeClickable(startScanButton)).click();
    }

    public void clickScanAgain() {
        wait.until(ExpectedConditions.elementToBeClickable(scanAgainButton)).click();
    }

    public boolean isThreatDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(threat)).isDisplayed();
    }

    public void clickRemove() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }
    
   

    public String getToastMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(toastMessage)).getText();
        } catch (Exception e) {
            logger.error("Failed to get toast message", e);
            return null;
        }
    }

    public void validateToastMessage(String expectedMessage) {
        String actualMessage = getToastMessage();
        logger.info("Toast message: " + actualMessage);
        Assertions.assertEquals(expectedMessage, actualMessage);
        logger.info("Toast message validated successfully");
    }
}
