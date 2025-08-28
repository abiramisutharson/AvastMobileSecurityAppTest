package com.avastsecurity.PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AvastScanPage {
	WebDriver driver;
    WebDriverWait wait;
    public AvastScanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 60);
    }
    
    @FindBy(xpath = "(//android.widget.Button[@resource-id=\"com.avast.android.mobilesecurity:id/buttons_group_button_primary\"])[1]")
    WebElement removeThreatButton;
    
    @FindBy(id = "android:id/button1")
    WebElement okButton;
    
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.avast.android.mobilesecurity:id/generic_card_subtitle_first\" and @text=\"AV Test App contains malicious code. Remove it now.\"]")
    WebElement threatMessage;

    public void clickRemoveThreatButton() {
    wait.until(ExpectedConditions.elementToBeClickable(removeThreatButton)).click();
    }
   

    public void clickOKButton() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }
    
    
    public boolean isThreatMessageDisplayed() {
    	  try {
    	        wait.until(ExpectedConditions.visibilityOf(threatMessage));
    	        return true;
    	    } catch (Exception e) {
    	        return false;
    	    }
    }
}
