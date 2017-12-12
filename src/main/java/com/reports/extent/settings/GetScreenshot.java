package com.reports.extent.settings;

import com.wrapper.factory.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class GetScreenshot {
    public static String capture(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) BrowserFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/errorScreenshots/"+screenshotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(src, destination);
        return dest;
    }
}
