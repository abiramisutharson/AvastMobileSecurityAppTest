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

public class AvastHomePage {
	   WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(id = "com.avast.android.mobilesecurity:id/button")
	    WebElement startScanButton;

	    @FindBy(id = "com.avast.android.mobilesecurity:id/btn_positive")
	    WebElement permissionRequiredOKButton;

	    @FindBy(id = "android:id/switch_widget")
	    WebElement storagePermissionToggle;

	    @FindBy(id = "com.avast.android.mobilesecurity:id/scan_again")
	    WebElement scanAgainButton;

	    public AvastHomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, 60);
	    }

	    public void clickStartScanButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(startScanButton)).click();
	    }

	    public void clickPermissionRequiredOKButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(permissionRequiredOKButton)).click();
	    }

	    public void clickStoragePermissionToggle() {
	        wait.until(ExpectedConditions.elementToBeClickable(storagePermissionToggle)).click();
	    }

	    public void clickScanAgainButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(scanAgainButton)).click();
	    }
}