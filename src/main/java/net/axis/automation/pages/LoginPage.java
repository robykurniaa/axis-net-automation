package net.axis.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
public class LoginPage {

    AndroidDriver<MobileElement> driver;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    By btnLogin = By.id("com.axis.net:id/btnLogin");
    By btnAllow = By.id("com.axis.net:id/btnAllow");
    By btnpermission = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By btnAllowPhoneCals = By.id("com.android.permissioncontroller:id/permission_allow_button");
    By getTextLogin = By.id("com.axis.net:id/forgotMsisdn");

    //login to AXIS NET
    By fillNumberPhone = By.id("com.axis.net:id/edtNomorHp");
    By btnNext = By.id("com.axis.net:id/btnNext");
    By enterOtp = By.id("com.axis.net:id/vOtp");
    By btnNextOtp = By.id("com.axis.net:id/btnNextOtp");
    By expandTitle = By.id("com.axis.net:id/expandTitle");

    public void goToAxisNet() {
        tunggu(10);
        driver.findElement(btnLogin).click();
        tunggu(2);
//        driver.findElement(btnAllow).click();
//        tunggu(2);
//        driver.findElement(btnpermission).click();
//        tunggu(2);
//        driver.findElement(btnAllowPhoneCals).click();
//        tunggu(3);
    }

    public String getTextLogin() {
        tunggu(2);
        return driver.findElement(getTextLogin).getText();

    }

    public void loginAxisNet(String phoneNumber, String fillOtp) {
        tunggu(2);
        driver.findElement(fillNumberPhone).sendKeys(phoneNumber);
        tunggu(2);
        driver.findElement(btnNext).click();
        tunggu(2);
        driver.findElement(enterOtp).sendKeys(fillOtp);
        tunggu(2);
        driver.findElement(btnNextOtp).click();
        tunggu(2);
    }

    public String getTextHome() {
    return driver.findElement(expandTitle).getText();
    }


    public void tunggu(int detik) {
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
