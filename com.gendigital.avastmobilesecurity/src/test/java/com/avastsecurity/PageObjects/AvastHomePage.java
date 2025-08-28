package com.avastsecurity.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvastHomePage {
    private AppiumDriver driver;
    private WebDriverWait wait;
    

    public AvastHomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 60);

    }

   
    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/action")
    private WebElement getStartedButton;
    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/cancel_action")
    private WebElement cancelButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowButton;

    public void clickGetStarted() {
        getStartedButton.click();
    }
    
   
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
    
    public void allowPermissions() {
        
            wait.until(ExpectedConditions.elementToBeClickable(allowButton)).click();
        
    }
}