package net.axis.automaiton;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.axis.automation.pages.LoginPage;
import net.axis.automation.utils.Utils;

import java.io.IOException;
import java.net.URL;

public class BaseTestClass {

    AndroidDriver<MobileElement> driver;
    ExtentReports reports;
    ExtentTest logger;
    LoginPage loginPage;

    @BeforeTest
    public void initReports() {
        reports = new ExtentReports(System.getProperty("user.dir")+"/Reporting/TestReport.html", true);
    }

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nexus_One_API_22");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1.1");

        capabilities.setCapability("appPackage", "com.axis.net");
        capabilities.setCapability("appActivity", "com.axis.net.ui.splashLogin.SplashActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void beforeMethodTest() {
        loginPage = new LoginPage(driver);
    }


    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            String screenShotPath = Utils.screenShot(driver, result.getMethod().getDescription().replace(" ", "_").toLowerCase());
            logger.log(LogStatus.FAIL, result.getMethod().getDescription()+logger.addScreenCapture(screenShotPath));
        } else {
            logger.log(LogStatus.PASS, result.getMethod().getDescription());
        }
        reports.endTest(logger);
    }

    @AfterClass
    public void closeApp() {
        reports.flush();
        reports.close();
        tunggu(1);
        driver.quit();
    }


    public void tunggu(int detik) {
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void scroll(int startX, int startY, int endX, int endY) {
        AndroidTouchAction touchAction = new AndroidTouchAction(driver);
        touchAction.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}
