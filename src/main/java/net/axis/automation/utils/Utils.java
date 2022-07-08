package net.axis.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class Utils {
    public static String screenShot(AndroidDriver<MobileElement> driver, String screenShotName) throws IOException {
        String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/FailedTestScreenshot/"+screenShotName+"_"+datename+".png";
        File destinastion = new File(dest);
        FileUtils.copyFile(source, destinastion);
        return dest;
    }
}
