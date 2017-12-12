package com.test.config;

import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.files.properties.PropertiesReading;
import com.reports.extent.settings.BaseReport;
import com.wrapper.factory.BrowserFactory;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.junit.*;

public class BaseTest extends BaseReport {
    protected WebDriver driver;
    private Browsers.name browserName;
    private BrowserFactory browserFactory;
    protected static String testSuiteName;

    public BaseTest(Browsers.name browserName, String testSuiteNamee){
        testSuiteName = testSuiteNamee;
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
            test.fail("Error message: "+e.getMessage()+"\nin method: "+description);
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
        browserFactory.CloseAllDrivers();
    }

    @AfterClass
    public static void endReport(){
        stopReport();
    }

}
