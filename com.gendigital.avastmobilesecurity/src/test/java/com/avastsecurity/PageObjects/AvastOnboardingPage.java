package com.avastsecurity.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvastOnboardingPage {
	WebDriver driver;
    WebDriverWait wait;
    public AvastOnboardingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
    }
    @FindBy(id = "com.avast.android.mobilesecurity:id/action")
    WebElement getStartedButton;

    @FindBy(id = "com.avast.android.mobilesecurity:id/cancel_action")
    WebElement cancelButton;
    
    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    WebElement allowPermissionButton;
    
    @FindBy(id = "com.avast.android.mobilesecurity:id/continue_free")
    WebElement continueWithFreeButton;
    
    @FindBy(id = "com.avast.android.mobilesecurity:id/anchb_primary_button")
    WebElement continueWithAdsButton;

   

    public void clickGetStartedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(getStartedButton)).click();
    }
    

    public void clickCancelButton() {
    wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
    
    

    public void clickAllowPermissionButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowPermissionButton)).click();
        } catch (Exception e) {
            System.out.println("No permission pop-up found");
        }
    }
    
   

    public void clickContinueWithFreeButton() {
    wait.until(ExpectedConditions.elementToBeClickable(continueWithFreeButton)).click();
    }
    
  

    public void clickContinueWithAdsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithAdsButton)).click();
}
}