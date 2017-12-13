package com.test.config;

import com.aventstack.extentreports.Status;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.reports.extent.settings.BaseReport;
import com.reports.extent.settings.GetScreenshot;
import com.wrapper.factory.BrowserFactory;
import org.junit.rules.*;
import org.junit.runner.*;
import org.openqa.selenium.*;
import org.junit.*;

import java.io.IOException;

public class BaseTest extends BaseReport {
    protected WebDriver driver;
    private Browsers.name browserName;
    private BrowserFactory browserFactory;
    private static String screenshotPath;

    public BaseTest(Browsers.name browserName){
        this.browserName = browserName;
        browserFactory = BrowserFactory.getInstance();
    }

    public void chooseDriverInstance(Browsers.name browserName){
        switch (browserName){
            case Firefox:
                driver = browserFactory.initBrowser(Browsers.name.Firefox);
                break;
            case Chrome:
                driver = browserFactory.initBrowser(Browsers.name.Chrome);
                break;
        }
    }

    @Rule
    public TestWatcher tw = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            test.fail("Error message: "+e.getMessage()+"\n in method: "+description);
        }
        @Override
        protected void succeeded(Description description) {
            test.pass("Passed: "+description);
        }
    };

    @BeforeClass
    public static void initReport(){
        startReport();
    }

    @Before
    public void initTest(){
        test = null;
        chooseDriverInstance(browserName);
        DriverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
    }

    @After
    public void endTest(){
        try {
            screenshotPath = GetScreenshot.capture(testCaseName);
            test.log(Status.INFO, "Snapshot below: "+
                    test.addScreenCaptureFromPath(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        browserFactory.CloseAllDrivers();
    }

    @AfterClass
    public static void endReport(){
        stopReport();
    }

}
