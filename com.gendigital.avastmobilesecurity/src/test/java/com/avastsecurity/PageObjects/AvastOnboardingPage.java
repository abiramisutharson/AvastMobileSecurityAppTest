package com.avastsecurity.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvastOnboardingPage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public AvastOnboardingPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/continue_free")
    private WebElement continueWithFreeButton;

    @AndroidFindBy(id = "com.avast.android.mobilesecurity:id/anchb_primary_button")
    private WebElement continueWithAdsButton;

    public void clickContinueWithFree() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithFreeButton)).click();
    }

    public void clickContinueWithAds() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithAdsButton)).click();
    }
}